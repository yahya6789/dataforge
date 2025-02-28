package io.github.yahya6789.dataforge.template;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;

import io.github.yahya6789.dataforge.shared.FileUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * Class abstrak untuk menghasilkan CSV. Menggunakan pola template method untuk
 * memastikan struktur yang konsisten.
 */
@Slf4j
public abstract class CsvTemplate implements IFileTemplate {
  public static final String DELIMITER = "|";
  public static final int THREAD_POOL_SIZE = 8;

  private final String lineEnding = System.lineSeparator();
  private final ExecutorService executorService;

  /**
   * Constructor CsvTemplate.
   */
  @SneakyThrows
  public CsvTemplate() {
    this.executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
  }

  /**
   * Mengembalikan header file CSV.
   *
   * @return String yang berisi header CSV.
   */
  protected abstract String getHeaders();

  /**
   * Mengembalikan baris detail CSV berdasarkan baris indeks.
   *
   * @param rowIndex Indeks baris yang diproses.
   * @return A delimited string representing the detail row.
   */
  protected abstract String generateDetail();

  /**
   * Menghasilkan baris total yang berisi aggregate seperti sum dan avg.
   *
   * @return String yang berisi data total dalam format csv.
   */
  protected abstract String generateTotalRow();

  /**
   * {@inheritDoc}
   */
  @Override
  public void generate(long numRows, Path path) {
    AutoFlushStream stream;
    try {
      stream = new AutoFlushStream(new FileOutputStream(path.toFile(), false), 128 * 1024);
    } catch (FileNotFoundException e) {
      log.atError().log(e.getMessage(), e);
      return;
    }

    String header = getHeaders();
    if (StringUtils.isNotBlank(header)) {
      try {
        stream.write((header + lineEnding).getBytes());
      } catch (IOException e) {
        log.atError().log(e.getMessage(), e);
        FileUtils.flushAndClose(stream);
        return;
      }
    }

    for (int i = 0; i < numRows; i++) {
      executorService.execute(() -> {
        try {
          stream.write(generateDetail() + lineEnding);
        } catch (IOException e) {
          log.atError().log(e.getMessage(), e);
          FileUtils.flushAndClose(stream);
          return;
        }
      });
    }

    log.atDebug().log("Shutting down {}", executorService.toString());
    this.executorService.shutdown();

    while (!executorService.isTerminated()) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        log.atError().log(e.getMessage(), e);
        Thread.currentThread().interrupt();
      }
    }

    String footer = generateTotalRow();
    if (StringUtils.isNotBlank(footer)) {
      try {
        stream.write(footer + lineEnding);
      } catch (IOException e) {
        log.atError().log(e.getMessage(), e);
        FileUtils.flushAndClose(stream);
        return;
      }
    }

    log.atDebug().log("Closing {}", stream.toString());
    FileUtils.flushAndClose(stream);
  }
}

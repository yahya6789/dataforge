package io.github.yahya6789.dataforge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * Class abstrak untuk menghasilkan CSV. Menggunakan pola template method untuk
 * memastikan struktur yang konsisten.
 */
@Slf4j
public abstract class CsvWriter implements IFileWriter {
  public static final int BUFFER_SIZE = 1_000_000;
  public static final String DELIMITER = "|";
  public static final int THREAD_POOL_SIZE = 8;

  private final BufferedWriter writer;
  private final AtomicInteger bufferCounter;
  private final String lineEnding = System.lineSeparator();
  private final ExecutorService executorService;
  private final long numRows;

  /**
   * Constructor CsvWriter.
   *
   * @param numRows Jumlah baris yang akan dihasilkan.
   * @param path    Lokasi penyimpanan file CSV.
   */
  @SneakyThrows
  public CsvWriter(long numRows, Path path) {
    this.numRows = numRows;
    this.executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    this.writer = new BufferedWriter(new FileWriter(path.toFile()));
    this.bufferCounter = new AtomicInteger();
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
   * Menghasilkan CSV dengan jumlah baris yang telah ditentukan.
   */
  @Override
  @SneakyThrows
  public void generate() {
    String header = getHeaders();
    if (header != null && !header.trim().isEmpty()) {
      writer.write(header + lineEnding);
    }

    for (int i = 0; i < numRows; i++) {
      executorService.execute(() -> {
        try {
          String detail = generateDetail();
          writer.write(detail + lineEnding);
          bufferCounter.incrementAndGet();
          if (bufferCounter.intValue() >= BUFFER_SIZE) {
            bufferCounter.set(0);
            writer.flush();
          }
        } catch (IOException e) {
          log.atError().log(e.getMessage(), e);
          FileUtils.flushAndClose(writer);
          return;
        }
      });
    }

    log.atInfo().log("Shutting down {}", executorService.toString());
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
    if (footer != null && !footer.trim().isEmpty()) {
      writer.write(footer + lineEnding);
    }

    log.atDebug().log("Closing {}", writer.toString());
    FileUtils.flushAndClose(writer);
  }
}

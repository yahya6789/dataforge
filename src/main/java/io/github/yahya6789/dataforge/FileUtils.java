package io.github.yahya6789.dataforge;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * Class utility untuk operasi yang berhubungan dengan file.
 */
@Slf4j
public class FileUtils {
  /**
   * Mengosongkan buffer jika memungkinkan, lalu menutup resource Closeable dengan
   * aman dan mencatat kesalahan jika terjadi.
   *
   * @param closeable Resource yang dapat ditutup (misalnya, BufferedReader,
   *                  BufferedWriter, dll.).
   */
  public static void flushAndClose(Closeable closeable) {
    try {
      if (closeable instanceof Flushable) {
        ((Flushable) closeable).flush();
      }
      if (closeable != null) {
        closeable.close();
      }
    } catch (IOException e) {
      log.atError().log("Failed to flush or close resource: {}", closeable.getClass().getSimpleName(), e);
    }
  }
}

package io.github.yahya6789.dataforge;

import java.io.IOException;
import java.io.Writer;

import lombok.extern.slf4j.Slf4j;

/**
 * Writer yang mengalihkan output ke SLF4J logger.
 */
@Slf4j
public class Slf4jWriter extends Writer {
  private final StringBuilder buffer = new StringBuilder();

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    buffer.append(cbuf, off, len);
  }

  @Override
  public void flush() throws IOException {
    if (buffer.length() > 0) {
      log.atInfo().log(buffer.toString().trim());
      buffer.setLength(0); // Kosongkan buffer setelah menulis
    }
  }

  @Override
  public void close() throws IOException {
    // Pastikan semua data dikirim sebelum ditutup
    flush();
  }

}

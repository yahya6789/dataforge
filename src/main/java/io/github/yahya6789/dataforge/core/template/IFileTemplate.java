package io.github.yahya6789.dataforge.core.template;

import java.io.OutputStream;

/**
 * Interface untuk class yang menghasilkan file.
 */
public interface IFileTemplate {
  /**
   * Menghasilkan file dengan menggunakan writer yang telah ditentukan.
   *
   * @param numRows      Jumlah baris yang akan dihasilkan.
   * @param outputStream OutputStream untuk menulis output.
   */
  void generate(long numRows, OutputStream outputStream);
}

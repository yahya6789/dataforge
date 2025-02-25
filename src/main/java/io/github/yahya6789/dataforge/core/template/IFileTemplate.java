package io.github.yahya6789.dataforge.core.template;

import java.io.Writer;

/**
 * Interface untuk class yang menghasilkan file.
 */
public interface IFileTemplate {
  /**
   * Menghasilkan file dengan menggunakan writer yang telah ditentukan.
   *
   * @param numRows Jumlah baris yang akan dihasilkan.
   * @param writer  Writer untuk menulis output (bisa ke file atau System.out).
   */
  void generate(long numRows, Writer writer);
}

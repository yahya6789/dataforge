package io.github.yahya6789.dataforge.template;

import java.nio.file.Path;

/**
 * Interface untuk class yang menghasilkan file.
 */
public interface IFileTemplate {
  /**
   * Menghasilkan file dengan menggunakan writer yang telah ditentukan.
   *
   * @param numRows Jumlah baris yang akan dihasilkan.
   * @param path    Path CSV output.
   */
  void generate(long numRows, Path path);
}

package io.github.yahya6789.dataforge.template;

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

  /**
   * Mengembalikan template berdasarkan default id "sales".
   *
   * @return Default file template CSV
   */
  static IFileTemplate getTemplate() {
    return getTemplate("sales");
  }

  /**
   * Mengembalikan template berdasarkan id.
   *
   * @param id Id template
   * @return File template CSV
   */
  static IFileTemplate getTemplate(String id) {
    switch (id) {
      case "sales":
        return new SalesCsvTemplate();
      default:
        throw new IllegalArgumentException(String.format("Template id '%s' not found", id));
    }
  }
}

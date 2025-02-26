package io.github.yahya6789.dataforge.core.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;

/**
 * Abstract class untuk generator sumber daya. Menyediakan implementasi dasar
 * untuk pemilihan data acak dari daftar yang tersedia.
 *
 * @param <T> Jenis data yang dihasilkan oleh generator.
 */
public abstract class AbstractResourceGenerator<T> implements IResourceGenerator<T> {

  /**
   * Memuat data dari file resource ke List. Method ini membaca file dari
   * classpath.
   *
   * @param resource Nama file resource yang akan dimuat.
   * @return List string yang berisi setiap baris dari file resource.
   * @throws IOException        Jika resource tidak ditemukan.
   */
  @SneakyThrows
  protected List<String> toResourceList(String resource) {
    List<String> resourceAsList = new ArrayList<String>();
    try (InputStream stream = getClass().getResourceAsStream("/" + resource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
      if (stream == null) {
        throw new IOException("Resource not found: " + resource);
      }
      String line;
      while ((line = reader.readLine()) != null) {
        resourceAsList.add(line);
      }
    }
    return resourceAsList;
  }
}

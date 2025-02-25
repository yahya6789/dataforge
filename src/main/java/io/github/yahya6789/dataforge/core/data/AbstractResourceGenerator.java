package io.github.yahya6789.dataforge.core.data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import io.github.yahya6789.dataforge.impl.data.RandomAddressGenerator;
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
   * @throws NullPointerException Jika resource tidak ditemukan.
   * @throws URISyntaxException   Jika terjadi sintaks URI.
   * @throws IOException          Jika terjadi kesalahan terkait IO.
   */
  @SneakyThrows
  protected List<String> toResourceList(String resource) {
    URL url = RandomAddressGenerator.class.getResource("/" + resource);
    if (url == null)
      throw new NullPointerException("Resource not found '" + resource + "'");
    Path path = Paths.get(url.toURI());
    return Files.lines(path).parallel().collect(Collectors.toList());
  }
}

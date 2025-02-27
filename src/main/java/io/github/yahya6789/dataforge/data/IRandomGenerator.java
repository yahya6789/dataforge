package io.github.yahya6789.dataforge.data;

/**
 * Interface generator yang dapat digunakan untuk menghasilkan data acak.
 *
 * @param <T> Jenis data yang dihasilkan.
 */
public interface IRandomGenerator<V> {
  /**
   * Membangkitkan data acak
   *
   * @return Data acak yang dihasilkan.
   */
  public V generate();

  /**
   * Mengembalikan tipe data dari data acak yang dihasilkan.
   *
   * @return Jenis data yang dihasilkan.
   */
  public Class<?> getType();
}

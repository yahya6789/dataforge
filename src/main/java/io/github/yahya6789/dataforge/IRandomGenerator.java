package io.github.yahya6789.dataforge;

public interface IRandomGenerator<V> {
  public V generate();

  public Class<?> getType();
}

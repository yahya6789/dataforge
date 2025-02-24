package io.github.yahya6789.dataforge.core.data;

public interface IRandomGenerator<V> {
  public V generate();

  public Class<?> getType();
}

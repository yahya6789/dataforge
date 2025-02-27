package io.github.yahya6789.dataforge.data;

import java.util.concurrent.ThreadLocalRandom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RandomIntegerGenerator implements IRandomGenerator<Integer> {
  private final int min;
  private final int max;

  @Override
  public Integer generate() {
    return ThreadLocalRandom.current().nextInt(min, (max + 1));
  }

  @Override
  public Class<?> getType() {
    return Integer.class;
  }
}

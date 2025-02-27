package io.github.yahya6789.dataforge.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RandomDecimalGenerator implements IRandomGenerator<BigDecimal> {
  private final int min;
  private final int max;
  private final int scale;
  private final int rounding;

  public RandomDecimalGenerator(int min, int max) {
    this(min, max, 2, BigDecimal.ROUND_HALF_UP);
  }

  @Override
  public BigDecimal generate() {
    return new BigDecimal(ThreadLocalRandom.current().nextDouble(min, (max + 1))).setScale(scale, rounding);
  }

  @Override
  public Class<?> getType() {
    return BigInteger.class;
  }
}

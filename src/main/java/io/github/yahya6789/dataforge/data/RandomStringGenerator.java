package io.github.yahya6789.dataforge.data;

import java.util.concurrent.ThreadLocalRandom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RandomStringGenerator implements IRandomGenerator<String> {
  private static final char[] CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
      .toCharArray();

  private final int length;

  @Override
  public String generate() {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    char[] result = new char[length];
    for (int i = 0; i < length; i++) {
      result[i] = CHARACTERS[random.nextInt(CHARACTERS.length)];
    }
    return new String(result);
  }

  @Override
  public Class<?> getType() {
    return String.class;
  }

}

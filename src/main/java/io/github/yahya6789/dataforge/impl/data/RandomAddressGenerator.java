package io.github.yahya6789.dataforge.impl.data;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import io.github.yahya6789.dataforge.core.data.AbstractResourceGenerator;

public class RandomAddressGenerator extends AbstractResourceGenerator<String> {
  public static final String DEFAULT_RESOURCE_NAME = "street_name.txt";

  private List<String> streetNames;

  public RandomAddressGenerator() {
    this(DEFAULT_RESOURCE_NAME);
  }

  public RandomAddressGenerator(String resource) {
    streetNames = toResourceList(resource);
  }

  @Override
  public String generate() {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    StringBuilder sb = new StringBuilder("Jl .")
        .append(streetNames.get(random.nextInt(streetNames.size())))
        .append(" No.").append(random.nextInt(1, 200));
    return sb.toString();
  }

  @Override
  public Class<?> getType() {
    return String.class;
  }
}

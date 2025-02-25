package io.github.yahya6789.dataforge.impl.data;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import io.github.yahya6789.dataforge.core.data.IRandomGenerator;
import lombok.SneakyThrows;

public class RandomAddressGenerator implements IRandomGenerator<String> {
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

  @SneakyThrows
  private List<String> toResourceList(String resource) {
    URL url = RandomAddressGenerator.class.getResource("/" + resource);
    if (url == null)
      throw new NullPointerException("Resource not found '" + resource + "'");
    Path path = Paths.get(url.toURI());
    return Files.lines(path).parallel().collect(Collectors.toList());
  }
}

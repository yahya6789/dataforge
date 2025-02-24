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

public class RandomNameGenerator implements IRandomGenerator<String> {
  private List<String> firstNames;
  private List<String> lastNames;

  public RandomNameGenerator() {
    this("first_name.txt", "last_name.txt");
  }

  public RandomNameGenerator(String firstNameResource, String lastNameResource) {
    firstNames = toResourceList(firstNameResource);
    lastNames = toResourceList(lastNameResource);
  }

  @Override
  public String generate() {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    String firstName = firstNames.get(random.nextInt(firstNames.size()));
    String lastName = firstNames.get(random.nextInt(lastNames.size()));
    return firstName + " " + lastName;
  }

  @Override
  public Class<?> getType() {
    return String.class;
  }

  @SneakyThrows
  private List<String> toResourceList(String resource) {
    URL url = RandomNameGenerator.class.getResource("/" + resource);
    if (url == null)
      throw new NullPointerException("Resource not found '" + resource + "'");
    Path path = Paths.get(url.toURI());
    return Files.lines(path).parallel().collect(Collectors.toList());
  }
}

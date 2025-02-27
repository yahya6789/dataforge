package io.github.yahya6789.dataforge.data;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNameGenerator extends AbstractResourceGenerator<String> {
  public static final String DEFAULT_FIRST_NAME_RESOURCE = "first_name.txt";
  public static final String DEFAULT_LAST_NAME_RESOURCE = "last_name.txt";

  private List<String> firstNames;
  private List<String> lastNames;

  public RandomNameGenerator() {
    this(DEFAULT_FIRST_NAME_RESOURCE, DEFAULT_LAST_NAME_RESOURCE);
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
}

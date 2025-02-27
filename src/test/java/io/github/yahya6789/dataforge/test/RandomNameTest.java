package io.github.yahya6789.dataforge.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.github.yahya6789.dataforge.impl.data.RandomNameGenerator;

@TestMethodOrder(OrderAnnotation.class)
public class RandomNameTest {
  private static RandomNameGenerator randomName;

  @BeforeAll
  public static void init() {
    randomName = new RandomNameGenerator();
  }

  @Test
  @Order(1)
  public void shouldDisplayOutput_withDefaultConstructor() {
    RandomNameGenerator randomName = new RandomNameGenerator();
    String name = randomName.generate();
    assertTrue(name != null);
    assertTrue(name.length() > 1);
  }

  @Test
  @Order(2)
  public void shouldDisplayOutput_whenResourceDefined() {
    RandomNameGenerator randomName = new RandomNameGenerator("first_name.txt", "last_name.txt");
    String name = randomName.generate();
    assertTrue(name != null);
    assertTrue(name.length() > 1);
  }

  @Test
  @Order(3)
  public void shouldThrowException_whenResourceNotFound() {
    assertThrows(IOException.class, () -> {
      new RandomNameGenerator("abc.txt", "def.txt");
    });
  }

  @Test
  @Order(4)
  public void shouldThrowException_whenResourceIsNull() {
    assertThrows(IOException.class, () -> {
      new RandomNameGenerator(null, null);
    });
  }

  @Test
  @Order(5)
  public void shouldGenerateUniqueName_AtLeastTenTimes() {
    String name = randomName.generate();
    for (int i = 0; i < 10; i++) {
      String newName = randomName.generate();
      assertNotEquals(name, newName);
      name = newName;
    }
  }
}

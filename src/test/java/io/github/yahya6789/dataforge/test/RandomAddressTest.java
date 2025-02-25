package io.github.yahya6789.dataforge.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.github.yahya6789.dataforge.impl.data.RandomAddressGenerator;

@TestMethodOrder(OrderAnnotation.class)
public class RandomAddressTest {
  private static RandomAddressGenerator randomAddress;

  @BeforeAll
  public static void init() {
    randomAddress = new RandomAddressGenerator();
  }

  @Test
  @Order(1)
  public void shouldDisplayOutput_withDefaultConstructor() {
    RandomAddressGenerator randomAddress = new RandomAddressGenerator();
    String address = randomAddress.generate();
    assertTrue(address != null);
    assertTrue(address.length() > 1);
  }

  @Test
  @Order(2)
  public void shouldDisplayOutput_whenResourceDefined() {
    RandomAddressGenerator randomAddress = new RandomAddressGenerator("street_name.txt");
    String address = randomAddress.generate();
    assertTrue(address != null);
    assertTrue(address.length() > 1);
  }

  @Test
  @Order(3)
  public void shouldThrowException_whenResourceNotFound() {
    assertThrows(NullPointerException.class, () -> {
      new RandomAddressGenerator("abc.txt");
    });
  }

  @Test
  @Order(4)
  public void shouldThrowException_whenResourceIsNull() {
    assertThrows(NullPointerException.class, () -> {
      new RandomAddressGenerator(null);
    });
  }

  @Test
  @Order(5)
  public void shouldGenerateUnique_AtLeastTenTimes() {
    String address = randomAddress.generate();
    for (int i = 0; i < 10; i++) {
      String newAddress = randomAddress.generate();
      assertNotEquals(address, newAddress);
      address = newAddress;
    }
  }
}

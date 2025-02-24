package io.github.yahya6789.dataforge.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import io.github.yahya6789.dataforge.impl.template.CsvTemplate;
import io.github.yahya6789.dataforge.impl.template.SalesCsvTemplate;
import lombok.SneakyThrows;

public class CsvTemplateTest {
  @Test
  @SneakyThrows
  public void shouldReturnCorrectRowCount_afterWriting() {
    int detailRowCount = 10;
    Path path = Files.createTempFile("output", "tmp");
    BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
    CsvTemplate salesCsv = new SalesCsvTemplate(10);
    salesCsv.generate(writer);
    assertEquals(detailRowCount, Files.lines(path).count());
    Files.delete(path);
  }
}

package io.github.yahya6789.dataforge.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import io.github.yahya6789.dataforge.template.IFileTemplate;
import io.github.yahya6789.dataforge.template.SalesCsvTemplate;
import lombok.SneakyThrows;

public class CsvTemplateTest {
  @Test
  @SneakyThrows
  public void shouldReturnCorrectRowCount_afterWriting() {
    int numRows = 10;
    Path path = Files.createTempFile("output", "tmp");
    IFileTemplate template = new SalesCsvTemplate();
    template.generate(numRows, path);
    assertEquals(numRows + 1, Files.lines(path).count());
    Files.delete(path);
  }
}

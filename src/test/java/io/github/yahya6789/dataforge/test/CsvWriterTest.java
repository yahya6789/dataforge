package io.github.yahya6789.dataforge.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import io.github.yahya6789.dataforge.CsvWriter;
import io.github.yahya6789.dataforge.SalesCsvGenerator;
import lombok.SneakyThrows;

public class CsvWriterTest {
  @Test
  @SneakyThrows
  public void shouldReturnCorrectRowCount_afterWriting() {
    int headerRowCount = 1;
    int detailRowCount = 10;
    Path path = Files.createTempFile("output", "tmp");
    CsvWriter salesCsv = new SalesCsvGenerator(10, path);
    salesCsv.generate();
    assertEquals(headerRowCount + detailRowCount, Files.lines(path).count());
    Files.delete(path);
  }
}

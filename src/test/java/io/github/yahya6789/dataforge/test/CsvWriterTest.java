package io.github.yahya6789.dataforge.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import io.github.yahya6789.dataforge.CsvWriter;
import io.github.yahya6789.dataforge.SalesCsvWriter;
import lombok.SneakyThrows;

public class CsvWriterTest {
  @Test
  @SneakyThrows
  public void shouldReturnCorrectRowCount_afterWriting() {
    int detailRowCount = 10;
    Path path = Files.createTempFile("output", "tmp");
    CsvWriter salesCsv = new SalesCsvWriter(10, path);
    salesCsv.generate();
    assertEquals(detailRowCount, Files.lines(path).count());
    Files.delete(path);
  }
}

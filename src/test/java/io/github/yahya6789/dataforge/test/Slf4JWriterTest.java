package io.github.yahya6789.dataforge.test;

import org.junit.jupiter.api.Test;

import io.github.yahya6789.dataforge.CsvTemplate;
import io.github.yahya6789.dataforge.SalesCsvTemplate;
import io.github.yahya6789.dataforge.Slf4jWriter;

public class Slf4JWriterTest {
  @Test
  public void shouldDisplayCorrectOutput_whenWriting() {
    CsvTemplate salesCsv = new SalesCsvTemplate(10);
    salesCsv.generate(new Slf4jWriter());
  }
}

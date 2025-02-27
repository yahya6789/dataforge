package io.github.yahya6789.dataforge.test;

import org.junit.jupiter.api.Test;

import io.github.yahya6789.dataforge.template.CsvTemplate;
import io.github.yahya6789.dataforge.template.SalesCsvTemplate;

public class CsvWriterTest {
  @Test
  public void shouldDisplayCorrectOutput_whenWritingToSysout() {
    CsvTemplate salesCsv = new SalesCsvTemplate();
    salesCsv.generate(10, System.out);
  }
}

package io.github.yahya6789.dataforge.test;

import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

import io.github.yahya6789.dataforge.impl.template.CsvTemplate;
import io.github.yahya6789.dataforge.impl.template.SalesCsvTemplate;
import io.github.yahya6789.dataforge.impl.writer.Slf4jWriter;

public class CsvWriterTest {
  @Test
  public void shouldDisplayCorrectOutput_whenWritingToSlf4j() {
    CsvTemplate salesCsv = new SalesCsvTemplate();
    salesCsv.generate(10, new Slf4jWriter());
  }

  @Test
  public void shouldDisplayCorrectOutput_whenWritingToSysout() {
    CsvTemplate salesCsv = new SalesCsvTemplate();
    salesCsv.generate(10, new OutputStreamWriter(System.out));
  }
}

package io.github.yahya6789.dataforge.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import io.github.yahya6789.dataforge.template.IFileTemplate;
import lombok.SneakyThrows;

public class CsvTemplateTest {
  @Test
  @SneakyThrows
  public void shouldReturnCorrectRowCount_afterWriting() {
    int footerCount = 1;
    int detailCount = 10;
    Path path = Files.createTempFile("output", "tmp");
    OutputStream stream = new BufferedOutputStream(new FileOutputStream(path.toFile(), false), 128 * 1024);
    IFileTemplate template = IFileTemplate.getTemplate();
    template.generate(detailCount, stream);
    assertEquals(footerCount + detailCount, Files.lines(path).count());
    Files.delete(path);
  }
}

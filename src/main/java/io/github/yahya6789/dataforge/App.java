package io.github.yahya6789.dataforge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.time.StopWatch;

import io.github.yahya6789.dataforge.shared.FormatUtil;
import io.github.yahya6789.dataforge.template.AutoFlushStream;
import io.github.yahya6789.dataforge.template.CsvTemplate;
import io.github.yahya6789.dataforge.template.SalesCsvTemplate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
  public static void main(String[] args) {
    printBanner();
    String defaultFilePath = System.getProperty("java.io.tmpdir") + File.separator + "output.csv";

    Options options = new Options();
    options.addOption("o", "output", true, "Path to the output CSV file (default: " + defaultFilePath + ")");
    options.addOption("n", "numrows", true, "Number of rows to generate (default: 10 rows)");
    options.addOption("h", "help", false, "Show help");

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();

    try {
      CommandLine cmd = parser.parse(options, args);
      if (cmd.hasOption("h")) {
        formatter.printHelp("dataforge", options);
        return;
      }

      String filePath = cmd.getOptionValue("f", defaultFilePath);
      int numRows = Integer.parseInt(cmd.getOptionValue("n", "10"));
      String numRowsAsString = FormatUtil.formatInteger(numRows);

      Path path = Paths.get(filePath);
      OutputStream stream = new AutoFlushStream(new FileOutputStream(path.toFile(), false), 128 * 1024);
      CsvTemplate csvTemplate = new SalesCsvTemplate();

      StopWatch sw = new StopWatch();
      sw.start();
      log.atInfo().log("Writing {} lines of CSV to '{}'", numRowsAsString, path.toAbsolutePath());
      csvTemplate.generate(numRows, stream);
      sw.stop();
      log.atInfo().log("{} lines of CSV generated in {}", numRowsAsString,
          FormatUtil.formatDuration(sw.getDuration()));
    } catch (ParseException e) {
      System.err.println("❌ Error parsing command-line arguments: " + e.getMessage());
      formatter.printHelp("dataforge", options);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Menampilkan banner ke console.
   */
  @SneakyThrows
  private static void printBanner() {
    try (InputStream stream = App.class.getResourceAsStream("/banner.txt")) {
      if (stream == null) {
        System.out.println("⚡ DataForge v1.0 ⚡");
        return;
      }
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
        String line;
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
      }
    }
  }
}

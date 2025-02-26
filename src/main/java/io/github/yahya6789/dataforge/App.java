package io.github.yahya6789.dataforge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import io.github.yahya6789.dataforge.impl.template.CsvTemplate;
import io.github.yahya6789.dataforge.impl.template.SalesCsvTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
  public static void main(String[] args) {
    Options options = new Options();
    options.addOption("o", "output", true, "Path to the output CSV file (default: output.csv)");
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

      String filePath = cmd.getOptionValue("f", "output.csv");
      int numRows = Integer.parseInt(cmd.getOptionValue("n", "10"));

      Path path = Paths.get(filePath);
      CsvTemplate csvTemplate = new SalesCsvTemplate();
      BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
      csvTemplate.generate(numRows, writer);
      log.atInfo().log("✅ CSV file generated: '{}'", path.toAbsolutePath());
    } catch (ParseException e) {
      System.err.println("❌ Error parsing command-line arguments: " + e.getMessage());
      formatter.printHelp("dataforge", options);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

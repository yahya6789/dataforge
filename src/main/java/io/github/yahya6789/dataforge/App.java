package io.github.yahya6789.dataforge;

import java.nio.file.Paths;

public class App {
  public static void main(String[] args) {
    CsvWriter salesCsv = new SalesCsvGenerator(10, Paths.get("sales.csv"));
    salesCsv.generate();
  }
}

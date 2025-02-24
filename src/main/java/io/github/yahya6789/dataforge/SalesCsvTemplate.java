package io.github.yahya6789.dataforge;

import java.math.BigDecimal;

public class SalesCsvTemplate extends CsvTemplate {
  private RandomDecimalGenerator decimalGenerator = new RandomDecimalGenerator(100, 999);
  private RandomIntegerGenerator integerGenerator = new RandomIntegerGenerator(100, 999);
  private RandomStringGenerator stringGenerator = new RandomStringGenerator(10);

  private BigDecimal sumColumn1 = BigDecimal.ZERO;
  private int sumColumn2 = 0;

  public SalesCsvTemplate(long numRows) {
    super(numRows);
  }

  @Override
  protected String getHeaders() {
    return null;
  }

  @Override
  protected String generateDetail() {
    BigDecimal column1 = decimalGenerator.generate();
    int column2 = integerGenerator.generate();
    String column3 = stringGenerator.generate();

    sumColumn1 = sumColumn1.add(column1);
    sumColumn2 += column2;

    return new StringBuilder(column1.toString()).append(DELIMITER).append(column2).append(DELIMITER).append(column3)
        .toString();
  }

  @Override
  protected String generateTotalRow() {
    return new StringBuilder(sumColumn1.toString()).append(DELIMITER).append(sumColumn2).append(DELIMITER).toString();
  }

}

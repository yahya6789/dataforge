package io.github.yahya6789.dataforge.impl.template;

import java.math.BigDecimal;

import io.github.yahya6789.dataforge.impl.data.RandomAddressGenerator;
import io.github.yahya6789.dataforge.impl.data.RandomDecimalGenerator;
import io.github.yahya6789.dataforge.impl.data.RandomIntegerGenerator;
import io.github.yahya6789.dataforge.impl.data.RandomNameGenerator;

public class SalesCsvTemplate extends CsvTemplate {
  private RandomDecimalGenerator randomDecimal = new RandomDecimalGenerator(100, 999);
  private RandomIntegerGenerator randomInteger = new RandomIntegerGenerator(100, 999);
  private RandomNameGenerator randomName = new RandomNameGenerator();
  private RandomAddressGenerator randomAddr = new RandomAddressGenerator();

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
    BigDecimal column1 = randomDecimal.generate();
    int column2 = randomInteger.generate();
    String column3 = randomName.generate();
    String column4 = randomAddr.generate();

    sumColumn1 = sumColumn1.add(column1);
    sumColumn2 += column2;

    return new StringBuilder(column1.toString()).append(DELIMITER)
        .append(column2).append(DELIMITER)
        .append(column3).append(DELIMITER)
        .append(column4)
        .toString();
  }

  @Override
  protected String generateTotalRow() {
    return new StringBuilder(sumColumn1.toString()).append(DELIMITER)
        .append(sumColumn2).append(DELIMITER)
        .append("").append(DELIMITER)
        .append("")
        .toString();
  }

}

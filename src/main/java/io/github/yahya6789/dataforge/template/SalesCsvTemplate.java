package io.github.yahya6789.dataforge.template;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import io.github.yahya6789.dataforge.data.RandomAddressGenerator;
import io.github.yahya6789.dataforge.data.RandomDecimalGenerator;
import io.github.yahya6789.dataforge.data.RandomIntegerGenerator;
import io.github.yahya6789.dataforge.data.RandomNameGenerator;

public class SalesCsvTemplate extends CsvTemplate {
  private RandomDecimalGenerator randomDecimal = new RandomDecimalGenerator(100, 999);
  private RandomIntegerGenerator randomInteger = new RandomIntegerGenerator(100, 999);
  private RandomNameGenerator randomName = new RandomNameGenerator();
  private RandomAddressGenerator randomAddr = new RandomAddressGenerator();

  private AtomicReference<BigDecimal> sumColumn1 = new AtomicReference<>(BigDecimal.ZERO);
  private AtomicInteger sumColumn2 = new AtomicInteger(0);

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

    sumColumn1.updateAndGet(value -> value.add(column1));
    sumColumn2.updateAndGet(value -> value + column2);

    return new StringBuilder(column1.toString()).append(DELIMITER)
        .append(column2).append(DELIMITER)
        .append(column3).append(DELIMITER)
        .append(column4)
        .toString();
  }

  @Override
  protected String generateTotalRow() {
    return new StringBuilder(sumColumn1.get().toString()).append(DELIMITER)
        .append(sumColumn2.get()).append(DELIMITER)
        .append("").append(DELIMITER)
        .append("")
        .toString();
  }

}

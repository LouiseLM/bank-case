package nl.bankcase.model;

import java.math.BigDecimal;

public enum Category {
    SHOPPING(BigDecimal.valueOf(3.5)),
    GROCERIES(BigDecimal.valueOf(4.5)),
    BILLS(BigDecimal.valueOf(1.2));

    private final BigDecimal coefficient;
    Category(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }
}

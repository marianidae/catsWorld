package org.softuni.catssss.model.dto;

import java.math.BigDecimal;
import java.util.Map;

public record ExchangeRatesDTO(String base, Map<String, BigDecimal> rates) {
}

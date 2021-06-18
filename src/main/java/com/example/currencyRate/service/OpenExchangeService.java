package com.example.currencyRate.service;

import com.example.currencyRate.client.OpenExchangeRatesClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class OpenExchangeService {

    @Autowired
    OpenExchangeRatesClient openExchangeRatesClient;

    @Value("${openExchangeRatesKey}")
    private String openExchangeRatesKey;

    @Value("${baseCurrency}")
    private String baseCurrency;

    public BigDecimal getRate(String currency, String date) {

        BigDecimal valueRates = BigDecimal.ZERO;
        try {
            JsonNode jsonNode = new ObjectMapper()
                    .readTree(openExchangeRatesClient.getRates(openExchangeRatesKey, baseCurrency, date));
            JsonNode rates = jsonNode.get("rates").get(currency);
            valueRates = new BigDecimal(rates.asText());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return valueRates;
    }
}

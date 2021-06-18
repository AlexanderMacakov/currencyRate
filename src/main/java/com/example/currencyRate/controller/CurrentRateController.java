package com.example.currencyRate.controller;

import com.example.currencyRate.service.GiphyService;
import com.example.currencyRate.service.OpenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class CurrentRateController {

    @Autowired
    private GiphyService giphyService;

    @Autowired
    private OpenExchangeService openExchangeService;


    @GetMapping ("/")
    public String getGif() {
        return getGif("RUB");
    }

    @GetMapping ("/{currency}")
    public String getGif(@PathVariable String currency) {

        ZoneId correctApiDate = ZoneId.of("America/New_York");
        DateTimeFormatter TEMPLATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(correctApiDate);
        ZonedDateTime today = ZonedDateTime.ofInstant(Instant.now(), correctApiDate);

        BigDecimal rate = openExchangeService.getRate(currency, TEMPLATE_FORMAT.format(today));
        BigDecimal rateYesterday = openExchangeService.getRate(currency,TEMPLATE_FORMAT.format(today.minusDays(1)));

        String gifType = rate.compareTo(rateYesterday) > 0 ? "rich" : "broke";
        String gif = giphyService.getGif(gifType);

        return "<img src=\"" + gif + "\"/>";
    }
}

package com.example.currencyRate.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "openExchangeRates", url = "${openExchangeRatesUrl}")
public interface OpenExchangeRatesClient {

    @GetMapping(path = "{date}.json")
    String getRates(@RequestParam String app_id,
                    @RequestParam String base,
                    @PathVariable String date);
}

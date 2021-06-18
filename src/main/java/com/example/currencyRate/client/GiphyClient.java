package com.example.currencyRate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "giphy", url = "${giphyUrl}")
public interface GiphyClient {

    @GetMapping
    String getGif(@RequestParam String tag,
                  @RequestParam String api_key,
                  @RequestParam String rating);
}

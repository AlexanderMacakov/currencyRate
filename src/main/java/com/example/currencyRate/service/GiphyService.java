package com.example.currencyRate.service;

import com.example.currencyRate.client.GiphyClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GiphyService {

    @Autowired
    private GiphyClient giphyClient;

    @Value("${giphyKey}")
    private String giphyKey;

    public String getGif(String type) {

        String gifUrl = null;
        try {
            JsonNode gifThree = new ObjectMapper()
                    .readTree(giphyClient.getGif(type, giphyKey, "g"));

            gifUrl = gifThree
                    .get("data")
                    .get("images")
                    .get("original")
                    .get("url")
                    .asText();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return gifUrl;
    }
}

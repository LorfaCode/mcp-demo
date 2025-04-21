package com.lorfacode.mcp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lorfacode.mcp.domain.OhlcData;
import com.lorfacode.mcp.dto.KrakenDTO;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CryptoService {

    private static final Logger logger = LoggerFactory.getLogger(CryptoService.class);

    private final String KRAKEN_HOST = "https://api.kraken.com";
    private final RestClient restClient;

    public CryptoService() {
        this.restClient = RestClient.builder()
                .baseUrl(KRAKEN_HOST)
                .defaultHeader("Accept", "application/json")
                .build();
    }

    @Tool(description = "Get OHLC data for a specific crypto and interval in minutes")
    public List<OhlcData> getOHLCForPair(String pair, Integer interval) {
        logger.info("Checking OHLC data for {} in {} minutes interval", pair, interval);
        URI url = URI.create("/0/public/OHLC?pair=" + pair + "&interval=" + interval);
        final var response = restClient.get()
                .uri(url)
                .retrieve()
                .body(KrakenDTO.class);
        return mapToOhlcData(response);
    }

    private List<OhlcData> mapToOhlcData(KrakenDTO response) {
        return response.result()
                .getOhlcData()
                .stream()
                .map(OhlcData::new)
                .toList();
                
    }
}
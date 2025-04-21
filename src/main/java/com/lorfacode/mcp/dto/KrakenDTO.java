package com.lorfacode.mcp.dto;

import java.util.List;

public record KrakenDTO(List<String> error,  KrakenResultDTO result) {
    public KrakenDTO {
        if (error == null || result == null) {
            throw new IllegalArgumentException("Invalid Kraken response");
        }
    }
}

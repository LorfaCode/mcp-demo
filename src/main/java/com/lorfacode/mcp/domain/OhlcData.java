package com.lorfacode.mcp.domain;

import java.util.List;

public record OhlcData(long time, double open, double high, double low, double close,
        double vwap, double volume) {
    public OhlcData {
        if (time == 0 || open == 0 || high == 0 || low == 0 || close == 0 || vwap == 0 || volume == 0) {
            throw new IllegalArgumentException("Invalid OHLC data");
        }
    }

    public OhlcData(List<Object> data) {
        this(Long.parseLong(data.get(0).toString()),
                Double.parseDouble(data.get(1).toString()),
                Double.parseDouble(data.get(2).toString()),
                Double.parseDouble(data.get(3).toString()),
                Double.parseDouble(data.get(4).toString()),
                Double.parseDouble(data.get(5).toString()),
                Double.parseDouble(data.get(6).toString()));
    }

}

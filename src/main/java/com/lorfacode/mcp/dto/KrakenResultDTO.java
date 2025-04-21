package com.lorfacode.mcp.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class KrakenResultDTO {

    private long last;

    @JsonIgnore
    private final List<List<Object>> hlcData = new ArrayList<>();


    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        if ("last".equals(key)) {
            this.last = ((Long) value).intValue();
        } else {
            final var tempData = (List<List<Object>>) value;
            hlcData.addAll(tempData);
        }
    }

    public long getLast() {
        return last;
    }

    public List<List<Object>> getOhlcData() {
        return List.copyOf(hlcData);
    }
}
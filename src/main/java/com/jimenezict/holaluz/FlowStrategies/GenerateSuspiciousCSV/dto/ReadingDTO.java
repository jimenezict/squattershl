package com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto;

import com.opencsv.bean.CsvBindByName;

public class ReadingDTO {

    @CsvBindByName(column = "client")
    private String client;
    @CsvBindByName(column = "period")
    private String period;
    @CsvBindByName(column = "reading")
    private Integer reading;

    public ReadingDTO(){}

    public ReadingDTO(String client, String period, Integer reading) {
        this.client = client;
        this.period = period;
        this.reading = reading;
    }

    public String getClient() {
        return client;
    }

    public String getPeriod() {
        return period;
    }

    public Integer getReading() {
        return reading;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setReading(Integer reading) {
        this.reading = reading;
    }
}

package com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto;

import com.opencsv.bean.CsvBindByPosition;

public class SuspiciousReadingDTO {

    @CsvBindByPosition(position = 0)
    private String client;
    @CsvBindByPosition(position = 1)
    private String month;
    @CsvBindByPosition(position = 2)
    private Integer suspicious;
    @CsvBindByPosition(position = 3)
    private Double median;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getSuspicious() {
        return suspicious;
    }

    public void setSuspicious(Integer suspicious) {
        this.suspicious = suspicious;
    }

    public Double getMedian() {
        return median;
    }

    public void setMedian(Double median) {
        this.median = median;
    }
}

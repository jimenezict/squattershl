package com.jimenezict.holaluz;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileReaders.FileReadersImpl;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileWriters.FileWritersImpl;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.GenerateSuspiciousCSV;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.ProcessReadings.ProcessReadingsImpl;
import com.jimenezict.holaluz.FlowStrategies.ProcessingStrategy;


public class App 
{
    public static void main( String[] args )
    {
        ProcessingStrategy ps = setUpOfStrategy();
        ps.generatesReportOfReadings(ps.processesReadings(ps.readReadings()));
    }

    private static ProcessingStrategy setUpOfStrategy() {
        GenerateSuspiciousCSV s = new GenerateSuspiciousCSV();
        s.setFileReaders(new FileReadersImpl());
        s.setFileWriter(new FileWritersImpl());
        s.setProcessingReading(new ProcessReadingsImpl());
        return s;
    }
}

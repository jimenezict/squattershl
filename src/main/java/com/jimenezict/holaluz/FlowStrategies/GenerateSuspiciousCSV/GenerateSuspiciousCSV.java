package com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileReaders.FileReaders;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileReaders.FileReadersImpl;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileWriters.FileWriters;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileWriters.FileWritersImpl;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.ProcessReadings.ProcessReadings;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.ProcessReadings.ProcessReadingsImpl;
import com.jimenezict.holaluz.FlowStrategies.ProcessingStrategy;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.*;

import java.util.List;

public class GenerateSuspiciousCSV implements ProcessingStrategy {

    private FileReaders fr;
    private ProcessReadings pr;
    private FileWriters fw;

    public GenerateSuspiciousCSV(){
    }

    public void setFileWriter(FileWriters fw){
        this.fw = fw;
    }

    public void setFileReaders(FileReaders fr){
        this.fr = fr;
    }

    public void setProcessingReading(ProcessReadings pr){
        this.pr = pr;
    }

    public List<ReadingDTO> readReadings(){
        List<ReadingDTO> readingsList = fr.readCSVbyFileName("2016-readings.csv");
        readingsList.addAll(fr.readXMLbyFileName("2016-readings.xml"));
        return readingsList;
    };

    public void generatesReportOfReadings(List<SuspiciousReadingDTO> listOfProcessedReadingDTO){
        fw.writeCSVbyFileName(listOfProcessedReadingDTO,"output.csv");
    };

    public List<SuspiciousReadingDTO> processesReadings(List<ReadingDTO> listOfReadingDTO){
        return filtersSuspiciousReads(calculateMedianAndSuspiciousDifference(listOfReadingDTO));
    }

    private List<SuspiciousReadingDTO> calculateMedianAndSuspiciousDifference(List<ReadingDTO> listOfReadingDTO) {
        return pr.generatesProcessedReadingDTO(listOfReadingDTO);
    }

    private List<SuspiciousReadingDTO> filtersSuspiciousReads(List<SuspiciousReadingDTO> processedReadingDTO) {
        return pr.filtersProcessedReadingDTO(processedReadingDTO);
    }

}

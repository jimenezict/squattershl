package com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.ProcessReadings;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.*;

import static java.util.stream.Collectors.*;

public class ProcessReadingsImpl implements ProcessReadings{

    public List<SuspiciousReadingDTO> generatesProcessedReadingDTO(List<ReadingDTO> listOfReadingDTO){
        Map<String, List<Integer>> readsByClient = splitReadsByClient(listOfReadingDTO);
        Map<String, Double> medianByClient = calculateMediansByClient(readsByClient);
        return listOfReadingDTO.stream().map(read -> getSuspiciousReadingDTO(medianByClient, read)).collect(toList());
    }

    private Map<String, List<Integer>> splitReadsByClient(List<ReadingDTO> listOfReadingDTO) {
        return listOfReadingDTO.stream().collect(groupingBy(ReadingDTO::getClient, mapping(ReadingDTO::getReading, toList())));
    }

    private Map<String, Double> calculateMediansByClient( Map<String, List<Integer>> readsByClient){
        Map<String,Double> mapToReturn = new HashMap<>();
        for(Map.Entry<String, List<Integer>> entry: readsByClient.entrySet()){
            entry.getValue().sort(Comparator.naturalOrder());
            Double median = (Double) new Double(entry.getValue().get(5) + entry.getValue().get(6))/2.0;
            mapToReturn.put(entry.getKey(),median);
        }
        return mapToReturn;
    }

    private SuspiciousReadingDTO getSuspiciousReadingDTO(Map<String, Double> medianByClient, ReadingDTO read) {
        SuspiciousReadingDTO s = new SuspiciousReadingDTO();
        s.setClient(read.getClient());
        s.setMonth(read.getPeriod());
        s.setMedian(medianByClient.get(read.getClient()));
        s.setSuspicious(read.getReading());
        return s;
    }

    public List<SuspiciousReadingDTO> filtersProcessedReadingDTO(List<SuspiciousReadingDTO> listOfSuspiciousDTO){
        return listOfSuspiciousDTO.stream().filter(filterByMoreThan50PercentDifference()).collect(Collectors.toList());
    }

    private Predicate<SuspiciousReadingDTO> filterByMoreThan50PercentDifference() {
        return x->(x.getMedian()/x.getSuspicious() >= 2) || (x.getSuspicious()/x.getMedian() >= 2);
    }

}

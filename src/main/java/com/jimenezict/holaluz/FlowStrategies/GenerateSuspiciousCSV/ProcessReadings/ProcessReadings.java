package com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.ProcessReadings;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.*;

import java.util.List;

public interface ProcessReadings {

    List<SuspiciousReadingDTO> generatesProcessedReadingDTO(List<ReadingDTO> listOfReadingDTO);

    List<SuspiciousReadingDTO> filtersProcessedReadingDTO(List<SuspiciousReadingDTO> listOfSuspiciousDTO);

}

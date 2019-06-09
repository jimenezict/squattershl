package com.jimenezict.holaluz.FlowStrategies;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.*;
import java.util.List;

public interface ProcessingStrategy {

    public List<ReadingDTO> readReadings();

    public List<SuspiciousReadingDTO> processesReadings(List<ReadingDTO> listOfReadingDTO);

    public void generatesReportOfReadings(List<SuspiciousReadingDTO> listOfProcessedReadingDTO);
}

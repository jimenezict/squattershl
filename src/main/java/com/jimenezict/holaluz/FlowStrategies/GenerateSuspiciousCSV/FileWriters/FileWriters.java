package com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileWriters;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.*;

import java.util.List;

public interface FileWriters {

    public void writeCSVbyFileName(List<SuspiciousReadingDTO> listOfSuspiciousReadingDTO,  String outputFileName);

}

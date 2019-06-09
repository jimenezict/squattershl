package com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileReaders;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.*;

import java.util.List;

public interface FileReaders {

    public List<ReadingDTO> readCSVbyFileName(String file);

    public List<ReadingDTO> readXMLbyFileName(String file);

}

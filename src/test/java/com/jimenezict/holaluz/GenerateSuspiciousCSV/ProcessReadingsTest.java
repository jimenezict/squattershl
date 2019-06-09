package com.jimenezict.holaluz.GenerateSuspiciousCSV;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileWriters.FileWriters;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileWriters.FileWritersImpl;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.ProcessReadings.ProcessReadings;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.ProcessReadings.ProcessReadingsImpl;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.ReadingDTO;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.SuspiciousReadingDTO;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ProcessReadingsTest
{

    private ProcessReadings processReadings;
    List<ReadingDTO> listOfReadingDTO;

    @Before
    public void init(){
        processReadings = new ProcessReadingsImpl();
        listOfReadingDTO = new ArrayList<ReadingDTO>();

        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-01",42451));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-02",44279));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-03",44055));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-04",40953));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-05",42566));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-06",41216));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-07",43597));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-08",43324));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-09",3564));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-10",44459));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-11",42997));
        listOfReadingDTO.add(new ReadingDTO("583ef6329d7b9","2018-12",42600));

    }

    @Test
    public void processFile() {
        List<SuspiciousReadingDTO> listOfSuspicious = processReadings.generatesProcessedReadingDTO(listOfReadingDTO);
        assertEquals(42798.5, listOfSuspicious.get(0).getMedian(),1);
    }

    @Test
    public void processFileAndFilter() {
        List<SuspiciousReadingDTO> listOfSuspicious = processReadings.generatesProcessedReadingDTO(listOfReadingDTO);
        List<SuspiciousReadingDTO> filteredListOfSuspicious = processReadings.filtersProcessedReadingDTO(listOfSuspicious);
        assertEquals("583ef6329d7b9", filteredListOfSuspicious.get(0).getClient());
        assertEquals("2018-09", filteredListOfSuspicious.get(0).getMonth());
    }
}

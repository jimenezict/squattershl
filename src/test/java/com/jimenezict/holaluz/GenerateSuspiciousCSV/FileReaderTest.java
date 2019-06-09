package com.jimenezict.holaluz.GenerateSuspiciousCSV;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileReaders.FileReaders;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileReaders.FileReadersImpl;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.ReadingDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FileReaderTest
{

    private FileReaders fileReader;

    @Before
    public void init(){
        fileReader = new FileReadersImpl();
    }

    @Test
    public void noCSVTest()
    {
        List<ReadingDTO> listOfSuspliciousReadingDTO = fileReader.readCSVbyFileName("Test_not_valid_file.csv");
        assertEquals(0,listOfSuspliciousReadingDTO.size());
    }

    @Test
    public void noXMLTest()
    {
        List<ReadingDTO> listOfSuspliciousReadingDTO = fileReader.readXMLbyFileName("Test_not_valid_file.xml");
        assertEquals(0,listOfSuspliciousReadingDTO.size());
    }

    @Test
    public void validCSVTest()
    {
        List<ReadingDTO> listOfSuspliciousReadingDTO = fileReader.readCSVbyFileName("Test_file.csv");
        assertEquals(42451L,(long)listOfSuspliciousReadingDTO.get(0).getReading());
    }

    @Test
    public void validXMLTest()
    {
        List<ReadingDTO> listOfSuspliciousReadingDTO = fileReader.readXMLbyFileName("2016-readings.xml");
        assertEquals(37232,(long)listOfSuspliciousReadingDTO.get(0).getReading());
    }
}

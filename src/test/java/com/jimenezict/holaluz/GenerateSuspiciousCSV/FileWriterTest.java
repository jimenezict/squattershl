package com.jimenezict.holaluz.GenerateSuspiciousCSV;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileWriters.FileWriters;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileWriters.FileWritersImpl;
import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.SuspiciousReadingDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class FileWriterTest
{

    private FileWriters fileWriter;
    List<SuspiciousReadingDTO> listOfSuspiciousReadingDTO;

    @Before
    public void init(){
        fileWriter = new FileWritersImpl();
        listOfSuspiciousReadingDTO = new ArrayList<SuspiciousReadingDTO>();

        SuspiciousReadingDTO suspiciousReadingDTO = new SuspiciousReadingDTO();
        suspiciousReadingDTO.setClient("9388d990d9");
        suspiciousReadingDTO.setMonth("2018-10");
        suspiciousReadingDTO.setMedian(473623.5);
        suspiciousReadingDTO.setSuspicious(3736);

        listOfSuspiciousReadingDTO.add(suspiciousReadingDTO);
    }

    @Test
    public void writesFile() {
        //given
        int f_read = 0;

        //when
        fileWriter.writeCSVbyFileName(listOfSuspiciousReadingDTO, "Test_Write_file.csv");

        try {
            FileReader f = new FileReader("Test_Write_file.csv");
            f_read = f.read();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Then
        assertTrue(f_read > 0);
    }

    @After
    public void ends(){
        File file = new File("Test_Write_file.csv");
        file.delete();
    }

}

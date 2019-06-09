package com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileWriters;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.*;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

public class FileWritersImpl implements FileWriters {

    @Override
    public void writeCSVbyFileName(List<SuspiciousReadingDTO> listOfSuspiciousReadingDTO, String outputFileName) {
        Writer writer = null;

        try {
            writer = new FileWriter(outputFileName);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(listOfSuspiciousReadingDTO);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

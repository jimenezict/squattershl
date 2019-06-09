package com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.FileReaders;

import com.jimenezict.holaluz.FlowStrategies.GenerateSuspiciousCSV.dto.*;
import com.opencsv.bean.CsvToBeanBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileReadersImpl implements FileReaders {

    public List<ReadingDTO> readCSVbyFileName(String file){
        try {
            return new CsvToBeanBuilder(new FileReader(file)).withType(ReadingDTO.class).build().parse();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return new ArrayList<ReadingDTO>();
        }
    };

    public List<ReadingDTO> readXMLbyFileName(String file){

        List<ReadingDTO> readingDTOList = new ArrayList<ReadingDTO>();
        File fXmlFile;
        try{
            new FileReader(file);
            fXmlFile = new File(file);
        }catch(Exception ex){
            return readingDTOList;
        };


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        Document doc = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }  catch (Exception e) {
            e.printStackTrace();
        }

        NodeList nList = doc.getElementsByTagName("reading");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            readingDTOList.add(generateReadingDTO(nList, temp));
        }

        return readingDTOList;
    }

    private ReadingDTO generateReadingDTO(NodeList nList, int temp) {
        Element eElement = (Element) nList.item(temp);
        ReadingDTO readingDTO =
                new ReadingDTO(eElement.getAttribute("clientID"),
                        eElement.getAttribute("period"),
                        Integer.parseInt(eElement.getTextContent()));
        return readingDTO;
    }
}

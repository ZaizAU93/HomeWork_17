package task_1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //    ArrayList <Author> authors = new ArrayList<>();
        //String workingDirectory = System.getProperty("user.dir");
        String filePath = "E:\\TeachMeSkills\\HomeWork_17\\xml.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

//        XMLHandler handler = new XMLHandler();
//        parser.parse(filePath, handler);
//        System.out.println(handler.authors.get(0).getFirstName());
//        System.out.println(handler.authors.get(0).getLastName());
//        System.out.println(handler.authors.get(0).getNationality());
//        System.out.println(handler.authors.get(0).getYearOfBirth());
//        System.out.println(handler.authors.get(0).getYearOfDeath());
    }
}
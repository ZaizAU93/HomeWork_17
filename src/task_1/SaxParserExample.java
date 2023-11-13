package task_1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.File;

// не знаю почему, но работает не правильно
public class SaxParserExample {
    public static void main(String[] args) {
        try {
            File inputFile = new File("xml.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            CustomHandler customHandler = new CustomHandler();
            saxParser.parse(inputFile, customHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class CustomHandler extends DefaultHandler {
        boolean isSonnet = false;
        String currentTitle = "";
        String currentText = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("sonnet")) {
                isSonnet = true;
                currentTitle = attributes.getValue("title");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isSonnet) {
                currentText = new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("sonnet")) {
                isSonnet = false;
                System.out.println("Title: " + currentTitle);
                System.out.println("Text: " + currentText);
            }
        }
    }
}
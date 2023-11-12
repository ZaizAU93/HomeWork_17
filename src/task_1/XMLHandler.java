package task_1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XMLHandler extends DefaultHandler {
    public ArrayList<Author> authors = new ArrayList<>();
    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
        // Тут будет логика реакции на конец документа
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("author")) {
            String lastName = attributes.getValue("lastName");
            String firstName = attributes.getValue("firstName");
            String nationality = attributes.getValue("nationality");
            String yearOfBirth = attributes.getValue("yearOfBirth");
            String yearOfDeath = attributes.getValue("yearOfDeath");
            authors.add(new Author(lastName, firstName, nationality, yearOfBirth, yearOfDeath));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Тут будет логика реакции на конец элемента
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Тут будет логика реакции на текст между элементами
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        // Тут будет логика реакции на пустое пространство внутри элементов (пробелы, переносы строчек и так далее).
    }

}

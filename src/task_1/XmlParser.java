package task_1;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.*;

public class XmlParser {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int choice = Integer.parseInt(reader.readLine());

            if (choice == 1) {
                parseWithSAX();
            } else if (choice == 2) {
                parseWithDOM();
            } else {
                System.out.println("Invalid choice");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseWithSAX() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean lineTag = false;
                String fileName = "";
                StringBuilder content = new StringBuilder();

                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("line")) {
                        lineTag = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) {
                    if (qName.equalsIgnoreCase("line")) {
                        lineTag = false;
                        writeToFile(fileName, content.toString());
                        content.setLength(0);
                    } else if (qName.equalsIgnoreCase("fileName")) {
                        fileName = content.toString().trim() + ".txt";
                        content.setLength(0);
                    }
                }

                public void characters(char[] ch, int start, int length) {
                    if (lineTag) {
                        content.append(new String(ch, start, length));
                    }
                }
            };

            parser.parse("xml.xml", handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseWithDOM() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("xml.xml");

            NodeList nodeList = doc.getElementsByTagName("line");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String fileName = element.getElementsByTagName("fileName").item(0).getTextContent().trim() + ".txt";
                String content = element.getTextContent().trim();
                writeToFile(fileName, content);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileName, String content) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

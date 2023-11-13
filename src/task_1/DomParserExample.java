package task_1;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class DomParserExample {
    public static void main(String[] args) {
        try {
            File inputFile = new File("xml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(inputFile);
            document.getDocumentElement().normalize();

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            NodeList nodeList = document.getElementsByTagName("sonnet");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Title: " + element.getAttribute("title"));
                    System.out.println("Text: " + element.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
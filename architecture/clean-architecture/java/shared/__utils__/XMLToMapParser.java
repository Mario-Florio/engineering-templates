package shared.__utils__;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class XMLToMapParser {

    public static Map<String, Object> parseXML(String xml) throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputStream);
        doc.getDocumentElement().normalize();

        Element root = doc.getDocumentElement();
        return elementToMap(root);
    }
    private static Map<String, Object> elementToMap(Element element) {
        Map<String, Object> map = new HashMap<>();
        NodeList children = element.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;

                // Recurse if child has nested elements
                if (child.getChildNodes().getLength() > 1 || hasChildElements(child)) {
                    map.put(child.getTagName(), elementToMap(child));
                } else {
                    map.put(child.getTagName(), child.getTextContent());
                }
            }
        }
        return map;
    }
    private static boolean hasChildElements(Element element) {
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) return true;
        }
        return false;
    }
}

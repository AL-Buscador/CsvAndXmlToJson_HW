import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLRead {
    static List<Emloyee> parseXML(File file) {
        List<Emloyee> empList = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Node staff = document.getDocumentElement();
            NodeList employes = staff.getChildNodes();

            for(int i = 0; i < employes.getLength(); i ++) {
                Node node = employes.item(i);

                String[] empFieldsNames = {"id", "firstName", "lastName", "country", "age"};
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    Emloyee emloyee = new Emloyee(
                            Long.parseLong(element.getElementsByTagName(empFieldsNames[0]).item(0).getTextContent()),
                            element.getElementsByTagName(empFieldsNames[1]).item(0).getTextContent(),
                            element.getElementsByTagName(empFieldsNames[2]).item(0).getTextContent(),
                            element.getElementsByTagName(empFieldsNames[3]).item(0).getTextContent(),
                            Integer.parseInt(element.getElementsByTagName(empFieldsNames[4]).item(0).getTextContent())
                    );
                    empList.add(emloyee);
                }
            }


        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return empList;
    }
}

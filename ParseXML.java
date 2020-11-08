import javax.xml.parsers.DocumentBuilderFactory;
import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ParseXML {
    // building a document from the XML file
    // returns a Document object after loading the book.xml file.
    public Document getDocFromFile(String filename)
        throws ParserConfigurationException{
        {
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           DocumentBuilder db = dbf.newDocumentBuilder();
           Document doc = null;
           
           try{
               doc = db.parse(filename);
           } catch (Exception ex){
               System.out.println("XML parse failure");
               ex.printStackTrace();
           }
           return doc;
        } // exception handling

    }




    public void readBoardData(Document d){
        Element root = d.getDocumentElement();
        NodeList sets = root.getElementsByTagName("set");

        System.out.println();
        for (int i = 0; i < sets.getLength(); i++) {

            System.out.println("Printing information for set " + (i + 1));

            // reads data from the nodes
            Node set = sets.item(i);
            String setName = set.getAttributes().getNamedItem("name").getNodeValue();
            System.out.println("Set name = " + setName);

            // reads data

            NodeList children = set.getChildNodes();

            for (int j = 0; j < children.getLength(); j++) {

                Node sub = children.item(j);

                if ("neighbors".equals(sub.getNodeName())) {
                    System.out.println("Neighbors:");
                    NodeList neighbors = sub.getChildNodes();

                    for(int k = 0; k < neighbors.getLength(); k++){
                        Node neighbor = neighbors.item(k);

                        if("neighbor".equals(neighbor.getNodeName())){
                            String currentNeighbor = neighbor.getAttributes().getNamedItem("name").getNodeValue();

                            System.out.println("  *" + currentNeighbor);
                        }
                        //System.out.println(currentNeighbor);
                    }
                }

                else if ("area".equals(sub.getNodeName())) {
                    String authorName = sub.getTextContent();
                    System.out.println("Area = " + authorName);

                } else if ("takes".equals(sub.getNodeName())) {
                    System.out.println("Takes:");
                    NodeList takes = sub.getChildNodes();

                    for (int k = 0; k < takes.getLength(); k++) {
                        Node take = takes.item(k);
                        
                        if ("take".equals(take.getNodeName())) {
                            String currentTake = take.getAttributes().getNamedItem("number").getNodeValue();
                            System.out.println("  *" + currentTake);
                        }
                        // System.out.println(currentNeighbor);
                    }
                } else if ("parts".equals(sub.getNodeName())) {
                    System.out.println("Parts:");
                    NodeList parts = sub.getChildNodes();

                    for (int k = 0; k < parts.getLength(); k++) {
                        Node part = parts.item(k);

                        if ("part".equals(part.getNodeName())) {
                            String partName = part.getAttributes().getNamedItem("name").getNodeValue();
                            String partLevel = part.getAttributes().getNamedItem("level").getNodeValue();
                            String line = part.getTextContent();
                            System.out.println("  *" + partName + "\n  *Level: " + partLevel + " \n   \'" + line + "\'");
                            
                        }
                        // System.out.println(currentNeighbor);
                    }
                }

            } // for childnodes

            System.out.println("\n");

        } // for set nodes




        //TODO:
        /*
            Need to grab from trailer node

        */



        // TODO:
        /*
         * Need to grab from office node
         * 
         */






    } // ends readBoardData
    




    public void readCardData(Document d){
Element root = d.getDocumentElement();
        NodeList sets = root.getElementsByTagName("set");

        System.out.println();
        for (int i = 0; i < sets.getLength(); i++) {

            System.out.println("Printing information for set " + (i + 1));

            // reads data from the nodes
            Node set = sets.item(i);
            String setName = set.getAttributes().getNamedItem("name").getNodeValue();
            System.out.println("Set name = " + setName);

            // reads data

            NodeList children = set.getChildNodes();

            for (int j = 0; j < children.getLength(); j++) {

                Node sub = children.item(j);

                if ("neighbors".equals(sub.getNodeName())) {
                    System.out.println("Neighbors:");
                    NodeList neighbors = sub.getChildNodes();

                    for(int k = 0; k < neighbors.getLength(); k++){
                        Node neighbor = neighbors.item(k);

                        if("neighbor".equals(neighbor.getNodeName())){
                            String currentNeighbor = neighbor.getAttributes().getNamedItem("name").getNodeValue();

                            System.out.println("  *" + currentNeighbor);
                        }
                        //System.out.println(currentNeighbor);
                    }
                } else if ("area".equals(sub.getNodeName())) {
                    String authorName = sub.getTextContent();
                    System.out.println("Area = " + authorName);

                } else if ("takes".equals(sub.getNodeName())) {
                    System.out.println("Takes:");
                    NodeList takes = sub.getChildNodes();

                    for (int k = 0; k < takes.getLength(); k++) {
                        Node take = takes.item(k);
                        
                        if ("take".equals(take.getNodeName())) {
                            String currentTake = take.getAttributes().getNamedItem("number").getNodeValue();
                            System.out.println("  *" + currentTake);
                        }
                        // System.out.println(currentNeighbor);
                    }
                } else if ("parts".equals(sub.getNodeName())) {
                    System.out.println("Parts:");
                    NodeList parts = sub.getChildNodes();

                    for (int k = 0; k < parts.getLength(); k++) {
                        Node part = parts.item(k);

                        if ("part".equals(part.getNodeName())) {
                            String partName = part.getAttributes().getNamedItem("name").getNodeValue();
                            String partLevel = part.getAttributes().getNamedItem("level").getNodeValue();
                            String line = part.getTextContent();
                            System.out.println("  *" + partName + "\n  *Level: " + partLevel + " \n   \'" + line + "\'");
                            
                        }
                        // System.out.println(currentNeighbor);
                    }
                }

            } // for childnodes

            System.out.println("\n");

    }
}

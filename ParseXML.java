import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
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
    public Document getDocFromFile(String filename) throws ParserConfigurationException {
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = null;

            try {
                doc = db.parse(filename);
            } catch (Exception ex) {
                //.out.println("XML parse failure");
                ex.printStackTrace();
            }
            return doc;
        } // exception handling

    }

    public List<Room> readSetData(Document d) {

        
        Element root = d.getDocumentElement();
        NodeList sets = root.getElementsByTagName("set");
        
        List<Room> addingRooms = new ArrayList<Room>();
        //System.out.println();
        for (int i = 0; i < sets.getLength(); i++) {
                List<Role> eachRole = new ArrayList<>();
                List<String> neighborsList = new ArrayList<String>();
                List<Boolean>shotList = new ArrayList<Boolean>();
                String setName;
                String currentTake = "-1";

            //System.out.println("Printing information for set " + (i + 1));

            // reads data from the nodes
            Node set = sets.item(i);
            setName = set.getAttributes().getNamedItem("name").getNodeValue();
            //System.out.println("Set name = " + setName);

            // reads data

            NodeList children = set.getChildNodes();


            //going though each set's node
            for (int j = 0; j < children.getLength(); j++) {

                

                Node sub = children.item(j);

                if ("neighbors".equals(sub.getNodeName())) {
                    //System.out.println("Neighbors:");
                    NodeList neighbors = sub.getChildNodes();

                    for (int k = 0; k < neighbors.getLength(); k++) {
                        Node neighbor = neighbors.item(k);

                        if ("neighbor".equals(neighbor.getNodeName())) {
                            String currentNeighbor = neighbor.getAttributes().getNamedItem("name").getNodeValue();
                            neighborsList.add(currentNeighbor);
                            //System.out.println("  *" + currentNeighbor);
                        }
                        // System.out.println(currentNeighbor);
                    }
                } else if ("area".equals(sub.getNodeName())) {
                    String authorName = sub.getTextContent();
                    //System.out.println("Area = " + authorName);

                } else if ("takes".equals(sub.getNodeName())) {
                    //System.out.println("Takes:");
                    NodeList takes = sub.getChildNodes();

                    for (int k = 0; k < takes.getLength(); k++) {
                        Node take = takes.item(k);

                        if ("take".equals(take.getNodeName())) {
                            currentTake = take.getAttributes().getNamedItem("number").getNodeValue();
                            //System.out.println("  *" + currentTake);
                            shotList.add(false);
                        }
                        // System.out.println(currentNeighbor);
                    }
                } else if ("parts".equals(sub.getNodeName())) {
                    //System.out.println("Parts:");
                    NodeList parts = sub.getChildNodes();

                    for (int k = 0; k < parts.getLength(); k++) {
                        Node part = parts.item(k);

                        if ("part".equals(part.getNodeName())) {
                            String partName = part.getAttributes().getNamedItem("name").getNodeValue();
                            String partLevel = part.getAttributes().getNamedItem("level").getNodeValue();
                            String line = part.getTextContent();
                            eachRole.add(new Role(partName, Integer.parseInt(partLevel), line.substring(18, line.length() - 7)));
                            //System.out
                              //      .println("  *" + partName + "\n  *Level: " + partLevel + " \n   \'" + line + "\'");

                        }
                        // System.out.println(currentNeighbor);
                    }
                }

            } // for childnodes
            
            addingRooms.add(new Room(setName, shotList, neighborsList, eachRole));
            //System.out.println("\n");
            
            
        } // for set nodes
        return addingRooms;
        

        
        
    } // ends readBoardData






    public List<Room> readTrailerData(Document d){
        Element root = d.getDocumentElement();
        NodeList trailers = root.getElementsByTagName("trailer");

        List<Room> addingRooms = new ArrayList<Room>();
        List<String> neighborsList = new ArrayList<String>();


        for (int i = 0; i < trailers.getLength(); i++) {

            //System.out.println("******* Printing information for trailer *******");

            // reads data from the nodes
            Node trailer = trailers.item(i);

            // reads data

            NodeList children = trailer.getChildNodes();

            for (int j = 0; j < children.getLength(); j++) {

                Node sub = children.item(j);

                if ("neighbors".equals(sub.getNodeName())) {
                    //System.out.println("Neighbors:");
                    NodeList neighbors = sub.getChildNodes();

                    for (int k = 0; k < neighbors.getLength(); k++) {
                        Node neighbor = neighbors.item(k);

                        if ("neighbor".equals(neighbor.getNodeName())) {
                            String currentNeighbor = neighbor.getAttributes().getNamedItem("name").getNodeValue();
                            neighborsList.add(currentNeighbor);

                            //System.out.println("  *" + currentNeighbor);
                        }
                        // System.out.println(currentNeighbor);
                    }
                } else if ("area".equals(sub.getNodeName())) {
                    String x, y, h, w;
                    x = sub.getAttributes().getNamedItem("x").getNodeValue();
                    h = sub.getAttributes().getNamedItem("h").getNodeValue();
                    w = sub.getAttributes().getNamedItem("w").getNodeValue();
                    y = sub.getAttributes().getNamedItem("y").getNodeValue();

                    //System.out.println("Area: " + x + ", " + y + ", " + h + ", " + w);
                }

            } // for childnodes
            addingRooms.add(new Room("trailer", neighborsList));

            
            //System.out.println("\n");
            
        } // for set nodes
        return addingRooms;
    }





    public List<Room> readOfficeData(Document d) {

        List<Room> addingRooms = new ArrayList<Room>();
        List<String> neighborsList = new ArrayList<String>();

        Element root = d.getDocumentElement();
        NodeList offices = root.getElementsByTagName("office");

        for (int i = 0; i < offices.getLength(); i++) {

            // System.out.println("******* Printing information for office *******");

            // reads data from the nodes
            Node office = offices.item(i);

            // reads data

            NodeList children = office.getChildNodes();

            for (int j = 0; j < children.getLength(); j++) {

                Node sub = children.item(j);

                if ("neighbors".equals(sub.getNodeName())) {
                    // System.out.println("Neighbors:");
                    NodeList neighbors = sub.getChildNodes();

                    for (int k = 0; k < neighbors.getLength(); k++) {
                        Node neighbor = neighbors.item(k);

                        if ("neighbor".equals(neighbor.getNodeName())) {
                            String currentNeighbor = neighbor.getAttributes().getNamedItem("name").getNodeValue();
                            neighborsList.add(currentNeighbor);

                            // System.out.println(" *" + currentNeighbor);
                        }
                        // System.out.println(currentNeighbor);
                    }
                } else if ("area".equals(sub.getNodeName())) {
                    String x, y, h, w;
                    x = sub.getAttributes().getNamedItem("x").getNodeValue();
                    h = sub.getAttributes().getNamedItem("h").getNodeValue();
                    w = sub.getAttributes().getNamedItem("w").getNodeValue();
                    y = sub.getAttributes().getNamedItem("y").getNodeValue();

                    // System.out.println("Area: " + x + ", " + y + ", " + h + ", " + w);
                } else if ("upgrades".equals(sub.getNodeName())) {
                    // System.out.println("Upgrades: ");
                    NodeList upgrades = sub.getChildNodes();

                    for (int k = 0; k < upgrades.getLength(); k++) {
                        Node upgrade = upgrades.item(k);

                        if ("upgrade".equals(upgrade.getNodeName())) {
                            String level = upgrade.getAttributes().getNamedItem("level").getNodeValue();
                            String currency = upgrade.getAttributes().getNamedItem("currency").getNodeValue();
                            String amt = upgrade.getAttributes().getNamedItem("amt").getNodeValue();

                            // System.out.println(" *level\t" + level);
                            // System.out.println(" *currency\t" + currency);
                            // System.out.println(" *amt \t" + amt);
                            // System.out.println();
                        }
                        // System.out.println(currentNeighbor);
                    }
                }

            } // for childnodes
            addingRooms.add(new Room("office", neighborsList));
              // System.out.println("\n");

        } // for set nodes
        return addingRooms;
    }






    // TODO:

    /*
     * Want to add to the parts arraylist WHILE running through the XML doc So all
     * the parameter that will will be adding to the scenes list are: 
     *  -name
     *  -description 
     *  -budget 
     *  -An array list of the roles class (this is the part
     *      nodes) For that me must create an arraylist of roles class here It will
     *      contain 
     *     -name
     *     -rank 
     *     -line
     * 
     */

    public List<Scene> readCardData(Document d) {

        List<Scene> addingScenes  = new ArrayList<Scene>();

        Element root = d.getDocumentElement();

        NodeList cards = root.getElementsByTagName("card");
        int cardNum = cards.getLength();

        //System.out.println(cardNum);

        for (int i = 0; i < cardNum; i++) {
            String number = "-1";
            String budget;
            String sceneName;
            String desc = "-1";
            
            List<Role> eachRole = new ArrayList<>();
            Node card = cards.item(i);
            sceneName = card.getAttributes().getNamedItem("name").getNodeValue();
            budget = card.getAttributes().getNamedItem("budget").getNodeValue();

            //System.out.println(sceneName + "\n  *Budget:" + budget);

            NodeList children = card.getChildNodes();
            /*
             * children map: 
             * -scene 
             * -part 
             *  -area 
             *  -line
             */

            for (int j = 0; j < children.getLength(); j++) {
                Node sub = children.item(j);

                String line, partLevel, partName;

                if ("scene".equals(sub.getNodeName())) {
                    number = sub.getAttributes().getNamedItem("number").getNodeValue();
                    //System.out.println("  *Number:" + number);

                    desc = sub.getTextContent();
                    //System.out.println("  *Description: " + desc);

                } else if ("part".equals(sub.getNodeName())) {

                    // number of parts is not the same for each card.
                    // must account for that before hand
                    NodeList parts = sub.getChildNodes();
                    

                     partName = sub.getAttributes().getNamedItem("name").getNodeValue();
                     partLevel = sub.getAttributes().getNamedItem("level").getNodeValue();

                    // initiate an arraylist for roles

                    for (int k = 0; k < parts.getLength(); k++) {
                        Node part = parts.item(k);

                        if ("line".equals(part.getNodeName())) {
                            //System.out.println("Part" + ": " + partName + "\n ->level " + partLevel);
                            line = part.getTextContent();
                            //System.out.println(" ->line \"" + line + "\"");
                            eachRole.add(new Role(partName, Integer.parseInt(partLevel), line));    
                        } else if ("area".equals(part.getNodeName())) {
                            String x, y, h, w;
                            x = part.getAttributes().getNamedItem("x").getNodeValue();
                            h = part.getAttributes().getNamedItem("h").getNodeValue();
                            w = part.getAttributes().getNamedItem("w").getNodeValue();
                            y = part.getAttributes().getNamedItem("y").getNodeValue();

                            //System.out.println("Area: " + x + ", " + y + ", " + h + ", " + w);
                        }

                    }
                    //System.out.println("\n");
                }
                // This is were all the data for each part of the arraylist is added

                // THis is were all the data for scene is added
                
            } // end parsing card children
            addingScenes.add(new Scene(sceneName, Integer.parseInt(budget), eachRole, Integer.parseInt(number), desc));
            //System.out.println();
        } // end parsing cards
        //System.out.println("\n");

        return addingScenes;
    }
}

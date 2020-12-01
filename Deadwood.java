import java.io.IOException;
import java.util.*;
import org.w3c.dom.Document;
import javax.swing.*;

public class Deadwood {



    public static void main(String args[]) throws IOException {



        BoardLayersListener boardGUI = new BoardLayersListener();
        boardGUI.setVisible(true);

        // Take input from the user about number of players
        int playerCount = Integer.parseInt(JOptionPane.showInputDialog(boardGUI, "How many players?"));
        

        // Make array of class Player called players of size how many players
        Board boardClass = new Board();

        
        String newName;

        List<Room> rooms = new ArrayList<Room>();
        List<Scene> scenes = new ArrayList<Scene>();
        List<Player> players = new ArrayList<Player>();

        Scanner in = new Scanner(System.in);

        Document cards;
        ParseXML cardsParsing = new ParseXML();
        try {

            cards = cardsParsing.getDocFromFile("cards.xml");
            scenes = cardsParsing.readCardData(cards);

        } catch (Exception e) {

            System.out.println("Error = " + e);

        }

        Document board;
        ParseXML boardParsing = new ParseXML();
        try {

            board = boardParsing.getDocFromFile("board.xml");
            rooms = boardParsing.readSetData(board);


            // match scenes to rooms before trailer and office 
    
            int min = 0;
            int max = scenes.size()-1;
            int sceneIndex;
            boolean isAssigned = false;
            for (int i = 0; i < rooms.size(); i++) {
                while (isAssigned == false) {
                    sceneIndex = (int) (Math.random() * (max - min + 1) + min);
                    if (!scenes.get(sceneIndex).getAssigned()) {
                        rooms.get(i).assignScene(scenes.get(sceneIndex));
                        // System.out.println(rooms.get(i).getName() + " has scene " +
                        // scenes.get(sceneIndex).getName());
                        isAssigned = true;
                    }
                }
                isAssigned = false;
            }


            //for all the rooms, place a card back on them
            for(int i = 0;i < rooms.size(); i++){
                boardGUI.addCard(rooms.get(i).getArea(), i);
            }



            //add trailer and office 
            rooms.addAll((boardParsing.readOfficeData(board)));
            rooms.addAll((boardParsing.readTrailerData(board)));

        } catch (Exception e) {

            System.out.println("Error = " + e);

        }

        boardClass.updateRooms(rooms);


        // for (int i = 0; i < scenes.size(); i++) {
        // scenes.get(i).printSceneInfo();

        // System.out.println("***************\n");
        // }
        // System.out.println(scenes.size());
        // System.out.println("***************\n***************\n***************\n");
        // for (int i = 0; i < rooms.size(); i++) {
        // rooms.get(i).printRoom();
        // System.out.println("***************\n");
        // }

        int days = 4;
        int credits = 0;
        int rank = 1;
        // 2-3 players = 3 days
        // 4 no change
        // 5 each player starts with 2 credits
        // 6 each player starts with 4 credits
        // 7-8 each player starts with rank 2
                            // "b", "c", "g", "o", "p", "r", "v", "w", "y"
            String[] colors = {"r", "o", "y", "g", "c", "b", "p", "v", "w"};


        for (int i = 0; i < playerCount; i++) {
            String diceName = colors[i] + rank + ".png";
            newName = JOptionPane.showInputDialog(boardGUI, "Player " + (i+1) + " name");
            players.add(new Player(newName, credits, rank, diceName, rooms));
        }
        boardGUI.initiatePlayers(players);



        //Test Prints all the board label positions 
        // boardGUI.printRoleLocations(rooms);
        // boardGUI.printTakesLocations(rooms);


        //Put players in the room equal to trailer 
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getName().equals("trailer")){
                for(int j = 0; j < players.size(); j++){
                    players.get(j).setRoom(rooms.get(i));
                }
            }
        }



        int input;


            boardGUI.updateRooms(rooms);

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < players.size(); j++) {
                System.out.println("Player " + players.get(j).getName() + ", what would you like to do?");
                System.out.println("You are in room: " + players.get(j).getRoomName());

                if(players.get(j).hasRole()){
                    System.out.println("You are have role " + players.get(j).getRoleName());
                }
                players.get(i).isTurn();

                boardGUI.updatePlayer(players.get(i));

                while (players.get(i).getTurnStatus()) {

                    System.out.println();
                    System.out.println("Day: " + (i + 1));
                    System.out.println("1) Act");
                    System.out.println("2) Rehearse");
                    System.out.println("3) Take Role");
                    System.out.println("4) Move");
                    System.out.println("5) Upgrade");
                    System.out.println("6) End");
                    System.out.print("Please pick a number: ");

                    input = in.nextInt();

                    if (input == 1) { // Act
                        // check acting checklist

                        if (players.get(j).hasRole()) {
                           
                            players.get(j).act();

                        } else {
                            System.out.println("Player does not have role");
                        }

                    } else if (input == 2) { // Rehearse
                        // rehearse checklist
                        if (players.get(j).hasRole()) {
                            players.get(j).rehearse();
                        } else {
                            System.out.println("Player does not have role");
                            
                        }

                    } else if (input == 3) { // Take Role
                        // take a role checklist
                        if (players.get(j).hasRole()) {
                            System.out.println("Player already has a role");
                        } else if((players.get(j).getRoomName().equals("trailer")) || (players.get(j).getRoomName().equals("office"))){
                            System.out.println("You cannot take on roles in trailer or office");
                        }else {

                            System.out.println("\nSelect a Role:");
                            players.get(j).getRoom().printOffCardRoles();
                            players.get(j).getRoom().getScene().printSceneInfo(players.get(j).getRoom().getOffCardRoleCount());

                            while(!players.get(j).hasRole()){

                                try{
                                    System.out.print("Select a role number: ");
                                    input = in.nextInt();
                                    

                                    //need to check if role is taken
                                    if(input <= players.get(j).getRoom().getOffCardRoleCount()){
                                        //player has chosen off card role
                                        
                                        if(!players.get(j).getRoom().isRoleTaken(j)){
                                            players.get(j).setRole(players.get(j).getRoom().getOffCardRole(input-1));
                                            players.get(j).getRoom().addPlayerToOffCardList(players.get(j));

                                        } else {
                                            System.out.println("Role is already taken");
                                        }
                                    } else {
                                        //player has chosen on card role
                                        players.get(j).setRole(players.get(j).getRoom().getScene().getRole(input-1));
                                        players.get(j).getRoom().addPlayerToOffCardList(players.get(j));
                                        players.get(j).playerChoseCardRole();
                                    }
                                } catch (Exception e){
                                    
                                }

                                System.out.println("Cannot accept that answer");
                                
                            }
                            System.out.println("Player has chosen role: " + players.get(j).getRoleName());
                            
                        }

                    } else if (input == 4) { // Move
                        if (players.get(j).hasRole()) {
                            System.out.println("Player does not have role and cannot cove");

                        } else if (players.get(j).hasMoved()) {
                            System.out.println("Player has already moved this turn");

                        } else {
                            System.out.println("Where would you like to move?");
                            players.get(j).printNeighbors();

                            while (!players.get(j).hasMoved()) {
                                players.get(j).showRoles();
                                System.out.print("Please pick a number: ");
                                try {
                                    input = in.nextInt() - 1;
                                    String newLocation = players.get(j).print1Neighbor(input);
                                    System.out.println("You have chosen: " + newLocation);

                                    for (int k = 0; k < rooms.size(); k++) {
                                        if (rooms.get(k).getName().equals(newLocation)) {
                                            Room newRoom = rooms.get(k);
                                            players.get(j).setRoom(newRoom);
                                            players.get(j).finishedMove();
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("Invalid input, please select again");
                                }
                            }

                            System.out.println("Done with moving");
                        }

                    } else if (input == 5) { // Upgrade
                        if (players.get(j).getRoom().equals("office")) {

                        } else {
                            System.out.println("Player not in office, cannot upgrade");
                        }

                    } else if (input == 6) { // End
                        // End turn
                        System.out.println("******EndingTurn*******\n\n");
                        players.get(i).endTurn();
                    }

                }
            }
        }
        in.close();
    }

}




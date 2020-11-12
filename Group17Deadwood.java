import java.util.*;
import org.w3c.dom.Document;

public class Group17Deadwood {
    
    public static void main(String args[]) {
        // Make array of class Player called players of size how many players
        Board boardClass = new Board();


        int playerCount;
        String newName;
        
        List<Room> rooms = new ArrayList<Room>();
        List<Scene> scenes = new ArrayList<Scene>();
        List<Player> players = new ArrayList<Player>();

        Scanner in = new Scanner(System.in);

        Document board;
        ParseXML boardParsing = new ParseXML();
        try {

            board = boardParsing.getDocFromFile("board.xml");
            rooms = boardParsing.readSetData(board);
            rooms.addAll((boardParsing.readOfficeData(board)));
            rooms.addAll((boardParsing.readTrailerData(board)));

        } catch (Exception e) {

            System.out.println("Error = " + e);

        }

        Document cards;
        ParseXML cardsParsing = new ParseXML();
        try {

            cards = cardsParsing.getDocFromFile("cards.xml");
            scenes = cardsParsing.readCardData(cards);

        } catch (Exception e) {

            System.out.println("Error = " + e);

        }



        boardClass.updateRooms(rooms);



        for (int i = 0; i < scenes.size(); i++) {
            scenes.get(i).printSceneInfo();

            System.out.println("***************\n");
        }
        System.out.println(scenes.size());
        System.out.println("***************\n***************\n***************\n");
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).printRoom();
            System.out.println("***************\n");
        }

        int days = 4;
        int credits = 0;
        int rank = 1;
        // 2-3 players = 3 days
        // 4 no change
        // 5 each player starts with 2 credits
        // 6 each player starts with 4 credits
        // 7-8 each player starts with rank 2

        System.out.print("Welcome to Deadwood!\nHow many players? (2-6): ");
        playerCount = in.nextInt();
        newName = in.nextLine();

        if (playerCount == 2 || playerCount == 3) {
            days = 3;
        } else if (playerCount == 4) {
            // no change
        } else if (playerCount == 5) {
            credits = 2;
        } else if (playerCount == 6) {
            credits = 4;
        } else if (playerCount <= 8) {
            rank = 2;
        } else {
            System.out.println("goodluck");
        }

        for (int i = 0; i < playerCount; i++) {
            System.out.print("Player " + (i + 1) + " what's your name: ");
            newName = in.nextLine();
            players.add(new Player(newName, credits, rank, rooms.get(11)));
        }

        System.out.println("Players:");
        for (int i = 0; i < players.size(); i++) {
            players.get(i).printName();
        }

        int input;

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < players.size(); j++) {
                System.out.println("Player " + players.get(j).getName() + ", what would you like to do?");
                System.out.println("You are in room: " + players.get(j).getRoomName());
                players.get(i).isTurn();

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

                        } else {
                            System.out.println("Player does not have role");
                        }

                    } else if (input == 2) { // Rehearse
                        // rehearse checklist
                        if (players.get(j).hasRole()) {

                        } else {
                            System.out.println("Player does not have role");
                        }

                    } else if (input == 3) { // Take Role
                        // take a role checklist
                        if (players.get(j).hasRole()) {
                            System.out.println("Player already has a role");
                        } else {
                           
                            

                        }

                    } else if (input == 4) { // Move
                        if (players.get(j).hasRole()) {
                            System.out.println("Player does not have role and cannot cove");

                        } else if(players.get(j).hasMoved()){
                            System.out.println("Player has already moved this turn");
                            
                            
                        }else {
                            System.out.println("Where would you like to move?");
                            players.get(j).printNeighbors();


                            while (!players.get(j).hasMoved()) {
                                players.get(j).showRoles();
                                System.out.print("Please pick a number: ");
                                try{
                                    input = in.nextInt();
                                    String newLocation = players.get(i).print1Neighbor(input);
                                System.out.println("You have chosen: " + newLocation);

                                    for(int k = 0; k < rooms.size(); k++){
                                        if(rooms.get(k).getName().equals(newLocation)){
                                            Room newRoom = rooms.get(k);
                                            players.get(j).setRoom(newRoom);
                                            players.get(i).finishedMove();
                                        }
                                    }
                                } catch(Exception e){
                                    System.out.println("Invalid input, please select again");
                                }
                            }

                            System.out.println("Done with moving");
                        }

                    } else if (input == 5) { // Upgrade

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

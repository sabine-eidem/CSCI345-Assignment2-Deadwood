import java.util.*;
import org.w3c.dom.Document;

public class Group17Deadwood {
    

    public static void main(String args[]){
        //Make array of class Player called players of size how many players
        int playerCount;
        String newName;


        List<Scene> scenes = new ArrayList<Scene>();
        List<Room> rooms = new ArrayList<Room>();
        List<Player> players = new ArrayList<Player>();


        Scanner in = new Scanner(System.in);

        Document board;
        ParseXML boardParsing = new ParseXML();
        try {

            board = boardParsing.getDocFromFile("board.xml");
            rooms = boardParsing.readSetData(board);

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
        for(int i = 0; i < scenes.size(); i++){
            scenes.get(i).printSceneInfo();

            System.out.println("***************\n");
        }
        System.out.println(scenes.size());
        System.out.println("***************\n***************\n***************\n");
        for(int i = 0; i < rooms.size(); i++) {
            rooms.get(i).printRoom();
            System.out.println("***************\n");
        }
        








        int days 4;
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
        for(int i = 0; i < playerCount; i++){
            System.out.print("Player " + (i+1) + " what's your name: ");
            newName = in.nextLine();
            players.add(new Player(newName));
        }

        System.out.println("Players:");
        for(int i = 0; i < players.size(); i++){
            players.get(i).printName();
        }







        //Tunrs 








        in.close();
    }


}

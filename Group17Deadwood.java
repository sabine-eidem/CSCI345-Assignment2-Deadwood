import java.util.*;
import org.w3c.dom.Document;

public class Group17Deadwood {
    

    public static void main(String args[]){
        //Make array of class Player called players of size how many players
        int playerCount;
        String newName;


        List<Scene> scenes = new ArrayList<Scene>();







        Scanner in = new Scanner(System.in);

        Document board;
        ParseXML boardParsing = new ParseXML();
        try {

            board = boardParsing.getDocFromFile("board.xml");
            boardParsing.readBoardData(board);

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

            System.out.println("***************");
        }
        System.out.println(scenes.size());
        
        System.out.println("Welcome to Deadwood!\nHow many players? (2-6)");
        // playerCount = in.nextInt();
        // Player[] Players = new Player[playerCount];
        // for(int i = 0; i < playerCount; i++){
        //     System.out.print("Player " + i+1 + "what's your name: ");
        //     newName = in.nextLine();
        //     Players[1] = new Player(newName);
        // }

        in.close();
    }
}

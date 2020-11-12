import java.util.List;

public class Board {
    private int totalPlayers, activePlayers;
    private int currentDay, totalDays;
    
    private List<Player> players;
    private List<Room> rooms;
    private List<Scene> scenes;
    private int[][] upgrades;
    private boolean activeGame;



    // public Board(int numPlayers, Room, List<Scene> scene, ){

    // }


    public List<Player> getPlayers() {
        return players;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public boolean isActiveGame() {
        return activeGame;
    }

    public void updateRooms(List<Room> newRooms) {
        rooms=newRooms;
    }

    
}

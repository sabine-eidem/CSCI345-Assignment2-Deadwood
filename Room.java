import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private int shotCounter;
    private int currentShots;
    private Scene currentScene;
    private List<String> neighbors;
    private List<Room> roomNeighbors;
    private List<Role> offCardRoles;
    private List<Boolean> shotList;
    private boolean visited;

    public Room(String newName, List<Boolean> shots, List<String> neighborNames, List<Role> roles) {
        name = newName;
        shotList = shots;
        neighbors = neighborNames;
        offCardRoles = roles;
        //roomNeighbors = convertNeighborsToRoomClass();
    }
    
    public Room(String newName, List<String> neighborNames) {
        name = newName;
        neighbors = neighborNames;
        shotList = new ArrayList<>();
        offCardRoles = new ArrayList<>();
        //roomNeighbors = convertNeighborsToRoomClass();
    }


    //trying to get the room object so that I can easily saw it out 
    //ended up not liking this idea

    // public List<Room> convertNeighborsToRoomClass(){
    //     List<Room> classNeighbors = new ArrayList<Room>();
    //     Board tempBoard = new Board();
    //     for(int i = 0; i < tempBoard.getRooms().size(); i++){
    //         tempBoard.rooms.
    //     }

    //     return classNeighbors;
    // }


    public void printRoom() {
        System.out.println("Name: " + name);
        System.out.println("Visited: " + visited);
        printShotList();
        printNeighbors();
        printOffCardRoles();
    }
    
    public void printNeighbors() {
        System.out.println("Neighbors:");

        for(int i = 0; i < neighbors.size(); i++){
            System.out.println(" -" + (i) + ")" + neighbors.get(i));
        }
    }

    public void printOffCardRoles() {
        System.out.println("OffCardRoles:");

        for(int i = 0; i < offCardRoles.size(); i++){
            offCardRoles.get(i).printRoleInfo();
        }
    }

    public String printNeighbor(int i) {
        return neighbors.get(i);
    }


    public void printShotList(){
        System.out.println("Shots:");

        for(int i = 0; i <shotList.size(); i++){
            System.out.println(" -Shot " + i + " taken: " + shotList.get(i));
        }

    }

    public String getName(){
        return name;
    }
}

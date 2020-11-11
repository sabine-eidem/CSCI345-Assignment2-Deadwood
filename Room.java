import java.util.List;

public class Room {
    private String name;
    private int shotCounter;
    private int currentShots;
    private Scene currentScene;
    private List<String> neighbors;
    private List<Role> offCardRoles;
    private List<Boolean> shotList;
    private boolean visited;

    public Room(String newName, List<Boolean> shots, List<String> neighborNames, List<Role> roles) {
        name = newName;
        shotList = shots;
        neighbors = neighborNames;
        offCardRoles = roles;
    }



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
            System.out.println(" -" + neighbors.get(i));
        }
    }

    public void printOffCardRoles() {
        System.out.println("OffCardRoles:");

        for(int i = 0; i < offCardRoles.size(); i++){
            offCardRoles.get(i).printRoleInfo();
        }
    }


    public void printShotList(){
        System.out.println("Shots:");

        for(int i = 0; i <shotList.size(); i++){
            System.out.println(" -Shot " + i + " taken: " + shotList.get(i));
        }

    }
}

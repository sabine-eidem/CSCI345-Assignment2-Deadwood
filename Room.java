import java.util.ArrayList;
import java.util.HashMap;
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
    private List<Player> onCardPlayers;
    private List<Player> offCardPlayers;
    private HashMap<String, Integer> areaInfo;
    private List<HashMap<String, Integer>> nativePartsList;
    private List<HashMap<String, Integer>> takesAreaHashList;
    private boolean visited;
    private boolean wrapped;

    public Room(String newName, List<Boolean> shots, List<String> neighborNames, List<Role> roles,
                HashMap<String, Integer> area, List<HashMap<String, Integer>> NativePartsList, 
                List<HashMap<String, Integer>> TakesAreaHashList) {
        name = newName;
        shotList = shots;
        neighbors = neighborNames;
        offCardRoles = roles;
        wrapped = false;
        offCardPlayers = new ArrayList<>();
        onCardPlayers = new ArrayList<>();
        areaInfo = area;
        nativePartsList = NativePartsList;
        takesAreaHashList = TakesAreaHashList;

        //roomNeighbors = convertNeighborsToRoomClass();
    }
    
    public Room(String newName, List<String> neighborNames) {
        name = newName;
        neighbors = neighborNames;
        shotList = new ArrayList<>();
        offCardRoles = new ArrayList<>();
        wrapped = false;
        offCardPlayers = new ArrayList<>();
        onCardPlayers = new ArrayList<>();
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
            System.out.println(" -" + (i+1) + ")" + neighbors.get(i));
        }
    }

    public void printOffCardRoles() {
        System.out.println("OffCardRoles:");

        for(int i = 0; i < offCardRoles.size(); i++){
            System.out.print("\t" + (i+1) + ") ");
            offCardRoles.get(i).printRoleInfo();
        }
    }

    public String printNeighbor(int i) {
        return neighbors.get(i);
    }


    public void printShotList(){
        System.out.println("Shots:");

        for(int i = 0; i <shotList.size(); i++){
            System.out.println(" -Shot " + (i+1) + " taken: " + shotList.get(i));
        }

    }

    // return true if list is all true (then its a wrap!)
    public boolean takeOffAShot(){
        for(int i = 0; i < shotList.size(); i++){
            if(i == shotList.size()-1){
                shotList.set(i, true);
                System.out.println("ITS A WRAP!");
                //It's a wrap!
                wrapped = true;
                wrappedPayout();
                return true;
            } else if(shotList.get(i) == false){
                shotList.set(i, true);
                return false;
            }
        }
        return true;
    }

    public Scene getScene(){
        return currentScene;
    }

    public void assignScene(Scene newScene){
        currentScene = newScene;
        currentScene.assign();
    }

    public String getName(){
        return name;
    }

    public boolean getWraped(){
        return wrapped;
    }

    public int getOffCardRoleCount(){
        return offCardRoles.size();
    }

    public boolean isRoleTaken(int i){
        return offCardRoles.get(i).isTaken();
    }

    public Role getOffCardRole(int i){
        return offCardRoles.get(i);
    }

    public void addPlayerToCardList(Player player){
        onCardPlayers.add(player);
    }

    public void addPlayerToOffCardList(Player player){
        offCardPlayers.add(player);
    }

    public HashMap<String, Integer> getArea(){
        return areaInfo;
    }

    public List<Role> getOffCardRoles(){
        return offCardRoles;
    }
    public List<HashMap<String, Integer>> getNativePartsData(){
        return nativePartsList;
    }

    public List<HashMap<String, Integer>> getTakesAreaHashList(){
        return takesAreaHashList;
    }

    public List<String> getNeighbors(){
        return neighbors;
    }

    public void wrappedPayout(){

        try{

            for(int i = 0; i < offCardPlayers.size(); i ++){
                offCardPlayers.get(i).printName();
            }
    
            for (int i = 0; i < onCardPlayers.size(); i++) {
                onCardPlayers.get(i).printName();
            }
        } catch (Exception e){

        }


    }


}

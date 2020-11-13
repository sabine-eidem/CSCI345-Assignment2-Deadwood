import java.io.*;
public class Player {
    private String name;
    private int dollars, credits, rank, chips;
    private boolean hasRole;
    private boolean hasTurn;
    private boolean onCard;
    private boolean hasMoved;
    private Role currentRole;
    private Room currentRoom;


    public Player (String Name, int creds, int Rank){
        name = Name;
        dollars = 0;
        credits = creds;
        rank = Rank;
        hasRole = false;
        chips = 0;
        hasMoved = false;
        onCard = false;
    }

    public String getName() {
        return name;
    }

    private int rollDice(int numDice) {
        int roll = 0;
        for (int i = 0; i < numDice; i++) {
            roll += (int) (Math.random() * 6) + 1;
        }
        return roll + chips;
    }

    public void act(){
        
        if(!currentRoom.getWraped()){
            int roll;
            int budget = currentRoom.getScene().getBudget();
            System.out.println("You are rolling to get at or above " + budget);
            
            roll = rollDice(1);
            System.out.println("You roll a " + roll);
            
            if(roll >= budget){
                System.out.println("You did well in the shot!");
                currentRoom.takeOffAShot();
            } else {
                System.out.println("You did not do well in the shot");
            }
            
            currentRoom.printShotList();
        } else {
            System.out.println("Scene is wrapped, you cannot act");
        }


    }

    public int getRank() {
        return rank;
    }

    public void playerChoseCardRole(){
        onCard = true;
    }

    public boolean getOnCard(){
        return onCard;
    }

    public void setRole(Role newRole){

        if(newRole.getRank() <= rank){
            currentRole = newRole;
            hasRole = true;

        } else {
            //System.out.println("Cannot take that role");
        }
    }

    public void isTurn(){
        hasTurn = true;
    }

    public void endTurn(){
        hasTurn = false;
        hasMoved = false;
    }

    public boolean getTurnStatus(){
        return hasTurn;
    }

    public boolean hasMoved(){
        return hasMoved;
    }

    public void finishedMove(){
        hasMoved = true;
    }

    public boolean hasRole() {
        return hasRole;
    }

    public Role getRole() {
        return currentRole;
    }

    public String getRoleName(){
        return currentRole.getName();
    }

    public Room getRoom() {
        return currentRoom;
    }

    public String getRoomName(){
        return currentRoom.getName();
    }

    public void setRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    public void rehearse() {
        chips++;
    }

    public void upgradeToRank(int newRank) {
        rank = newRank;
        return;
    }

    public int changeDollars(int amount) {
        return dollars += amount;
    }

    public int changeCredits(int amount) {
        return credits += amount;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCredits() {
        return credits;
    }

    public int getChips() {
        return chips;
    }

    public void printName() {
        System.out.println(" -" + name);
    }

    public void printNeighbors(){
        currentRoom.printNeighbors();
    }

    public String print1Neighbor(int i){
        return currentRoom.printNeighbor(i);
    }

    public void showRoles(){

    }

}

import java.io.*;
public class Player {
    private String name;
    private int dollars, credits, rank, chips;
    private boolean hasRole;
    private boolean hasTurn;
    private boolean hasMoved;
    private Role currentRole;
    private Room currentRoom;


    public Player (String Name, int creds, int dank, Room rome){
        name = Name;
        dollars = 0;
        credits = creds;
        rank = dank;
        currentRoom =rome;
        hasRole = false;
        chips = 0;
        hasMoved = false;
    }

    public String getName() {
        return name;
    }

    private int rollDice(int numDice) {
        int roll = 0;
        for (int i = 0; i < numDice; i++) {
            roll += (int) (Math.random() * 6) + 1;
        }
        return roll;
    }

    public int getRank() {
        return rank;
    }

    public void takeRole(Role newRole){

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
        return;
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

import java.io.*;
public class Player {
    private String name;
    private int dollars, credits, rank, chips;
    private boolean hasRole;
    private Role currentRole;
    private Room currentRoom;


    public Player (String Name){
        name = Name;
        dollars = 0;
        credits = 0;
        rank = 1;
        hasRole = false;
        chips = 0;
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


    public boolean hasRole() {
        return hasRole;
    }

    public Role getRole() {
        return currentRole;
    }

    public Room getRoom() {
        return currentRoom;
    }

    public void setRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    public void rehearse() {
        chips++;
        return;
    }

    public void moveTo(Room newRoom) {
        currentRoom = newRoom;
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

}

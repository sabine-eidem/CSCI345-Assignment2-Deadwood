import java.util.*;
import java.io.*;


class player extends actor {
    void move(){

    } //End Move

    void work(){

    } // End Work

    void upgrade() {

    } // End Upgrade

    int diceRoll(){
        return -1;
    } // end Dice Roll

} // end player


abstract class banker extends actor {
    abstract void startUp();
    abstract void endOfDay();
    abstract void endOfGame();
    
    
} // end banker





abstract class segment extends board {
    abstract void fillSegment();
    abstract void fillRoom();
    abstract void findAvalibleMoves();
    abstract void closeScene();

} // end segment


abstract class room extends segment{
    abstract void shotCounterDone();
} // End Room








class group17Deadwood{


    




    public static void main(String[] args) throws Exception{
            
    } // end Main

} // end group17Deadwood class 
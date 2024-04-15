//Sukhman Singh & Kobe Cottenie
//June 19, 2023
//Basic Chess Game Program

//import libraries
import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {
        //display rules
        System.out.println( "------------------------CHESS VARIATION--------------------------------"
        +"\n----------------------------Rules--------------------------------------\n"
        +"1.If the king is in check and an invalid move is provided the game will end\n"
        + "2.There is no draws, so please keep that in mind while playing\n"
        + "3.If there is a check you can move out of it or move a piece to block the check"
        +"\n4.If you do a move that will lead to a discovered check by the opponent you will get to make an additional move"
        +"\n5.You can't castle"
        +"\n6.You can't en passant\n");
        
        // Make a new board
        Board b = new Board();
        int turn = 2; //int for checking if the game ended or not, and whose turn it is
        boolean end = false;//boolean for the while loop
        
        //while loop to run the game until checkmate
        while (end != true) {
            //even 
            if (turn % 2 == 0) {
                turn = Chess.smthing(b, 2); //run the code containing the game
                //if the smthing method returned 0 end the game
                if(turn == 0){
                    System.out.println("White side won");
                    end = true;
                }
            }
            //odd
            else{
                turn = Chess.smthing(b, 1);
                if(turn == 0){
                    System.out.println("Black side won");
                    end = true;
                }
            }
        }
    }
}
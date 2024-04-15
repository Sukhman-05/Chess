//import the scanner class
import java.util.Scanner;

public class Chess
{
    //make a scanner to get which piece is being moved to where
    public static Scanner move = new Scanner(System.in);
    public static int turn = 0; //turn int to know whose turn it is
    
    
    //precondition: String containning what to ask the player
    //postcondition: an int containing the row that the player selected
    //method to get the rown from the player
    public static int getRow(String prompt){
        System.out.println(prompt);
        int moveNum = 0;
        
        while(!move.hasNextInt()){
            move.nextLine();   
            System.out.println("Invalid entry - please try again ");
            System.out.println(prompt);
        }
        moveNum = move.nextInt();
        
        //makes sure that the input is not out of the board
        while(!(moveNum >= 1 && moveNum <= 8)){
            System.out.println("Entry is out of range");
			System.out.println("Range is from 1 to 8");
    		while(!move.hasNextInt()){
                move.nextLine();   
                System.out.println("Invalid entry - please try again ");
                System.out.println(prompt);
            }
            moveNum = move.nextInt();
        }
        
        return moveNum - 1;
    }
    
    //precondition: String containing the prompt to use while getting the coloumn
    //postcondition: an int containing the value matching the inputted letter
    //method to get the coloumn letter and translate it into a num
    public static int getCol(String prompt){
        //get starting y pos of piece through letter
        System.out.println(prompt);
        String moveLet = move.next();
        moveLet = moveLet.toUpperCase();
        boolean exit = false;
        int moveLetterNum = 0;
        
        while(exit != true){
            //check the letters and set them to the corresponding y value
            if(moveLet.equals("A")){
                //A represents coloumn 0
                moveLetterNum = 0;
                exit = true;
            }
            else if(moveLet.equals("B")){
                //B represents coloumn 1
                moveLetterNum = 1;
                exit = true;
            }
            else if(moveLet.equals("C")){
                //C represents coloumn 2
                moveLetterNum = 2;
                exit = true;
            }
            else if(moveLet.equals("D")){
                //D represents coloumn 3
                moveLetterNum = 3;
                exit = true;
            }
            else if(moveLet.equals("E")){
                //E represents coloumn 4
                moveLetterNum = 4;
                exit = true;
            }
            else if(moveLet.equals("F")){
                //F represents coloumn 5
                moveLetterNum = 5;
                exit = true;
            }
            else if(moveLet.equals("G")){
                //G represents coloumn 6
                moveLetterNum = 6;
                exit = true;
            }
            else if(moveLet.equals("H")){
                //H represents coloumn 7
                moveLetterNum = 7;
                exit = true;
            }
            else{
                System.out.println("Invalid entry - try again");
                return getCol(prompt);
            }
        }
        
        return moveLetterNum;
    }
    
    //precondition: the board that needs to be checked
    //postcondition: boolean containing whether the king is in check or not
    //method that returns whether the king is in check or not
    public static boolean kingInCheck(Board b){
        boolean isCheck = false;//the king is not in check at the start
        int bKingX = 0;//posX of the black King
        int bKingY = 0;
        int wKingX = 0;//posX of the white King
        int wKingY = 0;
        
        // Find the positions of the white and black kings
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Pieces piece = b.getP(x, y);
                if (piece instanceof King) {
                    if (piece.getColor() == 1) {
                        bKingX = x;
                        bKingY = y;
                    } else {
                        wKingX = x;
                        wKingY = y;
                    }
                }
            }
        }
        
        //check if the king is in check
        boolean bKingInCheck = isKingInCheck(b, bKingX, bKingY, 2);
        boolean wKingInCheck = isKingInCheck(b, wKingX, wKingY, 1);
        
        //if one of the kings is in check, turn the isCheck boolean to true
        if(bKingInCheck == true){
            isCheck = true;
        }
        else if(wKingInCheck == true){
            isCheck = true;
        }
        
        return isCheck;
    }
    
    //precondition: the board with all the pieces, the posX and posY of the king, the color of the other side
    //postcondition: boolean telling whether a specific King is check or not
    //handles the logic behing checking if the king is in check
    private static boolean isKingInCheck(Board b, int kingX, int kingY, int opponentColor) {
        // Iterate through all the opponent's pieces
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Pieces piece = b.getP(x, y);
                if (piece.getColor() != 0 && piece.getColor() == opponentColor) {
                    if (piece.canMove(kingX, kingY, b)) {
                        return true; // The king is in check
                    }
                }
            }
        }
        
        return false; // The king is not in check
    }
    
    
    //precondition: the board with all the pieces and the currenc Color of the player's side
    //postcondition: int containing whether the game has ended and whose turn it is(0 end, 1 black, 2 white)
    //handles all the logic of the game and runs the game
    public static int smthing(Board b, int currentC)
    {
        //declaration for various variables throughout the code
        String moveLet = ""; //String for the letter of the board to convert into num
        int moveNum = 0; //x pos starting
        int moveLetterNum = 0; //y pos starting
        int posX = 0; //x pos after
        int posY = 0; //y pos after
        boolean looper = true;//used in while loops to keep prompting for the right choice
        boolean validMove = false; //checks if the move is valid
        int color = 0; //checks the color of side(1 black, 2 white) for turns etc.
        String prompt = ""; //prompt for when ask ing input to user
        boolean loop = false;//boolean for a loop
        String pieceI = ""; //the selected piece
        boolean kingCheck = false;//variable to keep track of the king being in check
        
        while(validMove != true){
            //setting variables that need to be reset to these values each iteration
            boolean check = false;//boolean for the while loop, needs to reset each while loop
            loop = false;//makes sure that loop is false at the start of the piece picking process
            boolean isPiece = false;//boolean to check if it's a valid piece
            looper = false;//makes sure that looper is false at the start of the piece picking process
            
            //show the board at the start 
            System.out.println(b.toString());
            
            //Get piece and its old position
            while(check != true && isPiece != true){
                //set starting prompt for the getCol and getRow methods
                prompt = "Enter starting col: ";
                
                while(loop != true){
                    
                    //get which piece to move
                    System.out.println("Enter Piece to move: ");
                    pieceI = move.next();
                    pieceI = pieceI.toUpperCase();
                    
                    //check if the user entered a valid piece name
                    if(pieceI.equals("PAWN")){
                        check = true;
                        loop = true;
                    }
                    else if(pieceI.equals("KING")){
                        check = true;
                        loop = true;
                    }
                    else if(pieceI.equals("QUEEN")){
                        check = true;
                        loop = true;
                    }
                    else if(pieceI.equals("KNIGHT")){
                        check = true;
                        loop = true;
                    }
                    else if(pieceI.equals("ROOK")){
                        check = true;
                        loop = true;
                    }
                    else if(pieceI.equals("BISHOP")){
                        check = true;
                        loop = true;
                    }
                    else{
                        System.out.print("\033[H\033[2J"); // Clear screen
                        System.out.println(b.toString());
                        System.out.println("Invalid Entry - Try again");
                        loop = false;
                        check = false;
                    }
                }
                //if the name was valid get the start position
                if(check == true){
                    moveLetterNum = getCol(prompt);
                    prompt = "Enter starting row: ";
                    moveNum = getRow(prompt);
                    check = true;
                }
                
                //check if the piece name given and the piece on the board at that position match
                Pieces selected = b.getP(moveNum, moveLetterNum);
                String s = b.getP(moveNum, moveLetterNum).getName();
                if(selected.getColor() == currentC && selected.getName().equals(pieceI)){
                    System.out.println("Successfully selected: " + s);
                    isPiece = true;
                }
                else{
                    System.out.print("\033[H\033[2J"); // Clear screen
                    System.out.println(b.toString());
                    System.out.println("Invalid piece selected");
                    check = false;
                    loop = false;
                }
            }
            
            //get new positions
            prompt = "Enter new coloumn letter";
            posY = getCol(prompt);
            prompt = "Enter new row: ";
            posX = getRow(prompt);
            
            //check for valid move and if true clear the screen
            //else run again
            validMove = b.getP(moveNum, moveLetterNum).canMove(posX, posY, b);
            if(validMove == true){
                System.out.print("\033[H\033[2J"); // Clear screen
                // System.out.println(b.toString());
            }
            else if(validMove == false){
                System.out.print("\033[H\033[2J"); // Clear screen
                System.out.println("Your move was not valid - try again");
            }
        }
        //actually move the piece on the board
        b.getP(moveNum, moveLetterNum).move(posX, posY, b);
        
        //check if the king is in check
        kingCheck = kingInCheck(b);
        //if the king is in check get a move to get the king out of check
        if(kingCheck == true){
            System.out.println("There is a check! Please move a piece to protect the king");
            System.out.println("If an invalid move is provided the game will end");
            System.out.println(b.toString());
            moveLetterNum = getCol("Starting Col");
            moveNum = getRow("Starting Row:");
            posY = getCol("New Col:");
            posX = getRow("New Row:");
            validMove = b.getP(moveNum, moveLetterNum).canMove(posX, posY, b);
            System.out.println("Valid: " + validMove);
            //if the move is valid move the piece and check for a check on the king again
            //if there is still a check assume a checkmate and end the game
            if(validMove == true){
                b.getP(moveNum, moveLetterNum).move(posX, posY, b);
                kingCheck = kingInCheck(b);
                if(kingCheck == true){
                    System.out.println("Game Over");
                    return 0;
                }//else increase the counter for the turn
                else{
                    System.out.print("\033[H\033[2J"); // Clear screen
                    // a
                    turn++;
                }
            }
            //if an invalid move is provided then the game is over
            else{
                System.out.println("Game Over");
                return 0;
            }
        }
        //increment turn for the player
        turn++;
        return turn;
        
    }
}
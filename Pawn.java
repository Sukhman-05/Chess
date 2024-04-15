import java.util.Scanner;

public class Pawn extends Pieces{
    
    public static Scanner move = new Scanner(System.in);
    
    //default constructor for middle white king's pawn
    public Pawn(){
        super();
        setName("PAWN");
        setFace("PAWN", 1);
        setPosX(4);
        setPosY(1);
        setColor(1);
    }
    
    //overloaded constructor for a pawn specifying color and position
    public Pawn(int x, int y, int c){
        super();
        setName("PAWN");
        setFace("PAWN", c);
        setPosX(x);
        setPosY(y);
        setColor(c);
    }
    
    //precondition: position of the piece and teh board it is on
    //postcondition: a boolean determining if the movid is valid or not
    //Override the method to determine the movent of a piece
    @Override
    public boolean canMove(int x, int y, Board b){
        
        boolean validMove = false;
        int oldX = getPosX();
        int oldY = getPosY();
        
        //move fwd by one if balck
        if(oldX + 1 == x && oldY == y && b.getP(oldX, oldY).getColor() == 1 && b.getP(x,y).getColor() == 0 ){
            validMove = true;
        }
        //move fwd by one (White Pawn)
        else if(getPosX() - 1 == x && getPosY() == y && b.getP(oldX, oldY).getColor() == 2  && b.getP(x,y).getColor() == 0){
            validMove = true;
        }
        //move by two if on starting square(Black)
        else if(getPosX() + 2 == x && getPosY() == y && getPosX() == 1 && b.getP(oldX, oldY).getColor() == 1  && b.getP(x,y).getColor() == 0){
            validMove = true;
        }
        //move by two if on starting square(Black)
        else if(getPosX() - 2== x && getPosY() == y && getPosX() == 6 && b.getP(oldX, oldY).getColor() == 2  && b.getP(x,y).getColor() == 0){
            validMove = true;
        }
        //left-up take
        else if(getPosX() - 1 == x && getPosY() + 1 == y && b.getP(oldX, oldY).getColor() == 2){
            //if they are not on the same side
            if(b.getP(x, y).getColor() != 2 && b.getP(x, y).getColor() != 0 ){
                validMove = true;
            }
        }
        //right-up take
        else if(getPosX() + 1 == x && getPosY() + 1 == y && b.getP(oldX, oldY).getColor() == 1){
            //if they are not on the same side
            if(b.getP(x, y).getColor() != 1 && b.getP(x, y).getColor() != 0 ){
                validMove = true;
            }
        }
        //left-up take for white
        else if(getPosX() - 1 == x && getPosY() - 1 == y && b.getP(oldX, oldY).getColor() == 2){
            if(b.getP(x, y).getColor() != 2 && b.getP(x, y).getColor() != 0 ){
                validMove = true;
            }
        }
        //right-up take for white
        else if(getPosX() + 1 == x && getPosY() - 1 == y && b.getP(oldX, oldY).getColor() == 1){
            if(b.getP(x, y).getColor() != 1 && b.getP(x, y).getColor() != 0 ){
                validMove = true;
            }
        }
        
        return validMove;
    }
    
    //precondition: position of the piece and the board it is on
    //postcondition: returns nothing as it's a void method, changes the pos of the piece
    //Override the method to actually move the piece on the board
    @Override
    public void move(int x, int y, Board b){
        int oldX = getPosX();
        int oldY = getPosY();
        int currentC = b.getP(getPosX(), getPosY()).getColor();
        Pawn moving = new Pawn(oldX,oldY, currentC);
        boolean loop = false;
        String pieceI = "";
        
        //move the piece
        if(canMove(x, y, b) == true){
            //remove piece at the newPos
            b.remP(x,y);
            
            //change current piece pos
            moving.setPosX(x);
            moving.setPosY(y);
            
            //remove old piece
            b.remP(oldX, oldY);
            
            //change the old pos piece to the new pos
            b.setP(x,y,moving);
        }
        
        //Checks to see if a pawn is at one of the ends of the board
        if(x == 0 || x == 7){
            b.toString();
            //Loops untill a valid piece is enterd
            while(loop != true){
                //get which piece to change to
                System.out.println("Enter Piece to Change to: ");
                pieceI = move.next();
                pieceI = pieceI.toUpperCase();
                
                //check if the user entered a valid piece name
                if(pieceI.equals("QUEEN")){
                    Queen newQ = new Queen(x, y, currentC);
                    b.remP(x, y);
                    b.setP(x, y, newQ);
                    loop = true;
                }
                else if(pieceI.equals("KNIGHT")){
                    Knight newK = new Knight(x, y, currentC);
                    b.remP(x, y);
                    b.setP(x, y, newK);
                    loop = true;
                }
                else if(pieceI.equals("ROOK")){
                    Rook newR = new Rook(x, y, currentC);
                    b.remP(x, y);
                    b.setP(x, y, newR);
                    loop = true;
                }
                else if(pieceI.equals("BISHOP")){
                    Bishop newB = new Bishop(x, y, currentC);
                    b.remP(x, y);
                    b.setP(x, y, newB);
                    loop = true;
                }
                else{
                    System.out.println("Invalid Entry - Try again");
                    loop = false;
                }
            }
        }
    }
    
    //precondition: none
    //postcondition: Return a string containing the face attribute of the piece
    //toString printing the character of a piece(stored as a string)
    @Override
    public String toString(){
        return getFace();
    }
}
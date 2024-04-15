public class Queen extends Pieces {

    //set up a default constructor for white queen
    public Queen(){
        setName("QUEEN");
        setFace("QUEEN", 1);
        setPosX(3);
        setPosY(0);
        setColor(1);
    }
    
    //overloaded constructor for a queen specifying color and position
    public Queen(int x, int y, int c){
        setName("QUEEN");
        setFace("QUEEN", c);
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
        int currentC = getColor();
        int targetColor = b.getP(x, y).getColor();
    
        // Check if the target position is not occupied by a piece of the same color
        if (targetColor != currentC) {
            Bishop tempB = new Bishop(oldX, oldY, currentC);
            Rook tempR = new Rook(oldX, oldY, currentC);
    
            if (tempB.canMove(x, y, b) || tempR.canMove(x, y, b)) {
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
        int currentC = 0;
        
        currentC = b.getP(getPosX(), getPosY()).getColor();
        
        Queen moving = new Queen(oldX, oldY, currentC);
        
        if(canMove(x, y, b) == true){
            moving.setPosX(x);
            moving.setPosY(y);
            b.remP(oldX, oldY);
            b.setP(x,y,moving);
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
public class King extends Pieces{

    //King object default to the white king
    public King(){
        super();
        setName("KING");
        setFace("KING", 1);
        setPosX(4);
        setPosY(0);
        setColor(1);
    }
    
    //overloaded constructor for a king specifying color and position
    public King(int x, int y, int c){
        super();
        setName("KING");
        setFace("KING", c);
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

        //change pos only if the x and y move it by one
        //up right
        if(getPosX() + 1 ==  x && getPosY() + 1 ==  y  && b.getP(oldX, oldY).getColor() != b.getP(x, y).getColor()){
            validMove = true;
        }
        //down right
        else if(getPosX() + 1 == x  && getPosY() - 1 == y  && b.getP(oldX, oldY).getColor() != b.getP(x, y).getColor()){
            validMove = true;
        }
        //up left
        else if(getPosX() - 1 == x  && getPosY() + 1 == y  && b.getP(oldX, oldY).getColor() != b.getP(x, y).getColor()){
            validMove = true;
        }
        //down left
        else if(getPosX() - 1 == x  && getPosY() - 1 == y  && b.getP(oldX, oldY).getColor() != b.getP(x, y).getColor()){
            validMove = true;
        }
        //left
        else if(getPosX() - 1 == x  && getPosY() == y  && b.getP(oldX, oldY).getColor() != b.getP(x, y).getColor()){
            validMove = true;
        }
        //down
        else if(getPosX() == x  && getPosY() - 1 == y  && b.getP(oldX, oldY).getColor() != b.getP(x, y).getColor()){
            validMove = true;
        }
        //up
        else if(getPosX() == x  && getPosY() + 1 == y  && b.getP(oldX, oldY).getColor() != b.getP(x, y).getColor()){
            validMove = true;
        }
        //right
        else if(getPosX() + 1 == x  && getPosY() == y  && b.getP(oldX, oldY).getColor() != b.getP(x, y).getColor()){
            validMove = true;
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
        King moving = new King(oldX,oldY, b.getP(getPosX(), getPosY()).getColor());
        
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
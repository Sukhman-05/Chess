public class Knight extends Pieces{

    //default constructor for the left white knight
    public Knight(){
        super();
        setName("KNIGHT");
        setFace("KNIGHT", 1);
        setPosX(1);
        setPosY(0);
        setColor(1);
    }
    
    //overloaded constructor for a knight specifying color and position
    public Knight(int x, int y, int c){
        super();
        setName("KNIGHT");
        setFace("KNIGHT", c);
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
        
        //8 cases
        //move up 2 - right 1   
        if(getPosX() + 1 == x && getPosY() + 2 == y){
            if(b.getP(getPosX(), getPosY()).getColor() != b.getP(x, y).getColor()){
                validMove = true;
            }
        }
        //move up 2 - left 1    
        else if(getPosX() - 1 == x && getPosY() + 2 == y){
            if(b.getP(getPosX(), getPosY()).getColor() != b.getP(x, y).getColor()){
                validMove = true;
            }
        }
        //move right 2 - up 1
        else if(getPosX() + 2 == x && getPosY() + 1 == y){
            if(b.getP(getPosX(), getPosY()).getColor() != b.getP(x, y).getColor()){
                validMove = true;
            }
        }
        //move right 2 - down 1
        else if(oldX + 2 == x && getPosY() - 1 == y){
            if(b.getP(getPosX(), getPosY()).getColor() != b.getP(x, y).getColor()){
                validMove = true;
            }
        }
        //move left 2 - up 1
        else if(getPosX() - 2 == x && getPosY() + 1 == y){
            if(b.getP(getPosX(), getPosY()).getColor() != b.getP(x, y).getColor()){
                validMove = true;
            }
        }
        //move left 2 - down 1
        else if(getPosX() - 2 == x && getPosY() - 1 == y){
            if(b.getP(getPosX(), getPosY()).getColor() != b.getP(x, y).getColor()){
                validMove = true;
            }
        }
        //move down 2 - right 1  
        else if(getPosX() + 1 == x && getPosY() - 2 == y){
            if(b.getP(getPosX(), getPosY()).getColor() != b.getP(x, y).getColor()){
                validMove = true;
            }
        }
        //move down 2 - left 1   
        else if(getPosX() - 1 == x && getPosY() - 2 == y){
            if(b.getP(getPosX(), getPosY()).getColor() != b.getP(x, y).getColor()){
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
        Knight moving = new Knight(oldX,oldY, b.getP(getPosX(), getPosY()).getColor());
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
    }
    
    //precondition: none
    //postcondition: Return a string containing the face attribute of the piece
    //toString printing the character of a piece(stored as a string)
    @Override
    public String toString(){
        return getFace();
    }
}
public class Rook extends Pieces{

    //default constructor for a white rook on the left corner
    public Rook(){
        super();
        setName("ROOK");
        setFace("ROOK", 1);
        setPosX(0);
        setPosY(0);
        setColor(1);
    }
    
    //overloaded constructor for a rook specifying color and position
    public Rook(int x, int y, int c){
        super();
        setName("ROOK");
        setFace("ROOK", c);
        setPosX(x);
        setPosY(y);
        setColor(c);
    }
    
    //precondition: position of the piece and teh board it is on
    //postcondition: a boolean determining if the movid is valid or not
    //Override the method to determine the movent of a piece
    @Override
    public boolean canMove(int x, int y, Board b){
        int oldX = getPosX();
        int oldY = getPosY();

        // Check if the new position is within the board bounds
        if (x < 0 || x >= 8 || y < 0 || y >= 8)
            return false;

        // Check if the rook is moving horizontally or vertically
        if (x != oldX && y != oldY)
            return false;

        // Check if there are any pieces blocking the rook's path
        if (x == oldX) {
            int start = Math.min(oldY, y) + 1;
            int end = Math.max(oldY, y);
            for (int i = start; i < end; i++) {
                if (b.getP(x, i).getColor() != 0)
                    return false; // There is a piece blocking the path
            }
        } else {
            int start = Math.min(oldX, x) + 1;
            int end = Math.max(oldX, x);
            for (int i = start; i < end; i++) {
                if (b.getP(i, y).getColor() != 0)
                    return false; // There is a piece blocking the path
            }
        }

        // Check if the destination position contains an opponent's piece or is empty
        if (b.getP(x, y).getColor() != getColor() && b.getP(x, y).getColor() != 0)
            return true; // Valid move, captures opponent's piece
        if (b.getP(x, y).getColor() == 0)
            return true; // Valid move, empty position

        return false; // Invalid move
    }
    
    //precondition: position of the piece and the board it is on
    //postcondition: returns nothing as it's a void method, changes the pos of the piece
    //Override the method to actually move the piece on the board
    @Override
    public void move(int x, int y, Board b){
        int oldX = getPosX();
        int oldY = getPosY();
        Rook moving = new Rook(oldX,oldY, b.getP(getPosX(), getPosY()).getColor());
        
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
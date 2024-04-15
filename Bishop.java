public class Bishop extends Pieces {

    // Constructors
    
    public Bishop() {
        super();
    }

    //overloaded constructor for a bishop specifying color and position
    public Bishop(int x, int y, int c) {
        super();
        setPosX(x);
        setPosY(y);
        setColor(c);
        setName("BISHOP");
        setFace("BISHOP", c);
    }

    // Methods
    
    //precondition: position of the piece and teh board it is on
    //postcondition: a boolean determining if the movid is valid or not
    //Override the method to determine the movent of a piece
    @Override
    public boolean canMove(int x, int y, Board b) {
        int oldX = getPosX();
        int oldY = getPosY();

        // Bishop can only move diagonally, so the difference in x and y coordinates should be the same
        int deltaX = Math.abs(x - oldX);
        int deltaY = Math.abs(y - oldY);

        // Invalid move if the difference is not the same or if the bishop is trying to stay in the same position
        if (deltaX != deltaY || (deltaX == 0 && deltaY == 0)) {
            return false;
        }

        int stepX = (x > oldX) ? 1 : -1; // Determines the direction of movement in x-axis
        int stepY = (y > oldY) ? 1 : -1; // Determines the direction of movement in y-axis

        int currentX = oldX + stepX;
        int currentY = oldY + stepY;

        // Check if there are any obstacles in the diagonal path
        while (currentX != x && currentY != y) {
            if (b.getP(currentX, currentY).getColor() != 0) {
                return false;
            }
            currentX += stepX;
            currentY += stepY;
        }

        // Valid move
        return true;
    }

    //precondition: position of the piece and the board it is on
    //postcondition: returns nothing as it's a void method, changes the pos of the piece
    //Override the method to actually move the piece on the board
    @Override
    public void move(int x, int y, Board b) {
        int oldX = getPosX();
        int oldY = getPosY();

        Bishop moving = new Bishop(oldX, oldY, b.getP(getPosX(), getPosY()).getColor());

        // Move the piece if the move is valid
        if (canMove(x, y, b)) {
            // Remove piece at the new position
            b.remP(x, y);

            // Update current piece position
            moving.setPosX(x);
            moving.setPosY(y);

            // Remove the old piece
            b.remP(oldX, oldY);

            // Set the new position to the current piece
            b.setP(x, y, moving);
        }
    }
    
    //precondition: none
    //postcondition: Return a string containing the face attribute of the piece
    //toString printing the character of a piece(stored as a string)
    @Override
    public String toString() {
        return getFace();
    }
}
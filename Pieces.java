public abstract class Pieces {
    
    //Data Fields
    private int posX;
    private int posY;
    private String name;
    private String face;
    private int color;
    
    //Empty Constructor
    public Pieces(){
        
    }
    
    //setters
    //precondition: int with the new x position of the piece
    //postcondition: void, changes the paramater of a piece
    //sets the x position of a piece
    public void setPosX(int x){
        posX = x;
    }
    
    //precondition: int with the new y position of the piece
    //postcondition: void, changes the paramater of a piece
    //sets the y position of a piece
    public void setPosY(int y){
        posY = y;
    }
    
    //precondition: String with the new name of the piece
    //postcondition: void, changes the paramater of a piece
    //sets the name of a piece
    public void setName(String c){
        name = c;
    }
    
    //precondition: String with the name of the piece and int with the new color of the piece
    //postcondition: void, changes the face of a piece
    //sets the face of a piece based on its name and color
    public void setFace(String n, int c){
        if(c == 1){
            if(n.equals("KING")){
                face = "♚ ";
            }
            else if(n.equals("QUEEN")){
                face = "♛ ";
            }
            else if(n.equals("BISHOP")){
                face = "♝ ";
            }
            else if(n.equals("KNIGHT")){
                face = "♞ ";
            }
            else if(n.equals("ROOK")){
                face = "♜ ";
            }
            else{
                face = "♟ ";
            }
        }
        else if(c == 2){
            if(n.equals("KING")){
                face = "♔ ";
            }
            else if(n.equals("QUEEN")){
                face = "♕ ";
            }
            else if(n.equals("BISHOP")){
                face = "♗ ";
            }
            else if(n.equals("KNIGHT")){
                face = "♘ ";
            }
           else if(n.equals("ROOK")){
                face = "♖ ";
            }
            else{
                face = "♙ ";
            }
        }    
        else if (c == 0){
            face = "  ";
        }
    }
    
    //precondition: int with the new color of the piece
    //postcondition: void, changes the paramater of a piece
    //sets the color of a piece
    public void setColor(int x){
        color = x;
    }
    
    //getters
    //precondition: none
    //postcondition: returns an int with the position x of the piece
    //gets the x position of a piece
    public int getPosX(){
        return posX;
    }
    
    //precondition: none
    //postcondition: returns an int with the position y of the piece
    //gets the y position of a piece
    public int getPosY(){
        return posY;
    }
    
    //precondition: none
    //postcondition: returns a String with the name of the piece
    //gets the name of a piece
    public String getName(){
        return name;
    }
    
    //precondition: none
    //postcondition: returns a String with the face of the piece
    //gets the face of a piece
    public String getFace(){
        return face;
    }
    
    //precondition: none
    //postcondition: returns an int with the color of the piece
    //gets the color of a piece
    public int getColor(){
        return color;
    }
    
    //precondition: posX and posY of the piece to move and the board it's on
    //postcondition:  booelan containing whether the move was valid or not
    //determines if a move is valid for a piece or not
    public abstract boolean canMove(int x, int y, Board b);
    
    //precondition: posX and posY of the piece to move and the board it's on
    //postcondition: void, (moves the piece on the board)
    //moves a piece on the board
    public abstract void move(int x, int y, Board b);
    
    //precondition: none
    //postcondition: String containing the face of the piece
    //toString method to print the piece
    public abstract String toString();
    
}
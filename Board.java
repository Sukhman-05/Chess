public class Board {
    
    //data fields
    private Pieces[][] board = new Pieces[8][8];
    
    //constructor
    public Board(){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                board[x][y] = new Pawn(5,5,0);
                board[x][y].setColor(0);
                board[x][y].setName(" ");
            }
        }
        //sets the Rooks
        board[0][0] = new Rook(0, 0, 1);
        board[0][7] = new Rook(0, 7, 1);
        
        board[7][0] = new Rook(7, 0, 2);
        board[7][7] = new Rook(7,7, 2);
        
        //sets the Knights
        board[0][1] = new Knight(0,1,1);
        board[0][6] = new Knight(0,6,1);
        
        board[7][1] = new Knight(7,1,2);
        board[7][6] = new Knight(7,6,2);
        
        //sets the bishops
        board[0][2] = new Bishop(0,2,1);
        board[0][5] = new Bishop(0,5,1);
        
        board[7][2] = new Bishop(7,2,2);
        board[7][5] = new Bishop(7,5,2);
        
        //sets the Kings
        board[0][4] = new King(0,4,1);
        board[7][4] = new King(7,4,2);
        
        //sets the queens
        board[0][3] = new Queen(0,3,1);
        board[7][3] = new Queen(7,3,2);
        
        //set white pawns with a for loop
        for(int y = 0; y < 8; y++){
            board[1][y] = new Pawn(1,y,1);
        }
        //set black pawns with a for loop
        for(int y = 0; y < 8; y++){
            board[6][y] = new Pawn(6,y,2);
        }
    }
    
    //precondition: none
    //postcondition: String containing the board
    //toString() for the board
    public String toString(){
        //manually print the top of the board
        String top = " a  b  c  d  e  f  g  h";
        String s = " ";
        
        s += top;
        
        for(int x = 0; x < 8; x++){
            s += "\n" + (x + 1);
            s += "|";
            for(int y = 0; y < 8; y++){
                
                Pieces smthing = board[x][y];
                s += smthing.toString();
                s+="|";
            }
            s +=  (x + 1);
        }
        s+= "\n " + top;
        return s;
    }
    
    //precondition: none
    //postcondition: Pieces[][]
    //method to get a Pieces[][] in the board to acess indexes
    public Pieces[][] getBoard(){
        return board;
    }
    
    //precondition: posX and posY of a piece
    //postcondition: returns a piece at the index of the board
    //get a piece at a specific location on the board
    public Pieces getP(int x, int y){
        return board[x][y];
    }
    
    //precondition: position of a piece and another piece
    //postcondition: void, changes the board t set a piece on a given square
    //change th pos coordinates of a piece
    public void setP(int x, int y, Pieces p){
        board[x][y] = p;
    }
    
    //precondition: the coordinates x and y of the piece to remove
    //postcondition: void, changes teh board to remove a piece
    //removes a pieces form the board
    public void remP(int x, int y){
        //empties the piece so its null
        board[x][y].setColor(0);
        board[x][y].setName(" ");
        //sets face to empty
        board[x][y].setFace(" ", 0);
    }
}
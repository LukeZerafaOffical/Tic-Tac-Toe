public class App {
    public static void main(String[] args) throws Exception {
        
        Board GameBoard = new Board();
        do
        {
            //Print out the board
            GameBoard.PrintBoard();
             //Check Input
            GameBoard.UserInput();
            //AI makes a move
            GameBoard.AIInput();
            
        
        }
        while(!GameBoard.CheckWin() && !GameBoard.IsFull());//Keep playing the game until there are either no more possible moves, or there is a winner
        System.out.println("Game Over");
        GameBoard.PrintWinner();
        //Print out the board so the player can actually see how the winner won.
        GameBoard.PrintBoard();
    }
    
}

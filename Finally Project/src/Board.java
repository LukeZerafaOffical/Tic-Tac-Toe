import java.util.Scanner;

public class Board {
    Tile[][] BoardGrid = new Tile[3][3]; 
    boolean GameOver = false;
    byte winner = -1;
    Board() //Default Constructor
    {
        GameOver = false;
        DefineBoard();
    }
    public void DefineBoard()
    {
        //TODO: We need to go to every element and set it to an empty tile.
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                BoardGrid[y][x] = new Tile();
            }
        }
        
    }
    public void PrintBoard()
    {
        System.out.println(BoardGrid[0][0].ToString()+"."+BoardGrid[0][1].ToString()+"."+BoardGrid[0][2].ToString());
        System.out.println(BoardGrid[1][0].ToString()+"."+BoardGrid[1][1].ToString()+"."+BoardGrid[1][2].ToString());
        System.out.println(BoardGrid[2][0].ToString()+"."+BoardGrid[2][1].ToString()+"."+BoardGrid[2][2].ToString());
    }
    //Asks the user to input 2 values for the row and column. It will check if the user has given a correct input. Firstly, it is in range and the selected tile has been taken.
    public void UserInput()
    {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = true;
        do
        {
            
            validInput = true;
            System.out.print("Enter a row number (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter a column number (0-2): ");
            int col = scanner.nextInt();
            if(row >= 3 || row < 0 || col >= 3 || col < 0)
            {
                System.out.println("Incorrect input, please try again.");
                validInput = false;
            }
            else
            {
                if(BoardGrid[row][col].tileTaken() == true)
                {
                    System.out.println("Tile is already taken. Please select another one.");
                    validInput = false;
                }
                else
                {
                    BoardGrid[row][col].taken = true;
                    BoardGrid[row][col].SetOwner((byte)1); //1, since 1 is defined as player.
                }
            }
        }while(!validInput);
    
    }
    public void AIInput()
    {
        boolean validInput = false;
        //This is to check that AI actually has a playable move
        if(IsFull())
        {
           return; 
        }
        do
        {
            validInput = true;
            int row = (int)(Math.random() *3); //Math.random generates a random number from 1 to 0. 
            int col = (int)(Math.random() *3);
            //The range is always correct, but we still need check if the tile taken.
            if(BoardGrid[row][col].tileTaken() == true)
            {
                validInput = false;
            }
            else
            {
                BoardGrid[row][col].taken = true;
                BoardGrid[row][col].SetOwner((byte)2); //2, since 2 is defined as AI.
            }
        }while(!validInput);
    }
    //This method has to check 3 rows, 3 columns and 2 diagonals
    public boolean CheckWin()
    {
        boolean foundWin = false;
        //We use a for loop cause we know how many times we need to iterate
        for(int i = 0; i < 3 ; i++)
        {   
            //This Checks for a match in a row
            if(BoardGrid[i][0].GetOwner() == BoardGrid[i][1].GetOwner() && BoardGrid[i][1].GetOwner() == BoardGrid[i][2].GetOwner() && BoardGrid[i][0].tileTaken())
            {
                //This Checks for a match in a row
                winner = BoardGrid[i][0].GetOwner();
                foundWin = true;
                break;
            }
            //This Checks for a match in a column
            if(BoardGrid[0][i].GetOwner() == BoardGrid[1][i].GetOwner() && BoardGrid[1][i].GetOwner() == BoardGrid[2][i].GetOwner() && BoardGrid[0][i].tileTaken())
            {
                
                winner = BoardGrid[0][i].GetOwner();
                foundWin = true;
                break;
            }
        }
        //Checks for both diagonals.
        if(BoardGrid[0][0].GetOwner() == BoardGrid[1][1].GetOwner() && BoardGrid[1][1].GetOwner() == BoardGrid[2][2].GetOwner() && BoardGrid[0][0].tileTaken())
        {
            winner = BoardGrid[0][0].GetOwner();
            foundWin = true;
        }
        else if(BoardGrid[0][2].GetOwner() == BoardGrid[1][1].GetOwner() && BoardGrid[1][1].GetOwner() == BoardGrid[2][0].GetOwner() && BoardGrid[0][2].tileTaken())
        {
            winner = BoardGrid[0][2].GetOwner();
            foundWin = true;
        }
        return foundWin;
    }
    public void PrintWinner() {
        if(winner == 1)
        {
            System.out.println("Player WINS!!!");
        }
        else if(winner == 2)
        {
            System.out.println("Bot WINS!!!");
        }
        else
        {
            System.out.println("Tie");
        }
    }
    //Go through the array until you find an empty tile.
    public boolean IsFull() {
        boolean full =true;
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(!BoardGrid[y][x].tileTaken())
                {
                    full = false;
                    break;
                }
            }
        }
        return full;
    }
}



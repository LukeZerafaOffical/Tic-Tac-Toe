public class Tile {
    boolean taken;//This tells us if the tile is empty
    byte owner;//This stores information who owns the tile
    Tile() //Default Constructor
    {
        taken = false;
        owner = -1;//-1 is an invalid value
    }
    Tile(byte newOwner) //Other Constructor
    {
        taken = true;//You can not own a tile that you haven't taken
        owner = newOwner;
    }
    void SetOwner(byte nOwner)
    {
        owner = nOwner;
    }
    byte GetOwner()
    {
        return owner;
    }
    boolean tileTaken()
    {
        return taken;
    }
    String ToString()
    {
        if(taken == true)
        {
            //If owner = 1, then that is the player, else it is the AI
            if(owner == 1)
            {
                return "X";
            }
            else
            {
                return "O";
            }
        }
        else
        {
            return "?";
        }
        
    }
}

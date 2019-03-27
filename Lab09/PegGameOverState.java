
public class PegGameOverState implements PegState
{
   private Pegs pegs;

   public PegGameOverState(Pegs pegs)
   {
      this.pegs = pegs;
   }

   public void mouseClicked(int x, int y)
   {
	  //find which slot was clicked on 
      int select =  pegs.findSelectedSlot(x,y);
      if (select == -1)
      {
		  //find which peg was clicked on
         select = pegs.findSelectedSlot(x,y);
      }

      if (select > -1)
      {
       //reset the game to the first click state
	   //start the game, get the first click state, and then make it your current state
	 pegs.startGame(pegs.findSelectedSlot(x,y));

	 
      }
   }
}

import java.awt.Graphics;
import java.util.ArrayList;

public class Pegs
{
   private ArrayList<Peg> pegs;
   private Jumps jumps;

   //DO THIS (four instance variables needed for the state design pattern, including the current state)
   //should be private

//STATES 
   private PegState pegFirstClick;
   private PegState pegSecondClick;
   private PegState pegGameOver;
   private PegState current;   



   private PegGameAI pgai = PegGameAI.getPegGameAI();
   private int turn;
 
   //DO THIS
   public Pegs(int open_loc)  
   {
      //instantiate the states
      this.pegFirstClick = new PegFirstClickState(this);
      this.pegSecondClick = new PegSecondClickState(this);
      this.pegGameOver = new PegGameOverState(this);
      
      startGame(open_loc);
      jumps = new Jumps(this);
   }

   //DO THIS (short methods required in the state design pattern, five all together including mouseClicked)
   //Three get methods (for each of the three states) and one set method (for current state)
   public void setPegState(PegState state){
		this.current = state;
	}
   public PegState getPegFirstClick() {
		return pegFirstClick;
	}
   public PegState getPegSecondClick() {
		return pegSecondClick;
	}
   public PegState getPegGameOver() {
		return pegGameOver;
	}











   public void mouseClicked(int x, int y)
   {
	current.mouseClicked(x, y);

   }


   public void startGame(int open_loc)
   {
      pegs = new ArrayList<Peg>();

      for (int i = 1; i <= 15; i++)
      {
         Peg peg = new Peg(i);
         pegs.add(peg);
      }

      Peg open_peg = getPeg(open_loc);
      open_peg.setLocation(-1);

      current = getPegFirstClick();    //set the current state to your first click state//attention
      turn = 1;
   }

   
   //no work below this point (but you will need to call some of these methods!!!)
   public ArrayList<Jump> getPossibleJumps(int select)
   {
      ArrayList<Jump> possible_jumps = jumps.getJumps(select);
      return possible_jumps;
   }

   public Jump getJump(int start, int end)
   {
      Jump jump = jumps.getJumps(start, end);
      return jump;
   }

   public int findSelectedPeg(int x, int y)
   {
      int select = -1;
      for (Peg peg : pegs)
      {
         if (peg.isPegClicked(x, y))
         {
            select = peg.getLocation();
            break;
         }
      }
      return select;
   }

   public int findSelectedSlot(int x, int y)
   {
      if (findSelectedPeg(x, y) > -1) return -1;  //make sure there is no peg at this spot

      int select = -1;
      int count = 1;
      for (Peg peg : pegs)
      {
         if (peg.isSlotClicked(x, y))
         {
            select = count;
            break;
         }
         count++;
      }
      return select;
   }

   public void incrementTurn()
   {
      turn++;
   }

   public boolean gameOver()
   {
      ArrayList<Jump> validJumps = jumps.getValidJumps();
      int num_jumps = validJumps.size();
      if (num_jumps == 0)
      {
         return true;
      }
      return false;
   }

   //find the Peg at specific locations on the board
   public Peg getPeg(int peg_loc)
   {
      for (Peg peg : pegs)
      {
         int loc = peg.getLocation();
         if (loc == peg_loc) return peg;
      }

      return null;
   }

   public void setImages()
   {
      for (Peg peg : pegs)
      {
         peg.setImage(0); //reset all pegs to the red image
      }

      ArrayList<Jump> validJumps = jumps.getValidJumps();
      for (Jump jump : validJumps)
      {
         int start = jump.getStart();
         Peg peg = getPeg(start);
         peg.setImage(1);  //pegs that can jump another peg are magneta
      }

      if (turn > 1)
      {
         int loc = pgai.getBestMove(pegs);
         Peg peg = getPeg(loc);
         if (peg != null)
         {
            peg.setImage(2);
         }
      }
   }

   public void draw(Graphics g)
   {
      setImages();

      for (Peg peg : pegs)
      {
         peg.draw(g);
      }
   }
}


public class Craps
{

   public static int playCraps(int num_rolls)
   {
     	double percentageOfDesiredRoll;
	int desiredRoll = 0;
	int roll ; 
	CrapsDice dice = new CrapsDice();
	 for (int i =0;i<num_rolls;i++)
	{	
		roll = dice.roll();
		if (roll == 2 ||roll ==3 || roll == 12)
		{
			desiredRoll++;		
		}
	}
	 
	 return desiredRoll;
	 
	 
	 }

   public static void main(String[] args)
   {
	
	int percentageOfDesiredRoll;
	int numRolls = playCraps(752);
	percentageOfDesiredRoll = (int)(100*((double)(numRolls))/752);
	System.out.println(percentageOfDesiredRoll+"%");
      //System.out.println("Hello David ;)");
	  
	  
	  
	  
	  
	  
	  
   }

}

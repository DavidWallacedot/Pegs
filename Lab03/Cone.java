public class Cone
{
	private int cone; 
	public Cone(int cone)
	{
		this.cone = cone;
		if(this.cone >3 || this.cone < 1){this.cone = 1;}
	}
	public double getPriceOfCone ()
	{
		if(this.cone == 1)
		{return 0.59;}
		
		if(this.cone == 2)
		{return 0.79;}

		if(this.cone == 3)
		{return 0.00;}	
		return 0;
	}

	public String toString()
	{
		if(this.cone == 1)
		{return "Cone: sugar cone.\r\n";}
		
		if(this.cone == 2)
		{return "Cone: waffle cone.\r\n";}

		if(this.cone == 3)
		{return "Cone: cup\r\n";}	
		return "Cone: sugar cone.\r\n";
	}


}

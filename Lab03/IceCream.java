public class IceCream
{
	private int numScoops;	
	private Flavor flavor ; 
	private Topping topping;
	private boolean belongs = false;

	public IceCream(int numScoops,Flavor flavor, Topping topping)
	{
		if(numScoops >3 || numScoops < 1){numScoops = 1;}
		this.numScoops = numScoops;
		for (Flavor f : Flavor.values())
		{
		
			if( flavor == f) 
			{belongs = true;}	
			
		}
		if (belongs == true)
		{		
		this.flavor = flavor;
		}
		else {this.flavor = Flavor.vanilla;}
		belongs = false; 
		for (Topping t : Topping.values())
		{
		
			if( topping == t) 
			{belongs = true;}	
			
		}
		if (belongs == true)
		{		
		this.topping = topping;
		}
		else {this.topping = Topping.no_topping;}
		
		
		
		
				
	}


	public double getPriceOfIceCream ()
	{
		double totalCost = 0.00;
		totalCost += topping.price();
		if(numScoops > 1 )
		{
			totalCost += numScoops * 0.75;
			totalCost -= 0.75;//adjust for 1st scoop which is included in original price
		}
			
		
		return totalCost; 
	
	}

	public String toString()
	{

		return "Flavor: "+flavor+"\r\nNumber of scoops: "+numScoops+"\r\nTopping: " +topping;	
		
	}
		
}

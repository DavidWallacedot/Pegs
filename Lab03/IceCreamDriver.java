public class IceCreamDriver{
	
	/*private static Keyboard kb = Keyboard.getKeyboard();
	private boolean orderACone = true;
	private double priceRunningTotal = 0.00;	
	private int numOrders = 0;	

	int intBuffer;
	double doubleBuffer;
	String stringBuffer;	
	String listBuffer;	
	
	private Flavor flavor;
	private Topping topping;
	private int numScoops;

	private Cone cone; 

	String iceCreamConePrompt = "Would you like to order an ice cream cone? (y/n)  ";
	
	*/
	
	public static void main(String [] args)
	{
	 Keyboard kb = Keyboard.getKeyboard();
	 boolean orderACone = true;
	 double priceRunningTotal = 0.00;
	 String displayPrice;	
	 int numOrders = 0;	

	
	
	String stringBuffer;	
		
	
	 Flavor flavor;
	 Topping topping;
	 int numScoops;

	 Cone cone; 

	String iceCreamConePrompt = "Would you like to order an ice cream cone? (y/n)  ";
	
	

		while (orderACone)
		{
			
			stringBuffer = kb.readString(iceCreamConePrompt);
			while(stringBuffer.equals("y") == false && stringBuffer.equals("n")  == false)
			{
			stringBuffer = kb.readString("Please enter : 'y' or 'n' ");
			}
			if(stringBuffer.equals("n"))
			{	
				displayPrice = Currency.formatCurrency(priceRunningTotal);
				System.out.println("Your total order for "+numOrders+" orders  of ice cream is "+displayPrice);
				orderACone = false;
			} 
			else
			{
				flavor = getFlavorChoice();
				topping = getToppingChoice();
				numScoops = getScoopsChoice();
				IceCream iceCream = new IceCream(numScoops, flavor, topping);
				cone = getConeChoice();
				IceCreamCone iceCreamCone = new IceCreamCone(cone, iceCream);
				System.out.println(iceCreamCone);
				System.out.print("Price:   ");
				System.out.println(iceCreamCone.getPrice());
				priceRunningTotal += iceCreamCone.accumulatePrice();
				numOrders++;
			}
		}

	}

	public static Flavor getFlavorChoice()
	{
		Keyboard kb = Keyboard.getKeyboard();
		int intBuffer;
		String listBuffer;
		Flavors f = Flavors.getFlavors();
		String flavorPrompt = "Enter your desired flavor:  ";
		
		listBuffer = f.listFlavors();	
		System.out.println(listBuffer);
		intBuffer = kb.readInt(flavorPrompt);
		while(intBuffer >18 || intBuffer < 1)
		{	
			System.out.println("Please enter a valid #: 1-18");
			intBuffer = kb.readInt(flavorPrompt);
		}
		return f.getFlavor(intBuffer);
		
	}

	public static Topping getToppingChoice()
	{	
		Keyboard kb = Keyboard.getKeyboard();
		int intBuffer;
		String listBuffer;
		Toppings t = Toppings.getToppings();
						
		String toppingPrompt = "Enter your desired topping:  ";
		listBuffer = t.listToppings();
		System.out.print(listBuffer);
		intBuffer = kb.readInt(toppingPrompt);
		while(intBuffer > 5 || intBuffer < 1)
		{
			System.out.println("Please enter a valid #: 1-5");			
			intBuffer = kb.readInt(toppingPrompt);
		}
		return t.getTopping(intBuffer);
	}
	
	public static int getScoopsChoice()
	{
		Keyboard kb = Keyboard.getKeyboard();		
		int intBuffer;
		String listBuffer;
		
		String numScoopsPrompt = "How many scoops (1, 2, or 3 ) would you like? ";
		intBuffer = kb.readInt(numScoopsPrompt);
		while (intBuffer >3 || intBuffer<1)
		{
			System.out.println("Please enter a valid #: 1-3");
			intBuffer = kb.readInt(numScoopsPrompt);
		}
		return intBuffer;
	}
	
	public static Cone getConeChoice()
	{
		Keyboard kb = Keyboard.getKeyboard();		
		int intBuffer;
		String listBuffer;
				
		String conePrompt = "Would you like a 1: sugar cone , 2: waffle cone , or 3: cup?  ";
		intBuffer = kb.readInt(conePrompt);
		while(intBuffer>3 ||intBuffer<1)
		{
			System.out.println("Please enter a valid # : 1-3");
			intBuffer = kb.readInt(conePrompt);
		}
		Cone tempCone = new Cone(intBuffer);
		return tempCone ;
	}

}

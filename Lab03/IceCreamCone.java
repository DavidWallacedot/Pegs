public class IceCreamCone
{
	private IceCream iceCream;
	private Cone cone;
	private double price = 1.99;
	private String displayPrice;
	public IceCreamCone(Cone c,IceCream i )
	{
		if (c != null){cone = c;}
		if (i != null){iceCream = i;}

	}
	public String getPrice()
	{
		price += cone.getPriceOfCone();
		price += iceCream.getPriceOfIceCream();
		displayPrice = Currency.formatCurrency(price);
		return displayPrice;
	}
	public double accumulatePrice(){return price;}//returns price as a double for the summation of costs of all ice cream cone orders
	public String toString()
	{
		return "Your order:\r\n"+cone.toString()+""+iceCream.toString();

	}

}

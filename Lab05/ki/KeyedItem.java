package ki;

public abstract class KeyedItem
{
	//create single instance variable of type Comparable
	private Comparable key;
  
   public KeyedItem(Comparable key) 
   {
	   this.key = key;
	   
   }  

   public Comparable getKey() 
   {
	   return this.key;
	   
   }  

	//Use Comparable toString() method
   public String toString()
   {
	return key.toString();   
	   
   }
}

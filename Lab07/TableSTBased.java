import java.util.Iterator;

public class TableSTBased implements TableInterface 
{
   private SearchTreeInterface st;  // binary search tree that contains the table’s items
   private int size;                // number of items in the table

   public TableSTBased() 
   {  
      st = new AdaptableBinarySearchTree();  //duplicates not allowed with this constructor
      size = 0;
   } 
  
   public boolean tableIsEmpty() 
   {
   	if (size == 0){return true;}
	else {return false;}  
   }  
   
   public int tableSize() 
   {
      return size;
   }  

   public KeyedItem tableRetrieve(Comparable searchKey) 
   {
    	return st.retrieve(searchKey); 
   } 
  
   public void tableInsert(KeyedItem item) throws TableException 
   { 
      
	  st.insert(item);
	  
	  
	  
	  
	  
	  
   } 

   public boolean tableDelete(Comparable searchKey) 
   {
      
	  st.delete(searchKey);
	  return true;
	  
	  
   } 

   public Iterator iterator()
   {
      TreeIterator iter = st.iterator();
      //do your specific iterator traversal call here
      //do your specific iterator traversal call here
      //do set level order 
      iter.setLevelorder();
      //set inorder temp optional
      return iter;
	  
   }
} 

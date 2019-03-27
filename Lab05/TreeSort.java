import java.util.Iterator;
import bst.*;
import ki.KeyedItem;

public class TreeSort
{
   //convenience method
   public static KeyedItem[] treeSort(KeyedItem[] sort)
   {
     KeyedItem[] temp = treeSort(sort, sort.length);
	  return temp;
   }

   public static KeyedItem[] treeSort(KeyedItem[] sort, int n)
   {
      //easier to use a KeyedItem array than Comparable
      //KeyedItem [] sorted = sort;
	  
	  
	  
	  //create a new Binary Search Tree
	BinarySearchTree bst = new BinarySearchTree(true,true);
      //a balanced tree ensures logn inserts for nlogn sort

	  
	  
	  
	  
      //need to use the Class class as the actual array type may be a subtype of KeyedItem
      
	  
      Class cls = sort.getClass().getComponentType();
      KeyedItem[] temp = (KeyedItem[])java.lang.reflect.Array.newInstance(cls,n);
        temp = sort ;
 
      // fill up the search tree
      
	for(int i =0; i< n; i++){bst.insert(temp[i]);}
	  
      //pull sorted stuff out of the tree
	int i = 0;
	TreeIterator tfi = bst.iterator();
	tfi.setInorder();      
	while(tfi.hasNext())
	{
		temp[i] = (KeyedItem)tfi.next();
		i++;
	}
	  
	  
	  
return temp;	  
   }
}

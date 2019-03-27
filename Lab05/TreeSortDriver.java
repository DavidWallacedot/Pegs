import java.util.ArrayList;
import java.util.Scanner;
public class TreeSortDriver
{

   private static CD[] readMusic(String fileName)
   {
      //DO THIS complete this method using the FileIO class
      FileIO file = new FileIO(fileName,FileIO.FOR_READING);
      String str = file.readLine();
      ArrayList<CD> cds = new ArrayList<CD>();

      while (!file.EOF()              )
      {
         String title = file.readLine();
         int year = Integer.parseInt(  file.readLine()          );
         int rating = Integer.parseInt(file.readLine()          );
         int numTracks = Integer.parseInt(file.readLine()         );
         CD cd = new CD(title, str, year, rating, numTracks);

         cds.add(cd);
         int tracks = 1;

         while (tracks <= numTracks)
         {
            String track_str = file.readLine();
            String[] pieces = track_str.split(",");    //divide the string up into two pieces
            String len = pieces[0];
            String songTitle = pieces[1];
            cd.addSong(songTitle, len);
            tracks++;
         }

         str = file.readLine();
      }


      //create a CD[] of the correct size, populate it using a for-each statement
      CD[] cds_array = new CD[cds.size()];
	int i =0;
	for(CD cd : cds){cds_array[i++] = cd;}




      return cds_array;
   }
   
   public static void main (String[] args)
   {
      //use the Keyboard class, try-catch, and a while loop to continue calling readMusic 
      //until a valid file name is entered
      //as checked exceptions have been converted to unchecked exceptions, 
      //you must remember to do this with end user input, the compiler will not help you
	String fileName="";	
	boolean validFileName = false;	
	Scanner keyboard = new Scanner(System.in);
	while(validFileName != true){	
	try{
	fileName = keyboard.nextLine();
	FileIO file = new FileIO(fileName,FileIO.FOR_READING);
	validFileName = true; 
	}
	catch(Exception e){System.out.println("This is not a valid fileName please enter a valid fileName");}

	}

	CD [] cds = readMusic(fileName); 
	
	cds = (CD[])TreeSort.treeSort(cds);
	for(CD cd: cds){System.out.println(cd);}
      //once you have the array of CDs back from readMusic, sort them
      //and print them out to make sure that they are sorted




   }
}

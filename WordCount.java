import java.util.*;
import java.io.*;

public class WordCount {
  /*function to sort a hashmap by its values*/
  public static HashMap<String, Integer> sortValue(HashMap<String, Integer> map){
    /*create a list from the elements of the hashmap*/
    List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(map.entrySet());

    /*sort the list*/
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
        return(o2.getValue()).compareTo(o1.getValue());
      }
    });

    /*put data from the sorted list into a linked hashmap*/
    HashMap<String, Integer> linkedmap = new LinkedHashMap<String, Integer>();
    for(Map.Entry<String, Integer> sorted: list){
      linkedmap.put(sorted.getKey(), sorted.getValue());
    }
    return linkedmap;
  }

  public static void main(String[] args) throws FileNotFoundException {
    /* Asked to input the file containing the words you want to have counted, then your entered file is opened. If the file you enter doesn't exist a file not found exception is thrown*/
    Scanner file = new Scanner(System.in);
    System.out.print("What is the name of your file? (input.txt) ");
    String fileName = file.nextLine();
    Scanner input = new Scanner(new File(fileName));

   /*Create a hashmap to store values*/
    HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

/*Used a while loop, so while there's words on the input file, if the word doesn't exist in the hashmap; it's created as a key with a value of 1. If the word was already added as a key, it's value is iterated by one. There is also a delimiter to replace punctuation with a space*/
    while (input.hasNext()){
      String readin = input.next();
      String next = readin.replaceAll("\\p{Punct}", "").toLowerCase();
      if(!wordCount.containsKey(next)){
        wordCount.put(next, 1);
      } else {
        wordCount.put(next, wordCount.get(next) + 1);
      }
    }
    
    /*called the sortValue function and created a new sorted hashmap version of the existed wordCount hashmap*/
    Map<String, Integer> sortedWordCount = sortValue(wordCount);

    /*Total word count is displayed along with word frequencies*/

    /* Creating a print stream "writer" that lets us write into the output file named "output.txt" */ 
        PrintStream writer = new PrintStream("output.txt"); 
  
        /*Store current System.out before assigning a new value*/  
        PrintStream console = System.out; 
  
        /*Assign writer to output stream, so any output is now going to be in the output file*/  
        System.setOut(writer); 
        System.out.println("Assignment 3 \t Sahal Asghar \t EMPL: 23721775"); 
    
    System.out.println("Total words are " + wordCount.size());
    for (Map.Entry<String, Integer> hm : sortedWordCount.entrySet()){
      System.out.println(hm.getValue() + " : " + hm.getKey());     
    }    

    /*change output stream back to console*/ 
        System.setOut(console); 
        System.out.println("The word frequency list for your file should now be in the output file output.txt. Please check there.");  
  
  }
}
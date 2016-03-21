import java.util.*;
import java.io.File;
import java.lang.Exception;
/**
 * Write a description of class WordCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordCount
{

    /**
     * Default constructor for objects of class WordCount
     */
    public static void main(String[] args)
        {
      
        try{
         File inputFile= new File("input.txt");
        Scanner in= new Scanner(inputFile);
        int i=0;
            
         while(in.hasNext()){
            in.next();
             i++;
            }
            System.out.println(i);
            in.close();
      }
       catch(Exception FileNotFoundException){
           return;
        }
        
     
        
    }
    }





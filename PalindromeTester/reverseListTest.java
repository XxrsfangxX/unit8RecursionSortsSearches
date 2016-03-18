

import java.util.ArrayList;
/**
 * Write a description of class reverseListTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class reverseListTest
{
     public static void main(String[] args)
   {
      ArrayList<Integer> tempList = ListMethods.makeList(100);
      if (tempList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : ListMethods.reverseList(tempList))
         {
            System.out.println(i);
         }
      }
   }

}

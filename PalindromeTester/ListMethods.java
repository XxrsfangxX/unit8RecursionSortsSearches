import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = new ArrayList<Integer>() ;
        if (n <= 0)  // The smallest list we can make
        {

            return tempList;


        }
        else        // All other size lists are created here
        {
            tempList.add(0,n);
            tempList.addAll(makeList(n-1));


        }
        return tempList;
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> list) {

        ArrayList<Integer> subList= new ArrayList<Integer>();
        ArrayList<Integer> list2= ListMethods.deepClone(list);
        if( list.size()==subList.size()){

            return subList;
        }
        else{

            subList.add(0,list2.get(list2.size()-1)); 
            list2.remove(list2.size()-1);
            subList.addAll(reverseList(list2));

           
        }

        return subList;
    }

    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }

}
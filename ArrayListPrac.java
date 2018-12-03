/*
 *  This class is mean to practise data manipulation of ArrayList
 *
 *  ArrayList has high performance for random access
 *  Other than that, it is pretty slow
 */

import java.util.*;
import java.util.regex.*;

public class ArrayListPrac{

  public static void main(String[] args){

    // 1.declare an ArrayList
    ArrayList<String> arrListStr;

    // 2. intialize it with some data
    arrListStr = new ArrayList<String>();
    arrListStr.add("No.1 Oliver");
    arrListStr.add("No.2 Kimiko");
    arrListStr.add("No.3 Mashroom");
    arrListStr.add("No.4 Mario");

    // 4. check the length of it
    System.out.println("===========");
    int size = arrListStr.size();
    System.out.println("arrListSize: " + size);

    // 5. create another arrListStrB for backup
    ArrayList<String> arrListStrB;
    arrListStrB = new ArrayList<String>(arrListStr);

    // 6. go through all elements of arrListStr
    System.out.println("===========");
    for (String element:arrListStr){
      System.out.println(element);
    }



    // 7. identify if Oliver exists in arrListStr
    // if so, get his id, else return no such person
    System.out.println("===========");
    String targetPerson = "Oliver";
    String targetId = "to be confirmed";
    String pattern = "(No.\\d+)(\\s\\D+)";
    Pattern ptn = Pattern.compile(pattern);
    boolean hasOliver = false;
    Matcher mtr;
    for (String element:arrListStr){
      mtr = ptn.matcher(element);
      if (mtr.find()){
        if (mtr.group(2).trim().equals(targetPerson)){
          hasOliver = true;
          targetId = mtr.group(1);
        }
      }
    }
    System.out.println(hasOliver?"Found! "+targetPerson+" is "
    + targetId:"Oops, no such person");

    // 8. Remove Kimiko if exists
    System.out.println("===========");
    if (arrListStr.contains("No.2 Kimiko")){
      System.out.println("Found, removing");
      arrListStr.remove("No.2 Kimiko");
      for (String element:arrListStr){
        System.out.println(element);
      }
      System.out.println("new list size is: "+ arrListStr.size());
    }else{
      System.out.println("No Kimiko here");
    }

    //9. convert arrListStr into an array
    System.out.println("===========");
    String[] arr =(String[])arrListStr.toArray(new String[0]);
    System.out.println(Arrays.toString(arr));

  }
}

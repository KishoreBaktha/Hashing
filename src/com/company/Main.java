package com.company;
import java.util.*;
public class Main {
 static List<String> list=new ArrayList<String>();
    public static void main(String[] args) {
	// write your code here
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        Map<Integer,String> map=new HashMap<Integer,String>();
        for(int i=0;i<n;i++)
        {
            String[] carray=scanner.nextLine().split(" ");
            if(carray[0].equals("add"))
            {

                map.put(Integer.parseInt(carray[1]),carray[2]);
            }
            else if(carray[0].equals("find"))
            {
                        if (map.containsKey(Integer.parseInt(carray[1])))
                        list.add(map.get(Integer.parseInt(carray[1])));
                        else
                        list.add("not found");

            }
            else
            {
                map.remove(Integer.parseInt(carray[1]));
            }
        }
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}

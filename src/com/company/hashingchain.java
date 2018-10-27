package com.company;
import java.util.*;
public class hashingchain {
    static  int n;
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
         n=scanner.nextInt();
        int m=scanner.nextInt();
        ArrayList<String>[] lists = new ArrayList[n];
        //List<List<String>> lists = new ArrayList<List<String>>(n);
        scanner.nextLine();
        for(int i=0;i<n;i++)
           lists[i]=new ArrayList<String>();
        for(int i=0;i<m;i++)
        {
            String[] carray=scanner.nextLine().split(" ");
            if(carray[0].equals("add"))
            {
                int hashvalue=(int)computehash(carray[1]);
                lists[hashvalue].add(carray[1]);
            }
            else if(carray[0].equals("check"))
            {
               // int hashvalue=(int)computehash(carray[1]);
                if(lists[Integer.parseInt(carray[1])].isEmpty())
                    System.out.println(" ");
                else
                {
                    for(int j=lists[Integer.parseInt(carray[1])].size()-1;j>=0;j--)
                      System.out.println(lists[Integer.parseInt(carray[1])].get(j)+" ");
                }
            }
             else if(carray[0].equals("del"))
            {
                int hashvalue=(int)computehash(carray[1]);
                lists[hashvalue].remove(carray[1]);
            }
            else
            {
                 int hashvalue=(int)computehash(carray[1]);
                if(lists[hashvalue].isEmpty())
                    System.out.println("no");
                else
                {
                    int j;
                    for(j=lists[hashvalue].size()-1;j>=0;j--)
                    {
                        if(lists[hashvalue].get(j).equals(carray[1]));
                        break;
                    }
                    if(j==-1)
                        System.out.println("no");
                    else
                        System.out.println("yes");
                }
            }
        }
    }

    private static long computehash(String s) {
        long sum=0;
      for(int i=0;i<s.length();i++)
      {
          sum+=s.charAt(i)*(long)Math.pow(263,i);
      }
      long mod=((sum%1000000007)+1000000007)%1000000007;
      return ((mod%n)+n)%n;
    }
}

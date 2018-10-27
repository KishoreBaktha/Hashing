package com.company;
import java.util.*;
public class substring {
    static String str,p;
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        str= scanner.nextLine();
        p=scanner.nextLine();
        List<Integer> positions=new ArrayList<Integer>();
        long phash=computehash(p);
        long [] H=precomputehash();
        for(int i=0;i<=str.length()-p.length();i++)
        {
            String substr=str.substring(i,i+p.length());
           // long thash=computehash(substr);
           // if(phash!=thash)
              //  continue;
           // if(substr.equals(p))
              //  positions.add(i);
            if(phash!=H[i])
                continue;
            if(substr.equals(p))
                positions.add(i);
        }
        for(int i=0;i<positions.size();i++)
            System.out.println(positions.get(i));
    }
    private static long computehash(String s) {
        long sum=0;
        for(int i=0;i<s.length();i++)
        {
            sum+=s.charAt(i)*(long)Math.pow(29,i);
        }
        long mod=((sum%1000000007)+1000000007)%1000000007;
        return mod;
    }
    private static long[] precomputehash()
    {
        long[] H=new long[str.length()+p.length()-1];
        String s=str.substring(str.length()-p.length(),str.length());
        H[str.length()-p.length()]=computehash(s);
        int y=1;
        for(int i=1;i<=p.length();i++)
        {
            y=(y*29);
        }
        for(int i=str.length()-p.length()-1;i>=0;i--)
        {
            H[i]=(((29*H[i+1]+str.charAt(i)-y*str.charAt(i+p.length()))%1000000007)+1000000007)%1000000007;
        }
        return H;
    }
}

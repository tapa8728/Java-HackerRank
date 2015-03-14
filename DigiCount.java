/*
You are given an integer N. Find the digits in this number that exactly divide N (division that leaves 0 as remainder) and display their count. For N=24, there are 2 digits (2 & 4). Both of these digits exactly divide 24. So our answer is 2. */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DigiCount {

    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        //System.out.println("Testcases - "+testcases);
        int test[] = new int[testcases];
        for( int i=0; i<testcases; i++)
            {
                test[i] = sc.nextInt();
            }
               
         for( int i=0; i<testcases; i++)
            {
                int orig = test[i];
                int count=0;
                //int flag=0;
                do
                {
                        int rem = orig%10;
                        orig = orig/10;
                    try{
                        if(test[i]%rem==0)  //the digit divides the nnumber
                        {
                            count++;
                        }
                     }
                    catch(Exception e)
                    { }
                }while(orig > 0);
                 System.out.println(count);
            }
        
        
    }
}

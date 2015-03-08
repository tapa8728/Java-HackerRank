/*
Given MXN Magic Box with 'P' and 'T' randomly distributed. If all 'P' or all 'T's make one wish, try to flip entire columns to maximize number of wishes
*/


import java.util.*;

public class Test {
    public static void main(String args[] ) throws Exception 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner kbd = new Scanner(System.in);
        int M=2, N=3;
        System.out.println(M + " " + N);
        char MagicBox[][] = new char[M][N];   //box will be a 2D array
        Random r = new Random();
        //Randomly generate the box based on value of M and N such that each element is 'P' or 'T'
        for(int i=0; i<M; i++)  //rows
            {
                for(int j=0; j<N; j++)  //columns
                    {
                        int k = r.nextInt(2); //0 or 1
                        if(k==1)    
                            k = 80; //P
                        else  
                        {
                            k = 84;    //T
                        }
                        MagicBox[i][j] = (char)k;
                    }
        }
        //print the box
        for(int i=0; i<M; i++)  //rows
            {
                for(int j=0; j<N; j++)  //columns
                    {
                        System.out.print(MagicBox[i][j] + " ");
                    }
            System.out.println("");
        }
        
         //flipping logic for the box
        //wishes - original wishes, without flipping anything
        //wishCheck - after flipping
        int np=0, nt=0, wishes=0, wishCheck=0, flipCount=0; //number of P's and T's
    
        for(int i=0; i<M; i++)  //rows
            {
                np=0; nt=0; //reset values
                for(int j=0; j<N; j++)  //columns
                    {
                       char c= MagicBox[i][j];
                       if(c == 'P' )
                           np++;
                       else
                           nt++;
                       if(np == N || nt == N)
                           wishes++;
                    }
                System.out.println("In row "+(i+1)+" there will be #P-"+np+" #T-"+nt);
            }
        System.out.println("You have currently "+wishes+" wishes"); //original wishes
        
        wishCheck = wishes;
        if(wishes<=M || wishes==0)    //you have number of wishes lesser than rows or 0
        {   
            //need to flip
            System.out.println("Since you have lesser wishes .... ");
            for(int i=0; i<M; i++)  //rows
            {
                while(wishCheck >= wishes && flipCount < M )
                {
                    flipCount++;
                    for(int j=0; j<N; j++)  //columns
                        {
                           char c= MagicBox[i][j];
                           if(c == 'P' )
                               np++;
                           else
                               nt++;
                           //find the #P and #T in a row                        
                        }
                    if(nt>np)
                    {
                        //flip the entire column where we have 'P'
                        //traverse the jth row again
                        for(int j=0; j<N; j++)
                        {
                            if(MagicBox[i][j] == 'P')
                            {
                                //flip the whole col with P
                                for(int k=0; k<M; k++)
                                    MagicBox[k][j] = 'T';
                            }
                        }
                    }
                    else if(np>nt)
                    {
                        //flip the entire column where we have 'T'
                        //traverse the jth row again
                        for(int j=0; j<N; j++)
                        {
                            if(MagicBox[i][j] == 'T')
                            {
                                //flip the whole col with P
                                for(int k=0; k<M; k++)
                                    MagicBox[k][j] = 'P';
                            }
                        }
                    }
                    //check the number of wishes again after flipping once
                    wishCheck=0;
                    for(int m=0; m<M; m++)  //rows
                    {
                        np=0; nt=0; //reset values
                        for(int n=0; n<N; n++)  //columns
                            {
                               char c= MagicBox[m][n];
                               if(c == 'P' )
                                   np++;
                               else
                                   nt++;
                               if(np == N || nt == N)
                                   wishCheck++;
                            }
                    }
                    System.out.println("You have currently "+wishCheck+" wishes");
               }//end of while
             } //end of for - rows
        } //end of if to check for wish number
    }   //end of main
} //end of class

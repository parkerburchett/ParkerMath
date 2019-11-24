//Approx to an arbritary degree the area under a quadratic curve.

import java.math.*;
import java.util.*;
import java.text.*;
// This works within a small margin of error because the number of rectangles is always approaching the right answer
// there are some issues with figuring out the proper amount of rectangles. 
// In particular when the ratio of left to right hand sides are not cleanly devisiable. 

public class AreaUnderQuadratic {

   public static void main(String[] args)
   {
      int choice = 0;
      do
      {
         Scanner kb = new Scanner(System.in);
         System.out.println("Program to approximate the area under the f(x) = x^2 along the interval [A,B]");
         System.out.println("The more rectangles you use the more accurate the approximation");
         System.out.println("");
         
         System.out.println("Enter an A value: ");
         double start  =  Double.parseDouble(kb.nextLine());
         
         System.out.println("Enter a B value: ");
         double end  =  Double.parseDouble(kb.nextLine());
              
         System.out.println("Enter the number of rectangles you want to use to approx (more is better) : ");
         int numRects  =  Integer.parseInt(kb.nextLine());
         double area = 0.0;
         // if both are positive.
         if(start>=0 && end >=0)
            area = areaMaker(start, end, numRects);
         
         // if both are negative (since symetical, note this might not work if there are horizontal shifts in the function)
         if(start<0 && end<0)
         {
            System.out.println("start is neg, end is neg");
            double start1 = Math.abs(start);
            end = Math.abs(end);
            area = areaMaker(start1, end, numRects);
         }
         if(start<0 && end>=0) // start is neg end is pos (this is the doozey).
         {
            double start1 = Math.abs(start);
            
            int leftRects = 0;
            int rightRects = 0;
            Double distance = start + end;       
            
            Double temp = ((start1 / distance) * numRects);
            leftRects = temp.intValue();
            System.out.println("Left rectangles: " + leftRects);
            temp = ((end / distance) * numRects);
            rightRects = temp.intValue();
            System.out.println("Right rectangles: " + rightRects);
            
            while(leftRects + rightRects <= numRects-1)
            {
               leftRects++;
               rightRects++;
            }
            leftRects = leftRects++; // these are arbritary
            rightRects = rightRects++; // this adds a margin for error so that there are slightly more rectangles than the number the user puts in.
            System.out.println("Proper total amount of rectangles: " + numRects);        
            area = areaMaker(0, start1, leftRects)+ areaMaker(0, end, rightRects); 
            
         }
         
         DecimalFormat df = new DecimalFormat("##.000000");
         System.out.println("The approximate area under the curve f(x) = x^2 along the interval " + start + " to " + end + " is: " + df.format(area));
         System.out.println("Go again (1)    stop(0)");
         choice = Integer.parseInt(kb.nextLine());
      } while(choice == 1);
   }
   
   public static double areaMaker(final double start, final double end, final int numRects)
   {
      double area = 0.0;
      double difference  = end / numRects; // The distance between each of the endpoints when it is cut into numRects slices.  
      double[] ar = baseCalulator(start, end, numRects);
      
      for(int x = 0; x < numRects; x++)
      {
         area = area + (f(ar[x+1])* difference);
      }
      return area;
   }
   
   
   public static double f(double x) // f(x) = x^2
   {
      return Math.pow(x,2);
   }
     
   public static double[] baseCalulator(double start, double end, int numRects)
   {
      double[] ans = new double[numRects+1];
      if(numRects == 0)
      {
         ans[0] = 0.0;
         ans[1] = 0.0;
      }
      if(numRects == 1)
      {
         ans[0] = start;
         ans[1] = end;
      }
      if(numRects >  1)
      {
         ans[0] = start;
         ans[numRects-1] = end;
         double difference  = end / numRects;
         // the first and the last are correct.
         // if there are 2 rectangle I am filling everything from index number 1 to index number numRects inclusive. 
         for (int x = 1 ; x <= numRects; x++)
         {
            ans[x] = ans[x-1] + difference;
         }     
      }
      return ans;
   }
}

/*
A method that represents the quadratic function x^2

To start only look at positive numbers so from 0 to 4. Find that area under the curve. 
That will be in an int[] = {0,4};

Then you need the number of rectangles to specify that value. Start with rectangles.



*/

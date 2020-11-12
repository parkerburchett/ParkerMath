import java.util.Scanner;
import java.text.DecimalFormat;

public class Main
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      int choice=1;
      
      while(choice == 1)
      {
         System.out.println("Calculate the Riemann Sum for f(x) = x^2 along the interval [A,B] with N rectangles");
         double start = GetUserInput.getDouble(kb, "Enter a Value for A");
         double end = GetUserInput.getDouble(kb, "Enter a Value for B");
         int rectangles = GetUserInput.getInt(kb, "Enter a number of rectangles");
         
         double approxArea = AreaCalculator.findArea(start, end, rectangles);
         DecimalFormat df = new DecimalFormat("###.00000000");
         
         System.out.println("The area between [" + start + "," + end + "] under the curve f(x) = x^2 is approx : " +  df.format(approxArea));
         double trueArea = AreaCalculator.trueArea(start,end);
         
         System.out.println("The true area is :" + df.format(trueArea));   
         System.out.println("The approximation was off by " + df.format((trueArea - approxArea)));
         
         System.out.println("Go again (1)    stop(0)");
         choice = Integer.parseInt(kb.nextLine());
      }
   }
}
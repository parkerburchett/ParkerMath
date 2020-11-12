import java.util.Scanner;

public class GetUserInput
{
   public static double getDouble(Scanner kb, String prompt)
   {
         System.out.println(prompt);
         return Double.parseDouble(kb.nextLine());
   }
   
   public static int getInt(Scanner kb, String prompt)
   {
        System.out.println(prompt);
        return Integer.parseInt(kb.nextLine());
   }
         
}
        // System.out.println("Program to approximate the area under the f(x) = x^2 along the interval [A,B]");
        // System.out.println("The more rectangles you use the more accurate the approximation");
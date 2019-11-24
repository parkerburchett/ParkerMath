import java.math.*;
import java.util.*;

public class QuadraticSolver{

   public double [] quadraticEquation(final double A, final double B, final double C)
   {
   /* in the classic quadatic equation you pass in (a,b,c) and it spits out the zero's of that function. 
   
   right now this will only deal with Real Numbers
   
   x such that Ax^2 + Bx +Cx = 0
   
   the equation is:
   
   -B +- sqrt(B^2  -4AC)
   _________________
   2a
   
    */   
   double [] ans = new double [2];
   ans[0] = (-1*B + Math.pow(B*B -4*A*C, .5)) / 2*A;
   ans[1] = (-1*B - Math.pow(B*B -4*A*C, .5)) / 2*A;
   
   return ans;
   // I think this works, I just need to run a tester on this
   // I don't know what degree of accuracy there is here
      }

}

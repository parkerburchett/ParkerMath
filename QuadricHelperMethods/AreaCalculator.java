import java.math.*;


public class AreaCalculator
{
   
   public static double findArea( double start,  double end, final int rectangles)
   {    
      double fixedStart =  Math.min(start,end);
      double fixedEnd = Math.max(start,end); 
      double width =  getWidth(fixedStart, fixedEnd, rectangles);
      double[] xValues = createX_Values(fixedStart, fixedEnd, rectangles, width);
      double[] yValues = createY_Values(xValues, rectangles);
      
      double area =0.0;
      for (int i =0; i < rectangles; i++)
      {
         area = area + width * yValues[i];
      }
      return area;
   } 
   
   private static double f(double x) // f(x) = x^2
   {
      return Math.pow(x,2);
   }
   
   private static double getWidth(final double start, final double end, 
                                  final int rectangles)
   {
      return Math.abs(end - start) / rectangles;
   }
   
   
   private static double[] createX_Values(final double start, final double end,
                                          final int rectangles, final double width)   
   {   
      double[] xValues = new double[rectangles];
     
      for(int i = 0; i<rectangles; i++)
      {
         xValues[i] = (start + i*width);
      }
      return xValues;
   }
   
  
   private static double[] createY_Values(double[] xValues, final int rectangles)
   {
      double[] yValues = new double[rectangles];

      for(int i = 0; i<rectangles; i++)
      {
         yValues[i] = f(xValues[i]);
      }
      return yValues;
   }
   
   public static double trueArea(double start, double end)
   {
      double fixedStart =  Math.min(start,end);
      double fixedEnd = Math.max(start,end);
      return (Math.pow(fixedEnd,3)/3) - (Math.pow(fixedStart,3)/3);
   }
     
   
}
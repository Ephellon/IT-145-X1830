import java.util.Scanner;

public class Paint2 {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double wallHeight = 0.0;
      double wallWidth = 0.0;
      double wallArea = 0.0;
      double gallonsPaintNeeded = 0.0;
      double cansPaintNeeded = 0.0;

      final double squareFeetPerGallons = 350.0;

      // Implement a do-while loop to ensure input is valid
      // Prompt user to input wall's height
      do {
         System.out.println("Enter wall height (feet): ");

         /* There isn't a double present */
         if(!scnr.hasNextDouble()) {
            // Eat the next token
            scnr.next();

            // Try the next input
            continue;
         }

         wallHeight = scnr.nextDouble();

         /* Will result in no paint needed */
         if(!(wallHeight > 0))
            continue;

         // The input's OK
         break;
      } while(true);

      // Implement a do-while loop to ensure input is valid
      // Prompt user to input wall's width
      do {
         System.out.println("Enter wall width (feet): ");

         /* There isn't a double present */
         if(!scnr.hasNextDouble()) {
            // Eat the next token
            scnr.next();

            // Try the next input
            continue;
         }

         wallWidth = scnr.nextDouble();

         /* Will result in no paint needed */
         if(!(wallWidth > 0))
            continue;

         // The input's OK
         break;
      } while(true);

      // Calculate and output wall area
      wallArea = wallHeight * wallWidth;
      System.out.println("Wall area: " + wallArea + " square feet");

      // Calculate and output the amount of paint (in gallons) needed to paint the wall
      gallonsPaintNeeded = wallArea / squareFeetPerGallons;
      System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");

      // Round the `gallonsPaintNeeded` up as the number of cans needed
      cansPaintNeeded = Math.ceil(gallonsPaintNeeded);
      System.out.println("Cans needed: " + cansPaintNeeded + " can(s)");
   }
}

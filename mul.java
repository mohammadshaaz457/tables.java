// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class shaaz {
   public shaaz() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("enter a number :");
      int var2 = var1.nextInt();

      for(int var3 = 1; var3 < 100; ++var3) {
         System.out.println("" + var2 + "x" + var3 + "=" + var2 * var3);
      }

   }
}

package com.itschool;

public class Main {

   public static void main(String[] args) {

      //Scanner scanner = new Scanner(System.in);
      String number = " ВH1234aE ";
      System.out.println((isCoorectAutoMNumber(number) ? "Correct" : "Incorrect") + " number");

      String name = "iVANOV";
      System.out.println(capitalize(name));
   }

   public static String capitalize(String str)
   {
      return str.strip().substring(0,1).toUpperCase()+str.strip().substring(1).toLowerCase();
   }

   private static String glyphSubstitute(String number) {
      String result = "";

      String engChars = new String(new char[]{'A', 'B', 'C'});
      String cyrChars = new String(new char[]{'А', 'В', 'С'});

      int pos = -1;
      for (char symbol : number.toCharArray()) {
         if (cyrChars.contains(symbol + "")) {
            pos = cyrChars.indexOf(symbol + "");
            result += engChars.substring(pos, pos + 1);
         }
         else
            result += symbol;
      }

      return result;
   }

   private static boolean isCoorectAutoMNumber(String number) {
      final String autoNumberChars = "ETIOPAHKXCBM";
      number = glyphSubstitute(number.strip().toUpperCase());
      //System.out.println("|"+number+"|");

      char char1 = number.charAt(0);
      char char2 = number.charAt(1);
      char char7 = number.charAt(6);
      char char8 = number.charAt(7);

      if (autoNumberChars.contains(char1 + "")
              &&
              autoNumberChars.contains(char2 + "")
              &&
              autoNumberChars.contains(char7 + "")
              &&
              autoNumberChars.contains(char8 + "")
      ) {
         for (int symbol = 2; symbol <= 5; symbol++) {
            if (!Character.isDigit(number.charAt(symbol))) {
               return false;
            }
         }
      } else {
         return false;
      }

      return true;
   }
}

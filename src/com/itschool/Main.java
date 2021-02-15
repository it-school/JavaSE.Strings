package com.itschool;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

   public static final int CAESAR_CODE = 3;
   public static String alphabetVigenere;
   public static char[][] vigenereTable;


   public static void main(String[] args) {

      //Scanner scanner = new Scanner(System.in);
//      String number = " ВH1234aE ";
//      System.out.println((isCoorectAutoMNumber(number) ? "Correct" : "Incorrect") + " number");
//
//      String name = "iVANOV";
//      System.out.println(capitalize(name));

      // split
      // StringBuffer / StringBuilder
      // Vigenere cipher

//      HomeTask3();
//      HomeTask4();
      HomeTask9();
//      String cryptedText = CaesarCipher("CAESAR");
//      System.out.println(cryptedText);
//      String decryptedText = CaesarUnCipher(cryptedText);
//      System.out.println(decryptedText);

/*      String text = "The Vigenere cipher is a method of encrypting alphabetic text by using a series of interwoven Caesar ciphers, based on the letters of a keyword.";
      System.out.println((alphabetVigenere = getAlphabet(text)));
      // alphabetVigenere = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
      fillVigenereTable(alphabetVigenere);
      String key = genKey(alphabetVigenere, 1);
      System.out.println(key);
      String encryptedText = cypherVigenere(text, key);
      System.out.println(encryptedText);
      System.out.println(text);
      String decryptedText = uncypherVigenere(encryptedText, key);
      System.out.println(decryptedText);

      System.out.println(text.equals(decryptedText));*/


//      regexpExample();

      String UCASE_letters = "";
      for (char c = 'A'; c <= 'z'; c++) {
         if (c > 'Z' && c < 'a')
            continue;
         UCASE_letters += c;
      }
      System.out.println(UCASE_letters);

      String string = "";
      int first;

      Scanner scanner = new Scanner(System.in);
      boolean isCorrectNumber = false;

      do {
         string = scanner.nextLine();
         try {
            first = Integer.parseInt(string);
            System.out.println(first);
            isCorrectNumber = true;
         } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
         }
      } while (!isCorrectNumber);
   }

   private static void HomeTask9() {
      // Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество слов в ней.
      String string = "Qwerty   uiop  poiu  poiu  ytrewQ";

      System.out.println(string.split("\s+").length);
   }

   private static void regexpExample() {
      String text = "Егор Алла Александр";
      long start = System.currentTimeMillis();
      String result = "";
      Pattern pattern;
      Matcher matcher;
      for (int i = 0; i < 1000000; i++) {
         pattern = Pattern.compile("А.+а");
         matcher = pattern.matcher(text);
         matcher.find();
         {
            result = text.substring(matcher.start(), matcher.end());
            //System.out.println(text.substring(matcher.start(), matcher.end()));
         }
      }

      long stop = System.currentTimeMillis();
      System.out.println(stop - start);

      int p1, p2;
      for (int i = 0; i < 1000000; i++) {
         p1 = text.indexOf("А");
         p2 = text.lastIndexOf("а");
         result = text.substring(p1, p2);
      }
      System.out.println(System.currentTimeMillis() - stop);
   }

   private static String cypherVigenere(String encryptedText, String key) {
      String result = "";
      int posH;
      int posV;
      for (int i = 0; i < encryptedText.length(); i++) {
         posH = alphabetVigenere.indexOf(encryptedText.charAt(i));
         posV = alphabetVigenere.indexOf(key.charAt(i % key.length()));
         result += vigenereTable[posH][posV];
      }

      return result;
   }

   private static String uncypherVigenere(final String text, final String key) {
      String result = "";
      int posH = 0;
      int posV = 0;
      for (int i = 0; i < text.length(); i++) {
         //posV = alphabetVigenere.indexOf(text.charAt(i));
         posV = alphabetVigenere.indexOf(key.charAt(i % key.length()));
         for (int j = 0; j < alphabetVigenere.length(); j++) {
            if (vigenereTable[posV][j] == text.charAt(i))
               posH = j;
         }
         result += vigenereTable[0][posH];
      }

      return result;
   }

   private static String genKey(final String alphabetVigenere, final int keyLength) {
      String newKey = "";
      int counter = 0;
      char c = 0;
      Random random = new Random();

      while (counter < keyLength) {
         do {
            c = alphabetVigenere.charAt(random.nextInt(alphabetVigenere.length()));
         } while (newKey.contains("" + c));
         newKey += c;
         counter++;
      }

      return newKey;
   }

   public static void fillVigenereTable(final String alphabetVigenere) {
      vigenereTable = new char[alphabetVigenere.length()][alphabetVigenere.length()];
      for (int row = 0; row < alphabetVigenere.length(); row++) {
         for (int col = 0; col < alphabetVigenere.length(); col++) {
            vigenereTable[row][col] = alphabetVigenere.charAt((row + col) % alphabetVigenere.length());
            System.out.print(vigenereTable[row][col] + " ");
         }
         System.out.println();
      }
   }

   public static String getAlphabet(final String text) {
      String alphabet = "";

      for (Character c : text.toCharArray()) {
         if (!alphabet.contains(c + ""))
            alphabet += c;
      }

      return alphabet;
   }

   public static String CaesarCipher(final String text) {
      return ShiftCipfer(text, CAESAR_CODE);
   }

   public static String CaesarUnCipher(final String text) {
      return ShiftCipfer(text, -CAESAR_CODE);
   }

   public static String ShiftCipfer(final String text, final int KEY) {
      String result = "";

      for (Character c : text.toCharArray()) {
         //System.out.println(c + " : " + (int) c);
         result += (char) (((int) c) + KEY);
      }

      return result;
   }

   public static void HomeTask4() {
      //Найти в строке указанную подстроку и заменить ее на новую.
      String string = "Qwerty   uiop  poiu   poiu  ytrewQ";
      StringBuilder sbstring = new StringBuilder(string);

      String textOld = "poiu";
      String textNew = "12345";

//      string = string.replace(textOld, textNew);
      int pos = -1;
      do {
         pos = string.indexOf(textOld);
         if (pos >= 0)
            string = string.substring(0, pos) + textNew + string.substring(pos + textOld.length());
      } while (pos >= 0);
      System.out.println(string);
   }

   public static void HomeTask3() {
      // Удалить из строки пробелы и определить, является ли она перевертышем
      String string = "Qwerty   uiop  poiu     ytrewQ";
      StringBuilder sbstring = new StringBuilder(string);
      System.out.println(string);
      System.out.println(sbstring);

//      for(String word : string.split(" "))
//         System.out.println(word);
      string = string.replace(" ", "");
      System.out.println(string);

      int p = 0;
      do {
         p = sbstring.indexOf(" ", 0);
         if (p >= 0)
            sbstring.replace(p, p + 1, "");
         System.out.println(sbstring);
      } while (p >= 0);

      boolean isReversed = true;
      for (int i = 0; i < string.length() / 2; i++) {
         if (!(string.charAt(i) == string.charAt(string.length() - 1 - i))) {
            isReversed = false;
            break;
         }
      }
      System.out.println(isReversed ? "Palindrom" : "Not palindrom");


      isReversed = true;
      for (int i = 0; i < string.length() / 2; i++) {
         if (!(sbstring.charAt(i) == sbstring.charAt(string.length() - 1 - i))) {
            isReversed = false;
            break;
         }
      }
      System.out.println(isReversed ? "Palindrom" : "Not palindrom");
   }


   public static String capitalize(String str) {
      return str.strip().substring(0, 1).toUpperCase() + str.strip().substring(1).toLowerCase();
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
         } else
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
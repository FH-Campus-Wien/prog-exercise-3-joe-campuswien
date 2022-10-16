package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int numberOfDays, int firstDayOfMonth) {
        int weekDayIndex = 0;

        for (int i = 0; i < firstDayOfMonth - 1; i++) {
            System.out.print("   ");
            weekDayIndex++;
        }

        for (int j = 1; j <= numberOfDays; j++) {
            System.out.printf("%2d ", j);
            weekDayIndex++;

            if (weekDayIndex == 7 && j != numberOfDays) {
                System.out.println();
                weekDayIndex = 0;
            }
        }

        System.out.println();
    }

    public static long[] lcg(long seed) {
        long[] result = new long[10];
        final long m = (long) Math.pow(2, 31);
        final int a = 1103515245;
        final int c = 12345;

        for (int i = 0; i < result.length; i++) {
            result[i] = (a * seed + c) % m;
            seed = result[i];
        }

        return result;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        boolean guessedCorrectly = false;
        int guessCount = 1;

        while (guessCount <= 10) {
            System.out.printf("Guess number %d: ", guessCount);
            guess = scanner.nextInt();

            if (guess > numberToGuess && guessCount != 10) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (guess < numberToGuess && guessCount != 10) {
                System.out.println("The number AI picked is higher than your guess.");
            }

            if (guess == numberToGuess) {
                guessedCorrectly = true;
                break;
            }

            guessCount++;
        }

        if (guessedCorrectly) {
            System.out.println("You won wisenheimer!");
        } else {
            System.out.println("You lost! Have you ever heard of divide & conquer?");
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        return new Random().nextInt(99) + 1;
    }

    public static boolean swapArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) return false;

        for (int i = 0; i < array1.length; i++) {
            int arrayValue1 = array1[i];
            int arrayValue2 = array2[i];

            array1[i] = arrayValue2;
            array2[i] = arrayValue1;
        }

        return true;
    }

    public static String camelCase(String sentence) {
        String camelCaseSentence = "";
        char[] chars = sentence.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            boolean firstCharacterOrAfterSpace = i == 0 || chars[i - 1] == ' ';

            if (isPunctuationOrSpace(chars[i])) {
                continue;
            }

            if (firstCharacterOrAfterSpace && isLowercase(chars[i])) {
                camelCaseSentence += getUpperCase(chars[i]);
            } else if (!firstCharacterOrAfterSpace && !isLowercase(chars[i])) {
                camelCaseSentence += getLowerCase(chars[i]);
            } else {
                camelCaseSentence += chars[i];
            }
        }

        return camelCaseSentence;
    }

    public static boolean isPunctuationOrSpace(char character) {
        return character == '.' || character == '?' || character == '!' || character == ',' || character == '\'' || character == ' ';
    }

    public static boolean isLowercase(char character) {
        // ascii value range of a-z
        return (int) character >= 97 && (int) character <= 122;
    }

    public static char getUpperCase(char character) {
        return (char) ((int) character - 32);
    }

    public static char getLowerCase(char character) {
        return (char) ((int) character + 32);
    }

    public static int checkDigit(int[] code) {
        int productSum = 0;

        for (int i = 0; i < code.length; i++) {
            productSum += code[i] * (i + 2);
        }

        int checkDigit = 11 - (productSum % 11);
        return checkDigit == 10 ? 0 : (checkDigit == 11 ? 5 : checkDigit);
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }
}
/**
 * File Name: AppBasics.java<br>
 * Kononov, Vladimir<br>
 * Created: Aug 19, 2017
 */
package com.sqa.vk.helpers;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

import com.sqa.vk.helpers.exceptions.*;

/**
 * AppBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Kononov, Vladimir
 * @version 1.0.0
 * @since 1.0
 */
public class AppBasics {

	private static Scanner scanner = new Scanner(System.in);

	public static String addDays(int days) {
		LocalDate date = LocalDate.now().plusDays(days);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String date1 = date.format(formatters);
		return date1;
	}

	public static void farewellUser(String userName) {
		System.out.println("\nThank you, " + userName + " for using our application.");
		System.out.println("Have a nice day!");
	}

	public static String greetUserAndGetName(String appName) {
		// Greet the user using a system out call
		System.out.println("Hello there! Wellcome to the " + appName + " Application");
		// Ask the user for their name and store in a local scope String
		// variable
		// String userName = null;
		System.out.print("Can i get your name? ");
		String userName = scanner.nextLine();
		return userName;
	}

	public static void greetUserAndIntroTest(String appName, String testName) {
		// Greet the user using a system out call
		System.out.println("Welcome to the " + appName + " Application.");
		// Ask the user for their name and store in a local scope String
		// variable
		System.out.println("\\-------------------------------------------------------------------\\");
		System.out.println("You are running the following tests for " + testName);
		System.out.println("\\-------------------------------------------------------------------\\\n");
	}

	public static boolean requestBoolean(String question) {
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.println(question + " ");
			input = scanner.nextLine();
			if (input.trim().equalsIgnoreCase("Yes")) {
				return true;
			} else if (input.trim().equalsIgnoreCase("No")) {
				return false;
			} else {
				System.out.println("You didn't respond to the question. Please enter \"Yes\" or \"No\"");
			}
		}
		return isValid = true;
	}

	public static char requestChar(String question) {
		char letter = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.println(question + " ");
			try {
				letter = scanner.nextLine().charAt(0);
				if (Character.isLetter(letter) || Character.isDigit(letter)) {
					System.out.println("You enterered \"" + letter + "\"");
				}
				isValid = true;
			} catch (StringIndexOutOfBoundsException e) {
				System.out
						.println("You did not supply a valid input [" + letter + "]. please provide a single letter.");
			}
		}
		return letter;
	}

	public static double requestDouble(String question) {
		double num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Double.parseDouble(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			}
		}
		return num;
	}

	public static float requestFloat(String question) {
		float num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Float.parseFloat(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			}
		}
		return num;
	}

	public static int requestInt(String question, int min, int max) {
		int num = 0;
		String input;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(question + " ");
			input = scanner.nextLine();
			try {
				num = Integer.parseInt(input);
				if (num > max) {
					throw new RequestIntOverMaxException();
				} else if (num < min) {
					throw new RequestIntUnderMinException();
				}
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You did not supply a valid number [" + input + "]. please provide only digits.");
			} catch (RequestIntOverMaxException e) {
				System.out.println("You have exceeded the max value of " + max + "[" + input
						+ "]. Please provide a number withing range.");
			} catch (RequestIntUnderMinException e) {
				System.out.println("You have exceeded the min value of " + max + "[" + input
						+ "]. Please provide a number withing range.");
			}
		}
		return num;
	}

	public static long requestLong(String question) {
		String input;
		long num = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.println(question + " ");
			input = scanner.nextLine();
			try {
				num = Long.parseLong(input);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("You didn't provide expected input [" + input + "]. Please enter Long number.");
			}
		}
		return num;
	}

	public static short requestShort(String question) {
		String input;
		short num = 0;
		System.out.println(question + " ");
		input = scanner.nextLine();
		try {
			num = Short.parseShort(input);
		} catch (NumberFormatException e) {
			System.out.println("You didn't provide expected input [" + input + "]. Please enter Short number.");
		}
		return num;
	}

	public static String requestString(String question) {
		System.out.print(question + " ");
		return scanner.nextLine();
	}

	public static String substractDays(int days) {
		LocalDate date = LocalDate.now().minusDays(days);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
		String date1 = date.format(formatters);
		return date1;
	}

	public static String todayDate() {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		// get current date time with Date()
		Date date = new Date();
		// Now format the date
		String date1 = dateFormat.format(date);
		// Print the Date
		// System.out.println(date1);
		return date1;
	}
}

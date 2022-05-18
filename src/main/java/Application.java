import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Application {

	private static Scanner in = new Scanner(System.in);
	private static String inputString;
	private static TreeMap<Character, Integer> charMap;

	public static void main(String[] args) {

		System.out.println("Hello! This program will count how many times each " 
							+ "letter appears in the text you type.");
		
		do {
			charMap = new TreeMap<Character, Integer>();
			
			System.out.println("Type in your text.");
			inputString = in.nextLine();
			inputString = inputString.replace(" ", "").toLowerCase();
			List<Character> charArray = inputString.chars().mapToObj(
					letter -> (char) letter).collect(Collectors.toList());

			for (char letter : charArray) {
				charMap.put(letter, 0);
				int freq = Collections.frequency(charArray, letter);
				charMap.put(letter, freq);
			}
			
			for (HashMap.Entry<Character, Integer> entry : charMap.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}

		} while (rerunApp());
	}

	private static boolean rerunApp() {
		System.out.println("Do you want to continue?");
		String rerunApp = in.nextLine();
		if (rerunApp.equals("Yes")) {
			return true;
		} else {
			return false;
		}
	}
}

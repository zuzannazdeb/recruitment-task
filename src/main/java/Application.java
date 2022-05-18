import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String inputString;
		HashMap<Character, Integer> charMap;
		System.out.println("Hello! This program will count how many times each letter appears in the text you type.");
		do {
			System.out.println("Type in your text.");
			inputString = in.nextLine();
			inputString = inputString.replace(" ", "");
			List<Character> charArray = inputString.chars()
				    .mapToObj(letter -> (char) letter).collect(Collectors.toList());
			charMap = new HashMap<Character, Integer>();

			for (char letter : charArray) {
				charMap.put(letter, 0);
//				charMap.put(letter, charMap.get(letter) + 1);
				int freq = Collections.frequency(charArray, letter);
				charMap.put(letter, freq);
			}
			for (HashMap.Entry<Character, Integer> entry : charMap.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}

		} while (false);

	}

}

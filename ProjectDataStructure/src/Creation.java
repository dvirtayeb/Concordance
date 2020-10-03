import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Creation {
	String[] arrayWords;
	private WordsIndex<MyLinkedList<Words>> charsTable;
	private char[] alphabet;

	public Creation() throws FileNotFoundException {
		arrayWords = new String[calculateWords()];
		charsTable = new WordsIndex<MyLinkedList<Words>>();
		alphabet = new char[26];

	}

	// function that reads words from text and make the Concordance.
	public WordsIndex<MyLinkedList<Words>> createTableFromTextFile() throws Exception, FileNotFoundException {
		File file = new File("textDS.txt");
		Scanner input = new Scanner(file);
		int numLine = 1;
		alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		MyLinkedList<Words> charAlahabet = null;

		// insert the alphabet for hashMap into the data structure: WordsIndex
		for (int i = 0; i < alphabet.length; i++) {
			charAlahabet = new MyLinkedList<>();
			charsTable.insert(charAlahabet, alphabet[i]);
		}

		// read the text and insert into the data structure: WordsIndex
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] arrayWordsTemp = line.split(" ");
			Words[] WordsArray = new Words[arrayWordsTemp.length];
			for (int i = 0; i < arrayWordsTemp.length; i++) {
				Words wordsPosition = new Words(numLine, i + 1, arrayWordsTemp[i]);
				WordsArray[i] = wordsPosition;

				char firstChar = Character.toLowerCase(arrayWordsTemp[i].charAt(0));
				MyLinkedList<Words> currentLinkListInHashMap = charsTable.search(firstChar).getLinklist();
				currentLinkListInHashMap.add(wordsPosition);
			}
			numLine++;
		}
		// Sort the link list in the table, by Merge Sort.
		for (int i = 0; i < alphabet.length; i++) {
			MyLinkedList<Words> currentLinkListInHashMap = charsTable.search(alphabet[i]).getLinklist();
			MyNodeOfLinkList<Words> first = currentLinkListInHashMap.getFirst();
			currentLinkListInHashMap.setFirst(currentLinkListInHashMap.mergeSort(first, 0));
		}
		input.close();
		return charsTable;
	}

	public int calculateWords() { // O(N)
		int countWord = 0;
		String line = "";
		try {
			File file = new File("textDS.txt");
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) { // O(N)
				line = line + input.next() + " ";
			}
			String[] tokens = line.split(" ");
			for (int i = 0; i < tokens.length; i++) { // O(N)
				countWord++;
			}
			input.close();
			return countWord;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
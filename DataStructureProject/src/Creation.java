import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Creation {
	private WordsIndex<MyLinkedList<Words>> charsTable;
	private char[] alphabet;

	public Creation() throws FileNotFoundException {
		charsTable = new WordsIndex<MyLinkedList<Words>>();
		alphabet = new char[26];
	}

	// function that reads words from text and make the Concordance.
	public WordsIndex<MyLinkedList<Words>> createTableFromTextFile(File file) throws Exception, FileNotFoundException {
		Scanner input = new Scanner(file);
		int numLine = 1;

		// insert the alphabet for hashMap into the data structure: WordsIndex
		alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < alphabet.length; i++) { // O(26) <= O(N)
			MyLinkedList<Words> emptyLinkList = new MyLinkedList<>();
			charsTable.insert(emptyLinkList, alphabet[i]);
		}

		// read the text and insert into the data structure: WordsIndex
		while (input.hasNextLine()) { // O(N*K)
			String line = input.nextLine();
			String[] arrayWordsTemp = line.replaceAll("[^a-zA-Z\\s]+", "").split(" ");
			if (!(line.equals(""))) {
				Words[] WordsArray = new Words[arrayWordsTemp.length];
				for (int i = 0; i < arrayWordsTemp.length; i++) {
					if (!(arrayWordsTemp[i].equals("") || !(arrayWordsTemp[i].length() > 1))) {
						Words wordsPosition = new Words(numLine, i + 1, arrayWordsTemp[i]);
						WordsArray[i] = wordsPosition;
						// insert into the link list:
						char firstChar = Character.toLowerCase(arrayWordsTemp[i].charAt(0));
						MyLinkedList<Words> currentLinkList = charsTable.search(firstChar).getLinklist();
						currentLinkList.add(wordsPosition);
					}
				}
			}
			numLine++;
		}
		// Sort the link list in the table, by Merge Sort.
		for (int i = 0; i < alphabet.length; i++) { // O(26) <= O(N) <= O(NLOG(n/2))
			MyLinkedList<Words> currentLinkListInHashMap = charsTable.search(alphabet[i]).getLinklist(); // O(1)
			MyNodeOfLinkList<Words> firstNode = currentLinkListInHashMap.getFirst();
			currentLinkListInHashMap.setFirst(currentLinkListInHashMap.mergeSort(firstNode)); // O(NLOG(n/2))
		}
		input.close();
		return charsTable;
	}
}

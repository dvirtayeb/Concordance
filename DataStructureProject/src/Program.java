import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws Exception, FileNotFoundException {
		Creation creator = new Creation();

		// Read the file and create the table.
		File file = new File("C:/Users/dvir tayeb/Desktop/Document(3).txt");
		WordsIndex<MyLinkedList<Words>> hashTable = creator.createTableFromTextFile(file);
		hashTable.show();

		// Searching:
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a word to search in the link list: ");
		String chooseData = scan.next();
		System.out.println("looking for the char '" + chooseData.charAt(0) + "' in the map......");
		System.out.println(hashTable.search(chooseData.charAt(0)).getLinklist().search(chooseData));
		scan.close();
	}

}

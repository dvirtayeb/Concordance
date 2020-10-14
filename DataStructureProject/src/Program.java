import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws Exception, FileNotFoundException {
		Creation creator = new Creation();
		Scanner scanner = new Scanner(System.in);
		// Read the file and create the table.
		File file = new File("C:/Users/dvir tayeb/Desktop/Doco.txt");
		WordsIndex<MyLinkedList<Words>> hashTable = creator.createTableFromTextFile(file);
		System.out.println("End sort, now its write to a new file.........");
		FileWriter newFile = new FileWriter("C:/Users/dvir tayeb/Desktop/Document(4).txt");
		newFile.write(hashTable.toString());
		newFile.close();

		// Search a word:
		System.out.println("Choose a word to search in the link list: ");
		String chooseData = scanner.next();
		System.out.println("looking for the char '" + chooseData.charAt(0) + "' in the map......");
		System.out.println(hashTable.search(chooseData.charAt(0)).getLinklist().search(chooseData));
		scanner.close();
	}

}

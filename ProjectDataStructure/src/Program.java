import java.io.FileNotFoundException;

public class Program {

	public static void main(String[] args) throws Exception, FileNotFoundException {
		Creation creator = new Creation();
		WordsIndex<MyLinkedList<Words>> hashTable = creator.createTableFromTextFile();
		hashTable.print();
	}

}

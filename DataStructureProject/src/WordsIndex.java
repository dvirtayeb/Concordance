import java.util.Arrays;

public class WordsIndex<T> {
	NodeHashing[] table;

	public WordsIndex() {
		table = new NodeHashing[26];
	}

	int hashCode(char key) {
		// limit the hash code for ASCII char
		return (int) key - 97;
	}

	private char validateKey(char key) throws Exception {
		if (key >= 'A' || key <= 'Z') {
			key = Character.toLowerCase(key);
		} else if (!(key >= 'a' && key <= 'z')) {
			throw new Exception("invalid key");
		}
		return key;
	}

	public void insert(MyLinkedList<Words> linkList, char key) throws Exception {
		key = validateKey(key); // check the key
		NodeHashing newNode = new NodeHashing(linkList, key);
		newNode.linkList = linkList;
		newNode.key = key;
		int hashIndex = hashCode(key);
		table[hashIndex] = newNode;

	}

	public NodeHashing search(char key) throws Exception {
		key = validateKey(key);
		int lookupPosition = hashCode(key);
		NodeHashing TempNode = table[lookupPosition];
		return TempNode;
	}

	public NodeHashing[] getTable() {
		return table;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Arrays.toString(table));

		return builder.toString();
	}
}
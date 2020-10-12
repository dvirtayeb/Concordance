
public class NodeHashing {
	protected char key;
	protected MyLinkedList<Words> linkList;

	public NodeHashing(MyLinkedList<Words> linkList, char key) {
		this.linkList = linkList;
		this.key = key;
	}

	public MyLinkedList<Words> getLinklist() {
		return linkList;
	}

	public int getKey() {
		return key;
	}
	
	public String toString() {
		String result = "{Key: \"" + this.key + "\": LinkList: \"" + this.linkList + "\"}";
		return result;
	}
}

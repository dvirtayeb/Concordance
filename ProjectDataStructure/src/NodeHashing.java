
public class NodeHashing {
	protected NodeHashing next;
	protected NodeHashing prev;
	protected String data;
	protected char key;
	protected MyLinkedList<Words> linkList;

	public NodeHashing(String data, char key) {
		this.data = data;
		this.key = key;
		next = null;
		prev = null;
	}

	public NodeHashing(MyLinkedList<Words> linkList, char key) {
		this.linkList = linkList;
		this.key = key;
		next = null;
		prev = null;
	}

	public MyLinkedList<Words> getLinklist() {
		return linkList;
	}

	public NodeHashing getNext() {
		return next;
	}

	public void setNext(NodeHashing next) {
		this.next = next;
	}

	public NodeHashing getPrev() {
		return prev;
	}

	public void setPrev(NodeHashing prev) {
		this.prev = prev;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getKey() {
		return key;
	}

	public void setKey(char key) {
		this.key = key;
	}

	public String toString() {
		String result = "{Key: \"" + this.key + "\": LinkList: \"" + this.linkList + "\"}";
		if (this.next != null) {
			result += ", ";
			result += this.next.toString();
		}
		return result;
	}

	public void setData(MyLinkedList<Words> alphabetlist2) {
		linkList = alphabetlist2;

	}
}

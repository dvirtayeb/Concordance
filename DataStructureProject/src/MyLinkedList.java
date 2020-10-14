
public class MyLinkedList<T> {
	private MyNodeOfLinkList<T> first;
	private MyNodeOfLinkList<T> last;
	private int countLengthLinkList;

	public MyLinkedList() {
		first = null;
		last = null;
		countLengthLinkList = 0;
	}

	public void add(T item) {
		if (item == null) {
			throw new NullPointerException("Cannot add null item.");
		}
		if (!isEmpty()) {
			MyNodeOfLinkList<T> prev = last;
			last = new MyNodeOfLinkList<>(item, null);
			prev.next = last;
		} else {
			last = new MyNodeOfLinkList<>(item, null);
			first = last;
		}
		countLengthLinkList++;
	}

	public String search(String item) { // O(n)
		MyNodeOfLinkList<T> tempNode = first;
		Words[] arrayOfWord = new Words[countLengthLinkList];
		int tempCount = 0;
		for (int i = 0; i < countLengthLinkList; i++) {
			if (((Words) tempNode.data).getWord().equals(item)) {
				arrayOfWord[tempCount] = (Words) tempNode.getData();
				tempCount++;
			}
			tempNode = tempNode.next;
		}
		if (first != null)
			return printArr(arrayOfWord, tempCount);
		return "Not found";
	}

	public String printArr(Words[] arr, int count) {
		String temp = "";
		for (int i = 0; i < count; i++) {
			temp += arr[i];
		}
		return temp;
	}

	public MyNodeOfLinkList<T> mergeSort(MyNodeOfLinkList<T> head) {

		// Base case : if head is null
		if (head == null || head.next == null) {
			return head;
		}
		// get the middle of the list
		MyNodeOfLinkList<T> middle = getMiddle(head);
		MyNodeOfLinkList<T> nextOfMiddle = middle.next;
		middle.next = null;

		// Merge the left and right lists
		return sortedMerge(mergeSort(head), mergeSort(nextOfMiddle));
	}

	MyNodeOfLinkList<T> sortedMerge(MyNodeOfLinkList<T> headA, MyNodeOfLinkList<T> headB) {

		MyNodeOfLinkList<T> dummyNode = new MyNodeOfLinkList<T>(null, null);
		MyNodeOfLinkList<T> tail = dummyNode;
		while (headA != null && headB != null) {
			String aValue = ((Words) headA.data).getWord();
			String bValue = ((Words) headB.data).getWord();

			if (aValue.compareToIgnoreCase(bValue) <= 0) {
				tail.next = headA;
				tail = headA;
				headA = headA.next;
				System.out.println(tail.data);
			} else {
				tail.next = headB;
				tail = headB;
				headB = headB.next;
				System.out.println(tail.data);
			}
		}
		if (headA != null)
			tail.next = headA;
		else if (headB != null)
			tail.next = headB;
		return dummyNode.next;
	}

	public MyNodeOfLinkList<T> getMiddle(MyNodeOfLinkList<T> head) {
		if (head == null)
			return head;

		MyNodeOfLinkList<T> slow = head, fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public MyNodeOfLinkList<T> getFirst() {
		return first;
	}

	public void setFirst(MyNodeOfLinkList<T> first) {
		this.first = first;
	}

	public MyNodeOfLinkList<T> getLast() {
		return last;
	}

	public boolean isEmpty() {
		return countLengthLinkList == 0;
	}

	public String toString() {
		MyNodeOfLinkList<T> temp = first;
		String list = "";
		while (temp != null) {
			list = list + temp.data + " ";
			temp = temp.next;
		}
		return list.trim();
	}
}
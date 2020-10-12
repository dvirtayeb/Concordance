
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
		if (arrayOfWord[0] != null)
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
	
	MyNodeOfLinkList<T> mergeSort(MyNodeOfLinkList<T> head) {

		// Base case : if head is null
		if (head == null || head.next == null) {
			return head;
		}

		// get the middle of the list
		MyNodeOfLinkList<T>[] arr = findMiddleAndSplit(head);
		MyNodeOfLinkList<T> first_half = arr[0];
		MyNodeOfLinkList<T> second_half = arr[1];

		// Apply mergeSort on left list
		first_half = mergeSort(first_half);

		// Apply mergeSort on right list
		second_half = mergeSort(second_half);

		// Merge the left and right lists
		MyNodeOfLinkList<T> sortedlist = sortedMerge(first_half, second_half);

		return sortedlist;
	}

	MyNodeOfLinkList<T> sortedMerge(MyNodeOfLinkList<T> a, MyNodeOfLinkList<T> b) {
		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		MyNodeOfLinkList<T> result = null;
		/* Pick either a or b, and recur */
		String aValue = ((Words) a.data).getWord();
		String bValue = ((Words) b.data).getWord();
		if (aValue.compareToIgnoreCase(bValue) <= 0) {
			result = a;
			result.next = sortedMerge(a.getNext(), b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.getNext());
		}
		return result;
	}

	// splitting list into two halves
	public MyNodeOfLinkList<T>[] findMiddleAndSplit(MyNodeOfLinkList<T> ptr) {
		// base case
		if (ptr == null || ptr.next == null) {
			@SuppressWarnings("unchecked")
			MyNodeOfLinkList<T>[] ret = new MyNodeOfLinkList[] { ptr, null };
			return ret;
		}

		MyNodeOfLinkList<T> backward = ptr;
		MyNodeOfLinkList<T> forward = ptr.next;

		// Forward moves twice and backward moves once
		while (forward != null) {
			forward = forward.next;
			if (forward != null) {
				backward = backward.next;
				forward = forward.next;
			}
		}

		// splitting the linked list
		@SuppressWarnings("unchecked")
		MyNodeOfLinkList<T>[] arr = new MyNodeOfLinkList[] { ptr, backward.next };
		backward.next = null;

		return arr;
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

public class MyLinkedList<T> {
	private MyNodeOfLinkList<T> first;
	private MyNodeOfLinkList<T> last;
	private int Number;

	public MyLinkedList() {
		first = null;
		last = null;
		Number = 0;
	}

	public void add(T item) {
		if (item == null) {
			throw new NullPointerException("The first argument for addLast() is null.");
		}
		if (!isEmpty()) {
			MyNodeOfLinkList<T> prev = last;
			last = new MyNodeOfLinkList<>(item, null);
			prev.next = last;
		} else {
			last = new MyNodeOfLinkList<>(item, null);
			first = last;
		}
		Number++;
	}

	public boolean remove(T item) {
		if (isEmpty()) {
			throw new IllegalStateException("Cannot remove() from and empty list.");
		}
		boolean result = false;
		MyNodeOfLinkList<T> prev = first;
		MyNodeOfLinkList<T> curr = first;
		while (curr.next != null || curr == last) {
			if (curr.data.equals(item)) {
				// remove the last remaining element
				if (Number == 1) {
					first = null;
					last = null;
				}
				// remove first element
				else if (curr.equals(first)) {
					first = first.next;
				}
				// remove last element
				else if (curr.equals(last)) {
					last = prev;
					last.next = null;
				}
				// remove element
				else {
					prev.next = curr.next;
				}
				Number--;
				result = true;
				break;
			}
			prev = curr;
			curr = prev.next;
		}
		return result;
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
		if (aValue.compareTo(bValue) <= 0) {
			// compareToIgnoreCase = check the ASCII code , ignore lowerCase and UpperCase
			result = a;
			result.next = sortedMerge(a.getNext(), b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.getNext());
		}
		return result;
	}

	MyNodeOfLinkList<T> mergeSort(MyNodeOfLinkList<T> head, int level) {

		// Base case : if head is null
		if (head == null || head.next == null) {
			return head;
		}

		// get the middle of the list
		MyNodeOfLinkList<T>[] arr = FrontBackSplit(head);
		MyNodeOfLinkList<T> first_half = arr[0];
		MyNodeOfLinkList<T> second_half = arr[1];

		first_half = mergeSort(first_half, level + 1);

		// Apply mergeSort on right list
		second_half = mergeSort(second_half, level + 1);

		// Merge the left and right lists
		MyNodeOfLinkList<T> sortedlist = sortedMerge(first_half, second_half);

		return sortedlist;
	}

	// splitting list into two halves
	public MyNodeOfLinkList<T>[] FrontBackSplit(MyNodeOfLinkList<T> ptr) {
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
				forward = backward.next;
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

	public void setLast(MyNodeOfLinkList<T> last) {
		this.last = last;
	}

	public boolean isEmpty() {
		return Number == 0;
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
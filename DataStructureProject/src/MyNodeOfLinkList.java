
public class MyNodeOfLinkList<T> {
	T data;
	MyNodeOfLinkList<T> next;

	public MyNodeOfLinkList(T data, MyNodeOfLinkList<T> next) {
		this.data = data;
		this.next = next;

	}

	public T getData() {
		return data;
	}

	public MyNodeOfLinkList<T> getNext() {
		return next;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyNode [data=");
		builder.append(data);
		builder.append(", next=");
		builder.append(next);
		builder.append("]");
		return builder.toString();
	}

}

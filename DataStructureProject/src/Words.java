
public class Words {
	private int line;
	private String word;
	private int index;

	public Words(int line, int index, String word) {
		this.line = line;
		this.index = index;
		this.word = word;
	}
	
	public int getIndex() {
		return index;
	}

	public int getLine() {
		return line;
	}

	public String getWord() {
		return word;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
			builder.append("[");
			builder.append(word);
			builder.append(", index= ");
			builder.append(index);
			builder.append(", line= ");
			builder.append(line);
			builder.append("]");
		return builder.toString();
	}

}

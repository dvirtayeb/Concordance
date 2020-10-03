
public class Words {
	private int line;
	private String word;
	private int index;

	public Words(int line, int index, String word) {
		this.line = line;
		this.index = index;
		this.word = word;
	}
	
	public Words(Words t) {
		this.line = t.line;
		this.index = t.index;
		this.word = t.word;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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

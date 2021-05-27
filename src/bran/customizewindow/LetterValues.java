package bran.customizewindow;
	
public class LetterValues {
		
	private int columns;
	private LetterCondition letterCondition;

	public LetterValues(int columns, LetterCondition letterCondition) {
		this.columns = columns;
		this.letterCondition = letterCondition;
	}

	public int getColumns() {
		return columns;
	}
	
	public LetterCondition getLetterCondition() {
		return letterCondition;
	}

}

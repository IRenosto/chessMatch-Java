package boardLayer;

public class Position {

	private int rows;
	private int columns;

	public Position(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public int getRow() {
		return rows;
	}

	public int getColumn() {
		return columns;
	}

	@Override
	public String toString() {
		return rows + ", " + columns;
	}
	
	
	
}

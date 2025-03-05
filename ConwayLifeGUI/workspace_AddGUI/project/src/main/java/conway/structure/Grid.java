package conway.structure;

public class Grid {
	protected Integer m_rows;
	protected Integer n_columns;
	protected  Cell[][] structure;
	
	public Grid(int rows, int columns) {
		this.m_rows = rows;
		this.n_columns = columns;
		
		this.structure = new Cell[rows][columns]; 
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				structure[i][j] = new Cell();
			}
		}
	}
  
	public Grid() {
		this(10,20);
	}
	
	public void killAllCells() {
		for(int i=0; i<m_rows; i++) {
			for(int j=0; j<n_columns; j++) {
				structure[i][j].killCell();
			}
		}
	}
	
	public void killCellAt(int row, int column ) {
		structure[row][column].killCell();
	}
	
	public void reliveCellAt(int row, int column){
		structure[row][column].reliveCell();
	}
	
	public void switchCellAt(int row, int column){
		structure[row][column].switchState();
	}
	
	
	public Boolean getStateOfCellAt(int row, int column) {
		return structure[row][column].getState();
	}
	
	public void CopyCell(Cell c1, Cell c2) {
		c1.copyCellState(c2);
	}
	
	public void CopyGrid(Grid g) {
		if(this.m_rows == g.m_rows && this.n_columns == g.n_columns ) {
			for(int i=0; i<m_rows; i++) {
				for(int j=0; j<m_rows; j++) {
					CopyCell(structure[i][j], g.structure[i][j]);
				}
			}
		}
	}
}

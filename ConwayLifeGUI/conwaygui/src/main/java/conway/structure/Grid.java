package conway.structure;

//import java.util.List;

import conway.IOutDev;

public class Grid {
	private int m_rows;
	private int n_columns;
	private Cell[][] structure;
	
	
	public Grid(int rows, int columns) {
		this.m_rows = rows;
		this.n_columns = columns;
		this.structure = new Cell[rows][columns]; 
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				structure[i][j] = new Cell(i, j);
			}
		}
	}
  
	public Grid(IOutDev outdev) {
		this(10,20);
	}
	
	public int getNumberOfRows() {
		return m_rows;
	}
	
	public int getNumberOfColumns() {
		return n_columns;
	}
	
	public Cell getCellAt(int i, int j) {
		return structure[i][j];
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
		c1.copyCell(c2);
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

	
	/*public void displayGrid() {
		for (int i = 0; i < this.m_rows; i++) {
			for (int j = 0; j < this.n_columns; j++) {
				displayOfCellAt(i,j);
			}
			displayChangeOfRow();
		}
	}
	
	public void displayChangeOfRow() {
		this.outdev.display("\n");
	}
	
	public void displayOfCellAt(int row, int column) {
		structure[row][column].displayCell();
	}
	
	public void displayOfMultipleCells(List<int[]> cellsToUpdate) {
		if(cellsToUpdate.isEmpty()) {
			return;
		}
		else {
			for(int[] cell: cellsToUpdate) {
				int i = cell[0];
				int j = cell[1];
				this.displayOfCellAt(i, j);
			}
			cellsToUpdate.clear();
		}
	}
	public void updateDisplayOfGrid(){
		for (int i = 0; i < this.m_rows; i++) {
            for (int j = 0; j < this.n_columns; j++) {
                displayOfCellAt(i, j); 
            }
        }
	}
	
	*/
	
}

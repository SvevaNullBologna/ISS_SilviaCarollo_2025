package conway.structure;

import java.util.List;

import conway.IOutDev;

public class GridGUI extends Grid{
	IOutDev outDev;

	public GridGUI(int rows, int columns, IOutDev outDev) {
		super(rows, columns);
		this.outDev = outDev;
	}
	
		
	public void displayGrid() {
		for (int i = 0; i < this.m_rows; i++) {
			for (int j = 0; j < this.n_columns; j++) {
				displayOfCellAt(i,j);
			}
			displayChangeOfRow();
		}
	}
	
	public void displayChangeOfRow() {
		outDev.displayCell("\n");
	}
	
	public void displayOfCellAt(int row, int column) {
		new CellGUI(structure[row][column], outDev).displayCell();
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
	
}

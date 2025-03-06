package conway;

import conway.structure.Grid;

/*
 * Il core di game of life
 * Non ha dipendenze da dispositivi di input/output
 * Non ha regole di controllo del gioco
 */

public class Life {
    //La struttura
    private int rows=0;
    private int cols=0;
    private static Grid grid;
    private static Grid nextGrid;

    public Life( int rowsNum, int colsNum) {
        this.rows   = rowsNum;
        this.cols   = colsNum;
        createGrids();   //crea la struttura a griglia
    }

    public int getRowsNum(){
        return rows;
    }
    public int getColsNum(){
        return cols;
    }

    public void createGrids() {
        grid = new Grid(rows, cols);
        nextGrid = new Grid(rows, cols);
        //CommUtils.outyellow("Life | initializeGrids done");
    }

    public Grid getGrid() {
    	return grid;
    }
    public void resetGrids() {
    	grid.killAllCells();
    	nextGrid.killAllCells();
        //CommUtils.outyellow("Life | initGrids done");
    }

    public void switchCellState(int row, int col) {
    	grid.switchCellAt(row, col);
    }

    private int countNeighborsLive(int row, int col) {
        int count = 0;
        
        if (row-1 >= 0) {
            if (grid.getStateOfCellAt(row-1, col)) {
				count++;
			}
        }
        if (row-1 >= 0 && col-1 >= 0) {
            if (grid.getStateOfCellAt(row-1, col-1)) {
				count++;
			}
        }
        if (row-1 >= 0 && col+1 < cols) {
            if (grid.getStateOfCellAt(row-1, col+1)) {
				count++;
			}
        }
        if (col-1 >= 0) {
            if (grid.getStateOfCellAt(row, col-1)) {
				count++;
			}
        }
        if (col+1 < cols) {
            if (grid.getStateOfCellAt(row, col+1)) {
				count++;
			}
        }
        if (row+1 < rows) {
            if (grid.getStateOfCellAt(row+1, col)) {
				count++;
			}
        }
        if (row+1 < rows && col-1 >= 0) {
            if (grid.getStateOfCellAt(row+1, col-1)) {
				count++;
			}
        }
        if (row+1 < rows && col+1 < cols) {
            if (grid.getStateOfCellAt(row+1, col+1)) {
				count++;
			}
        }
        return count;
    }



    protected void computeNextGen( ) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int n = countNeighborsLive(i,j);
                applyRules(i, j, n);
            }
        }
        //grid.displayGrid();
        copyAndResetGrid();
    }

    protected void copyAndResetGrid( ) {
        grid.CopyGrid(nextGrid);
        nextGrid.killAllCells();
    }

    protected void applyRules(int row, int col, int numNeighbors) {
        //int numNeighbors = countNeighborsLive(row, col);
        //CELLA VIVA
        if (grid.getStateOfCellAt(row, col)) {
            if (numNeighbors < 2) { //muore per isolamento
                nextGrid.killCellAt(row, col);
            } else if (numNeighbors == 2 || numNeighbors == 3) { //sopravvive
                nextGrid.reliveCellAt(row, col);
            } else if (numNeighbors > 3) { //muore per sovrappopolazione
                nextGrid.killCellAt(row, col);
            }
        }
        //CELLA MORTA
        else if (!grid.getStateOfCellAt(row, col)) {
            if (numNeighbors == 3) { //riproduzione
                nextGrid.reliveCellAt(row, col);
            }
        }
        //CommUtils.outgreen("Life applyRules " + nextGrid   );
    }
}

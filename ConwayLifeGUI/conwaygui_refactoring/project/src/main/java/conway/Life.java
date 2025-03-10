package conway;

import conway.structure.GridGUI;

/*
 * Il core di game of life
 * Non ha dipendenze da dispositivi di input/output
 * Non ha regole di controllo del gioco
 */

public class Life {
    //La struttura
    private int rows=0;
    private int cols=0;
    private static GridGUI grid;
    private static GridGUI nextGrid;
    private IOutDev outDev;

    public Life( int rowsNum, int colsNum, IOutDev outDev) {
        this.rows   = rowsNum;
        this.cols   = colsNum;
        this.outDev = outDev;
        createGrids();   //crea la struttura a griglia
    }

    public int getRowsNum(){
        return rows;
    }
    public int getColsNum(){
        return cols;
    }

    protected void  createGrids() {
        grid = new GridGUI(rows, cols, outDev);
        nextGrid = new GridGUI(rows, cols, outDev);
        //CommUtils.outyellow("Life | initializeGrids done");
    }

    protected void resetGrids() {
    	grid.killAllCells();
    	nextGrid.killAllCells();
        //CommUtils.outyellow("Life | initGrids done");
    }


    protected int countNeighborsLive(int row, int col) {
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
        grid.displayGrid();
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
    
    
    
    public void switchCellState(int i, int j) { //per il mock
    	grid.switchCellAt(i, j);
    }
}

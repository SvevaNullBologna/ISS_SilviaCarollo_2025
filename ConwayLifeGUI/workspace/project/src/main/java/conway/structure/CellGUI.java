package conway.structure;
import conway.IOutDev;

public class CellGUI extends Cell {

	public CellGUI() {
		super();
	}
	
	public CellGUI(Cell c) {
		this.isAlive = c.isAlive;
	}

	public void displayCell() {
		System.out.print(isAlive ? "1" : "0");
	}
	
	/*public static CellGUI toCellGUI(Cell c) {
		CellGUI cg =  new CellGUI();
		cg.copyCellState(c);
		return cg;
	}*/

}

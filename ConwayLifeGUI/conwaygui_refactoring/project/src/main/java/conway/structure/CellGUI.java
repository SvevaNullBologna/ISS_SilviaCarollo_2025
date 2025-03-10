package conway.structure;
import conway.IOutDev;

public class CellGUI extends Cell{

	private static IOutDev outDev;
	
	public CellGUI(IOutDev outDev) {
		super();
		CellGUI.outDev = outDev;
	}
	
	public CellGUI(Cell c, IOutDev outDev) {
		this.copyCellState(c);
		CellGUI.outDev = outDev;
	}

	public void displayCell() {
		outDev.displayCell(this.getState() ? "1" : "0");
	}

}

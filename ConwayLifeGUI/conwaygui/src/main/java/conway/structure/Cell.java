package conway.structure;

import conway.IOutDev;

public class Cell {
	private int x;
	private int y;
	private boolean isAlive;
	private IOutDev outDev;
	
	public Cell(int x, int y, IOutDev outDev) { 
		this.x = x;
		this.y = y;
		this.outDev = outDev;
		this.isAlive = false;
	}
	
	public Cell(Cell c) {
		this.copyCell(c);
	}

	
	public int  getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void killCell() {
		this.isAlive = false;
	}
	public void reliveCell() {
		this.isAlive = true;
	}
	
	public Boolean getState(){
		return isAlive;
	}
	
	public void copyCell(Cell c) {
		this.x = c.x;
		this.y = c.y;
		this.outDev = c.outDev;
		this.isAlive = c.isAlive;
	}
	
	public void copyCellState(Cell c) {
		this.isAlive = c.isAlive;
	}
	
	public void switchState() {
		this.isAlive = !this.isAlive;
	}
	
	public void displayCell() {
		outDev.display(this.getState() ? "1" : "0");
	}

}

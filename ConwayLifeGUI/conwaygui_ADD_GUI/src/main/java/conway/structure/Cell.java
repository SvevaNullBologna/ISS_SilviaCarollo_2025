package conway.structure;

public class Cell {
	private int x;
	private int y;
	private boolean isAlive;
	
	public Cell(int x, int y) { 
		this.x = x;
		this.y = y;
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
		this.isAlive = c.isAlive;
	}
	
	public void copyCellState(Cell c) {
		this.isAlive = c.isAlive;
	}
	
	public void switchState() {
		this.isAlive = !this.isAlive;
	}
	
}

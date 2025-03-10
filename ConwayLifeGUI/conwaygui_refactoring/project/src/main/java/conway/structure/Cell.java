package conway.structure;

class Cell {
	protected boolean isAlive;
	
	public Cell() { 
		this.isAlive = false;
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
	
	public void copyCellState(Cell c) {
		this.isAlive = c.isAlive;
	}
	
	public void switchState() {
		this.isAlive = !this.isAlive;
	}
}

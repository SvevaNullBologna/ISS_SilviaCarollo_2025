package conway;
import java.util.concurrent.TimeUnit;
import conway.structure.*;

public class LifeController {
    private int generationTime = 1000;
    private  Life life;
    private IOutDev outdev;
    private static boolean playing;

    public LifeController(Life game, IOutDev outdev){
        this.life = game;
        this.outdev = outdev;
        playing = false;
        configureTheSystem();
     }

   
    protected void configureTheSystem() {
		//CommUtils.outyellow("LifeController | doJob ");
		life.createGrids();
    }
    protected void play() {
    	int i = 0;
		while (playing) {
			try {
				TimeUnit.MILLISECONDS.sleep(generationTime);
				System.out.println("---------Epoch --- " + i );
				life.computeNextGen();
				//La griglia è visualizzata  'on the fly'
				displayGrid();
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
    
    private void displayGrid() {
    	Grid grid = life.getGrid();
    	for(int i=0; i<grid.getNumberOfRows(); i++) {
    		for(int j=0; j<grid.getNumberOfColumns(); j++) {
    			outdev.displayCell(grid.getCellAt(i, j));
    		}
    		outdev.display("\n");
    	}
    }
    
    
    
    public void startTheGame() {
    	playing = true;
    	play();
    }
    
    public void stopTheGame() {
    	playing = false;
    }

    public void exitTheGame() {
    	stopTheGame();
    	//close page
    	
    }

	public void clearTheGame() {
		life.resetGrids();
	}

	public void swithCellState(int i, int j) {
		life.switchCellState(i, j);
	}


}

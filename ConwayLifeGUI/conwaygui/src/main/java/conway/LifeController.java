package conway;
import java.util.concurrent.TimeUnit;
import conway.IOutDev;
import conway.structure.*;

public class LifeController {
    private int generationTime = 1000;
    private  Life life;
    private IOutDev outdev;

    public LifeController(Life game, IOutDev outdev){
        this.life = game;
        this.outdev = outdev;
        configureTheSystem();
     }

   
    protected void configureTheSystem() {
		//CommUtils.outyellow("LifeController | doJob ");
		life.createGrids();
    }

    //Called by ConwayInputMock
    public void start(){
		System.out.println("---------Initial----------");
		//La griglia è visualizzata con un ciclo
		displayGrid();
		play();
    }

    protected void play() {
    	int i = 0;
		while (true) {
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
    	
    }
    
    public void stopTheGame() {
    	
    }

    public void exitTheGame() {
    	
    }

	public void clearTheGame() {
	
	}

	public void swithCellState(int i, int j) {
		
	}


}

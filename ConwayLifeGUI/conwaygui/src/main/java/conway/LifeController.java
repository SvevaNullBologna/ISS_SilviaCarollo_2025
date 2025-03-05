package conway;
import java.util.concurrent.TimeUnit;


public class LifeController {
    private int generationTime = 1000;
    private  Life life;

    public LifeController(Life game){
        this.life = game;
        configureTheSystem();
     }

    public void display() {
    	life.displayGame();
    }
    
    protected void configureTheSystem() {
		//CommUtils.outyellow("LifeController | doJob ");
		life.createGrids();
    }

    //Called by ConwayInputMock
    public void start(){
		System.out.println("---------Initial----------");
		//La griglia è visualizzata con un ciclo
		//displayGrid();
		play();
    }

    protected void play() {
		//while (true) {
		for( int i=1;i<=5;i++){
			try {
				TimeUnit.MILLISECONDS.sleep(generationTime);
				System.out.println("---------Epoch --- "+i );
				life.computeNextGen();
				//La griglia è visualizzata  'on the fly'
				//displayGrid();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

package conway;

import conway.devices.ConwayInputMock;

public class MainConway  {

    public static void main(String[] args) {
    //sysUtil.aboutThreads("MainConway | STARTS " ); //Richiede dipendenze
    	//configureTheSystem
    	IOutDev mockOutputDevice = new MockOutDev();
        Life life           = new Life( 3,3, mockOutputDevice);
        LifeController cc   = new LifeController(life);
        ConwayInputMock cim = new ConwayInputMock(cc,life); //per simulare l'input
        //start the system
        cim.simulateUserControl();

    }

}
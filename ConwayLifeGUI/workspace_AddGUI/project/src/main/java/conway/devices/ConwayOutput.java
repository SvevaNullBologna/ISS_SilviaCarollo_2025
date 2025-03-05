package conway.devices;

import conway.IOutDev;

//
public class ConwayOutput implements IOutDev{


	@Override
	public void displayCell(String msg) {
		System.out.print(msg);
	}

}

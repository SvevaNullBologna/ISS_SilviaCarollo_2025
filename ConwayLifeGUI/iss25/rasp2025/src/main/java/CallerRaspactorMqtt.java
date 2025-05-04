package main.java;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.mqtt.MqttConnection;
import unibo.basicomm23.mqtt.MqttInteraction;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;

 
/*
 * La comunicazione avviene  a livello QakActor
 */
public class CallerRaspactorMqtt {

	protected IApplMessage sonarstart   = CommUtils.buildDispatch("callertcp", "sonarstart",  "sonarstart(1)",  "sonardevice");
	protected IApplMessage sonarstop  = CommUtils.buildDispatch("callertcp", "sonarstop", "sonarstop(1)", "sonardevice");
	
	public void doJob() {
		CommUtils.outblue("callermqtt STARTS"  );
        String brokerAddr       = "tcp://192.168.137.1:1883"; //"tcp://192.168.1.68:1883"; //"tcp://test.mosquitto.org:1883"; //"tcp://broker.hivemq.com:1883"; //
        ProtocolType protocol   = ProtocolType.mqtt;
        MqttInteraction conn = 
        		new MqttInteraction("callermqtt",brokerAddr, "sonarLed","unibo/qak/ctxsonar/sonardevice");
        addObservation( conn );
        
        try {
        	
        	CommUtils.outblue("callermqtt sonarstart"  );
       	 	conn.forward(sonarstart);
       	 	CommUtils.delay(3000);
        	CommUtils.outblue("callermqtt  sonarstop"  );
      	    conn.forward(sonarstop);
        	
       	    CommUtils.delay(3000);
       	    CommUtils.outmagenta("callermqtt | ENDS"   );
        	System.exit(0);
		} catch (Exception e) {
 			CommUtils.outred("callermqtt ERROR:" + e.getMessage() );
		}
	}
	
	protected void addObservation(Interaction conn) {
		new Thread() {
			public void run() {
				try {
					while(true) {
						String m = conn.receiveMsg();
						CommUtils.outmagenta("mqtt observed:" + m);
					}
				} catch (Exception e) {
					CommUtils.outred("callermqtt addObservation ERROR:" + e.getMessage() );
				}
				
			}
		}.start();
	}

	 public static void main( String[] args ){
		 new CallerRaspactorMqtt().doJob();
	 }
} 

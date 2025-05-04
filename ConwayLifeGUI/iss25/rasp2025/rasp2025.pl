%====================================================================================
% rasp2025 description   
%====================================================================================
mqttBroker("192.168.137.1", "1883", "sonar/events").
dispatch( sonarstart, sonarstart(X) ).
dispatch( sonarstop, sonarstop(X) ).
event( sonardata, distance(D) ).
%====================================================================================
context(ctxsonar, "localhost",  "TCP", "8080").
 qactor( sonardevice, ctxsonar, "it.unibo.sonardevice.Sonardevice").
 static(sonardevice).

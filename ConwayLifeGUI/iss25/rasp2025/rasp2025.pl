%====================================================================================
% rasp2025 description   
%====================================================================================
mqttBroker("192.168.137.1", "1883", "sonar/events").
dispatch( sonarstart, sonarstart(X) ).
dispatch( sonarstop, sonarstop(X) ).
dispatch( ledon, ledon(X) ).
dispatch( ledoff, ledoff(X) ).
event( sonardata, distance(D) ).
%====================================================================================
context(ctxsonar, "localhost",  "TCP", "8080").
 qactor( sonardevice, ctxsonar, "it.unibo.sonardevice.Sonardevice").
 static(sonardevice).
  qactor( sonarobserver, ctxsonar, "it.unibo.sonarobserver.Sonarobserver").
 static(sonarobserver).
  qactor( sonarreactor, ctxsonar, "it.unibo.sonarreactor.Sonarreactor").
 static(sonarreactor).

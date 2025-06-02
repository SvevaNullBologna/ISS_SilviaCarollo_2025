%====================================================================================
% unibomapbuild25 description   
%====================================================================================
dispatch( halt, halt(X) ).
dispatch( move, move(M) ). %M = w|s|a|d|p   mosse aril
request( cmd, cmd(MOVE,T) ). %MOVE = w|s|a|d|p   mosse del virtual robot
reply( cmddone, cmddone(R) ).  %%for cmd
reply( cmdfailed, cmdfailed(T,CAUSE) ).  %%for cmd
dispatch( vrinfo, vrinfo(SOURCE,INFO) ).
event( sonarval, distance(DISTANCE) ). %emesso in out
event( sonardata, sonar(DISTANCE) ). %emesso dal SONAR
request( step, step(TIME) ).
reply( stepdone, stepdone(V) ).  %%for step
reply( stepfailed, stepfailed(DURATION,CAUSE) ).  %%for step
dispatch( init, init(DREAMING) ). %DREAMING=true=>non real move
%====================================================================================
context(ctxmapbuild, "localhost",  "TCP", "8125").
 qactor( robotservice, ctxmapbuild, "it.unibo.robotservice.Robotservice").
 static(robotservice).
  qactor( mapbuilder, ctxmapbuild, "it.unibo.mapbuilder.Mapbuilder").
 static(mapbuilder).

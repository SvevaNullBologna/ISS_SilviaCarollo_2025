### conda install diagrams
from diagrams import Cluster, Diagram, Edge
from diagrams.custom import Custom
import os
os.environ['PATH'] += os.pathsep + 'C:/Program Files/Graphviz/bin/'

graphattr = {     #https://www.graphviz.org/doc/info/attrs.html
    'fontsize': '22',
}

nodeattr = {   
    'fontsize': '22',
    'bgcolor': 'lightyellow'
}

eventedgeattr = {
    'color': 'red',
    'style': 'dotted'
}
evattr = {
    'color': 'darkgreen',
    'style': 'dotted'
}
with Diagram('unibomapbuild25Arch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxmapbuild', graph_attr=nodeattr):
          robotservice=Custom('robotservice','./qakicons/symActorWithobjSmall.png')
          mapbuilder=Custom('mapbuilder','./qakicons/symActorWithobjSmall.png')
     sys >> Edge( label='sonardata', **evattr, decorate='true', fontcolor='darkgreen') >> robotservice
     robotservice >> Edge( label='sonarval', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     mapbuilder >> Edge(color='magenta', style='solid', decorate='true', label='<step<font color="darkgreen"> stepdone stepfailed</font> &nbsp; >',  fontcolor='magenta') >> robotservice
     mapbuilder >> Edge(color='blue', style='solid',  decorate='true', label='<init &nbsp; move &nbsp; >',  fontcolor='blue') >> robotservice
diag

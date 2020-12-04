import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Game {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph graph = new Graph();
	    graph.addVertex(1,1);
	    graph.addVertex(2,2);
	    graph.addVertex(-1,3);
	    graph.addVertex(-1,4);
	    graph.addVertex(-1,5);
	    Edge e12 = new Edge(graph.getNodes().get(0), graph.getNodes().get(1), 1); // create an edge that connects node1 to node2 
	    Edge e13 = new Edge(graph.getNodes().get(0), graph.getNodes().get(2), 2); 
	    Edge e23 = new Edge(graph.getNodes().get(1), graph.getNodes().get(2), 3); 
	    graph.addEdge(e12);
	    graph.addEdge(e13);
	    graph.addEdge(e23);
//	    System.out.println(graph.getNodes());
//	    System.out.println(graph.getEdges());
//	    graph.getNodes().get(0).printNeighbours();
//	    graph.removeVertex(3);
//	    graph.getNodes().get(0).printNeighbours();
//	    System.out.println(graph.getNodes());
//	    System.out.println(graph.getEdges());
//	    graph.addDollars(graph.getNodes().get(0));
	    graph.getNodes().size();
	    
	    
	    Gui gui = new Gui();
	    JFrame jf = gui.buildFrame();

	    List<JButton> jbutts = gui.makeButtons(graph);
	    
	    
	    for(JButton jb: jbutts) {
	    	jf.add(jb);	    		    	
	    }
	    for(JButton jb: jbutts) {
	    	gui.placeButtons(jf, jb);   		    	
	    }
	    
	    EdgesPanel ep = new EdgesPanel();
	    for(Edge v: graph.getEdges()) {
	    	int[] vers = gui.drawEdges(v.getStart(),v.getEnd());
	    	ep.addLine(vers[0], vers[1], vers[2], vers[3]);
	    }
	    
	    jf.getContentPane().add(ep);
	    
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.setVisible(true);
	    
	    
	    Timer t = new Timer();
	    t.schedule(new TimerTask() {
	        @Override
	        public void run() {
	        	for (Vertex name : gui.buttonPlace.keySet())  
	                gui.buttonPlace.get(name).setText(Integer.toString(name.value));
	        }
	    }, 0, 1500);
	    
	}	
}


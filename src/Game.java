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
	    graph.getNodes().get(0);
	    Edge e12 = new Edge(graph.getNodes().get(0), graph.getNodes().get(1), 1); // create an edge that connects node1 to node2 and contains weight of 5
	    Edge e13 = new Edge(graph.getNodes().get(0), graph.getNodes().get(2), 2); 
	    graph.getNodes().get(0).addNeighbour(e12);
	    graph.getNodes().get(0).addNeighbour(e13);
	    graph.getNodes().get(1).addNeighbour(e12);
	    graph.getNodes().get(2).addNeighbour(e13);
	    graph.addEdge(e12);
	    graph.addEdge(e13);
//	    System.out.println(graph.getNodes());
//	    System.out.println(graph.getEdges());
//	    graph.getNodes().get(0).printNeighbours();
//	    graph.removeVertex(3);
//	    graph.getNodes().get(0).printNeighbours();
//	    System.out.println(graph.getNodes());
//	    System.out.println(graph.getEdges());
	    graph.addDollars(graph.getNodes().get(0));
	    
	    for(Vertex vert: graph.getNodes()) {
	    	System.out.println(vert);
	    }
	    
//	    graph.getNodes().size();
	    
	    Gui gui = new Gui();
	    JFrame jf = gui.buildFrame();
	    jf.add(gui.makeButton(graph.getNodes().get(0),graph));
	    jf.setVisible(true);
	    System.out.println(jf.getComponent(0).getHeight() +" "+ jf.getComponent(0).getWidth()+" "+
	    		jf.getComponent(0).getX()+" "+ jf.getComponent(0).getY());
	    
	}	
}

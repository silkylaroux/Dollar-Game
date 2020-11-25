import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Graph {
	
	private List<Vertex> nodes = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();
	
	void addVertex(int val, int id) {
		getNodes().add(new Vertex(val,id));
	}
	 
	void removeVertex(int id) {
	    Vertex v = new Vertex(0,id);
	    for(Vertex vert: getNodes()) {
	    	ListIterator<Edge> it = vert.getNeighbours().listIterator();
    	    while (it.hasNext()) {
    	        Edge b = it.next();
    	        
    	        if(b.getEnd().equals(v) || b.getStart().equals(v) ) {
    	    		it.remove();
    	    	}
    	    }
	    	
	    }
	    
	    for(Vertex vert: getNodes()) {
	    	if(vert.equals(v)) {
	    		getNodes().remove(vert);
	    		break;
	    	}
	    }
	    
	    ListIterator<Edge> it = getEdges().listIterator();
	    while (it.hasNext()) {
	        Edge b = it.next();
	        
	        if(b.getEnd().equals(v) || b.getStart().equals(v) ) {
	    		it.remove();
	    	}
	    }
	    
	}
	
	void addDollars(Vertex v) {
		v.getNeighbours();
	}
	
	void addEdge(Edge ed) {
		getEdges().add(ed);
	}

	public List<Vertex> getNodes() {
		return nodes;
	}

	public void setNodes(List<Vertex> nodes) {
		this.nodes = nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	
	

}

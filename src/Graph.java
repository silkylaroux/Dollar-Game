import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Graph {
	
	private List<Vertex> nodes = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();
	private Map<Vertex,Integer> nodeLocation = new HashMap<Vertex,Integer>();
	private int location;
	
	public Graph() {
		location = 0;
	}
	
	void addVertex(int val, int id) {
		getNodes().add(new Vertex(val,id));
		nodeLocation.putIfAbsent(getNodes().get(location), location);
		location++;
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
		System.out.println(v);
		ListIterator<Edge> it = v.getNeighbours().listIterator();
		int decreaseCount = 0;
	    while (it.hasNext()) {
	        Edge b = it.next();
	        System.out.println(b);
	        if(b.getEnd().equals(v) && !b.getStart().equals(v) ) {
	    		b.getStart().increaseValue();
	    	}else if(b.getStart().equals(v) && !b.getEnd().equals(v) ) {
	    		b.getEnd().increaseValue();
	    	}
    		decreaseCount++;
	    }
	    for(int x = 0; x < decreaseCount; x++) {
	    	v.decreaseValue();
	    }
	}
	
	public boolean won() {
		if(getNodes()==null) {
			return false;
		}
		for(Vertex vert: getNodes()) {
			if(vert.value<0) {
				return false;
			}
		}
		return true;
	}
	
	
	void addEdge(Edge ed) {
		
		boolean ed1 = getNodes().get(getNodeLocation().get(ed.getStart())).addNeighbour(ed);
		boolean ed2 = getNodes().get(getNodeLocation().get(ed.getEnd())).addNeighbour(ed);
		if(ed1 && ed2) {
			getEdges().add(ed);
		}
	}

	public List<Vertex> getNodes() {
		return nodes;
	}

	/**
	 * @return the nodeLocation
	 */
	public Map<Vertex, Integer> getNodeLocation() {
		return nodeLocation;
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

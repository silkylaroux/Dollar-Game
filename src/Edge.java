
/**
 * @author DNA
 * This is used to hold the data on the edges of the graph.
 * An edge has an ID, a vertex for start and end of it, I could probably change this to work better.
 *
 */
public class Edge {
	private Vertex start;
    private Vertex end;
    private int id;
    public int getId() {
        return this.id;
    }
    public Vertex getStart() {
        return this.start;
    }
    public int getIdOfStartNode() {
        return this.start.getVertId();
    }
    public Vertex getEnd() { 
        return this.end; 
    }
    public int getIdOfEndNode() {
        return this.end.getVertId();
    }

    public Edge(Vertex s, Vertex e, int id) {
        this.start = s;
        this.end = e;
        this.id = id;
    }
    
    @Override
    public String toString() { 
        return String.format(" edgeId: "+id + " Start: " + start.id+ " End: "+ end.id+ " "); 
    }
    
    @Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Edge)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Edge c = (Edge) o; 
        if( (start.equals(c.start) && end.equals(c.end))
        		|| (start.equals(c.end) && end.equals(c.start)) ) {
        	return true;
        }
        // Compare the id's of the edges and return. 
        return id == c.id;
    } 
}

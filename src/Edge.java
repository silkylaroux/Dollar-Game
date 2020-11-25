
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
        if (!(o instanceof Vertex)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Edge c = (Edge) o; 
          
        // Compare the data members and return accordingly  
        return id == c.id;
    } 
}

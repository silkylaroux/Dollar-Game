import java.util.ArrayList;
import java.util.List;

public class Vertex {

	int value;
	int id;
	private List<Edge> neighbours = new ArrayList<Edge>();
	
	public Vertex(int val, int i) {
		value = val;
		id = i;
	}

	public boolean isPositive() {
		return value > 0;
	}
	
	public int getVertId() {
        return this.id;
    }
	
	public void increaseValue() {
		value++;
	}
	
	public void decreaseValue() {
		value--;
	}
	
    public void addNeighbour(Edge e) {
        if(this.neighbours.contains(e)) {
            System.out.println("This edge has already been used for this node.");
        } else {
            System.out.println("Successfully added " + e);
            this.neighbours.add(e);
        }
    }
    
    public void printNeighbours() {
    	System.out.println("List of all edges that node " + this.id +" has: ");
        System.out.println("=================================");
        for (int i = 0; i < this.neighbours.size(); i++ ){
            System.out.println("ID of Edge: " + neighbours.get(i).getId() + "\nID of the first node: " + neighbours.get(i).getIdOfStartNode() + 
            "\nID of the second node: " + neighbours.get(i).getIdOfEndNode());
            System.out.println();
        }
        System.out.println(neighbours);
    }
    
    public List<Edge> getNeighbours() {
        
        return neighbours;
    }
    
    @Override
    public String toString() { 
        return String.format("id: "+id + " value: " + value); 
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
        Vertex c = (Vertex) o; 
          
        // Compare the data members and return accordingly  
        return id == c.id;
    } 

}

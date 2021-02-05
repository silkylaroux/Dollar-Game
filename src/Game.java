import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game {
	public Graph graph;
	
	public Game() {
		graph = new Graph();
	}
	
	public void generateVertices(int amount) {
		Random rand = new Random();
		
		for(int x = 0; x< amount; x++) {
			int val = rand.nextInt(7) - 3;
			graph.addVertex(val, x);
		}
	}
	
	public void generateEdges() {
		int id =0;
		Random rand = new Random();
		Integer[] placesInList = new Integer[graph.getNodes().size()];
		System.out.println("idk");
		System.out.println(graph.getNodes().size());
		for(int x = 0; x < graph.getNodes().size(); x++) {
			placesInList[x]= x;
		}

		List<Integer> intList = Arrays.asList(placesInList);
		Collections.shuffle(intList);
		
		for(int x = 0; x <intList.size()-1; x+=2) {
			graph.addEdge(newEdge(graph.getNodes().get(x), graph.getNodes().get(x+1),id));
			id++;
		}
		
		for(int x = 0; x < graph.getNodes().size(); x++) {
			int val = rand.nextInt(2-1)+1;
			int temp = 2;
			for(int y = 0; y < val; y++) {
				if((x+temp) >= placesInList.length-1) {
					graph.addEdge(newEdge(graph.getNodes().get(x),graph.getNodes().get(0+temp),id));
					id++;
				}else {
					graph.addEdge(newEdge(graph.getNodes().get(x),graph.getNodes().get(x+temp),id));
					id++;
				}
				temp++;
			}
		}
	}
	
	public Edge newEdge(Vertex v1, Vertex v2, int id) {
		return new Edge(v1,v2,id);
	}
	
	public void rerun(Gui gui1) {
		if(gui1.buildWinScreen()) {
			Game game;
			Gui gui;
			JFrame jf;
			int pointCount;
			EdgesPanel ep;
			List<JButton> jbutts;
			game = new Game();
			graph = game.graph;
		    System.out.println("newGraph");
		    System.out.println(graph.getNodes().size());
		    
		    gui = new Gui();
		    
		    jf = gui.buildFrame();
		    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		    
		    
		    pointCount = gui.makePoints(jf);
		    game.generateVertices(pointCount);
			game.generateEdges();
			
		    
		    jbutts = gui.makeButtons(graph);
		    
		    
		    for(JButton jb: jbutts) {
		    	jf.add(jb);	    		    	
		    }
		    for(JButton jb: jbutts) {
		    	gui.placeButtons(jf, jb);   		    	
		    }
		    
		    ep = new EdgesPanel();
		    for(Edge v: graph.getEdges()) {
		    	int[] vers = gui.drawEdges(v.getStart(),v.getEnd());
		    	ep.addLine(vers[0], vers[1], vers[2], vers[3]);
		    }
		    
		    jf.getContentPane().add(ep);
		    jf.setVisible(true);
		    Timer t = new Timer();
		    t.schedule(new TimerTask() {
		        @Override
		        public void run() {
		        	for (Vertex name : gui.buttonPlace.keySet())  
		                gui.buttonPlace.get(name).setText(Integer.toString(name.value));
		        	if(graph.won()) {
		        		t.cancel();
		        		jf.dispose();
		        		game.rerun(gui);
		        	}
		        }
		    }, 0, 1000);
		 
		}else {
			System.exit(0);
		}
	}

	
	public static void main(String[] args) {
		Gui gui = new Gui();
		Game game = new Game();
		game.rerun(gui);    
	    
	}	
}
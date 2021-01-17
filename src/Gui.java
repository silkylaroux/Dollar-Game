import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Gui{
	public Map<Vertex,JButton> buttonPlace;
	
	public Gui() {
		buttonPlace = new HashMap<Vertex,JButton>();
	}
	
	public int makePoints(JFrame jf) {
		Object[] possibilities = {"3","4","5","6","7","8","9","10"};
		String s = (String)JOptionPane.showInputDialog(
		                    jf,
		                    "Choose how many buttons:\n",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    "ham");

		//If a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
		    return (int)Integer.valueOf(s);
		}
		return -1;
	}
	
	public List<JButton> makeButtons(Graph g){
		List<Vertex> nodes = g.getNodes();
		List<JButton> jbutts = new ArrayList<JButton>();
		for(int x=0; x <nodes.size(); x++) {
			JButton newButt = makeButton(nodes.get(x),g);
			newButt.setBackground(randomColor());
			newButt.setOpaque(true);
			jbutts.add(newButt);
			buttonPlace.putIfAbsent(nodes.get(x),newButt);
		}
		return jbutts;
	}
	
	public Color randomColor() {
		Random random = new Random();
		int randomNumber = random.nextInt(3);
		String[] colors = {"#ffcce7","#daf2dc", "#81b7d2"};
		return Color.decode(colors[randomNumber]);
		
	}
	
	public void placeButtons(JFrame jf, JButton jb) {
		Random random = new Random();

		for (int tries = 0; tries < 250; tries++) {
            if (intersectsComponent(jb, jf.getContentPane().getComponents())) {
                jb.setLocation(random.nextInt(jf.getSize().width-70), random.nextInt(jf.getSize().height-70));
//                jb.setLocation(random.nextInt(1080), random.nextInt(900));
            } else {
            	//buttonPlace.put( value)
                jf.add(jb);
                break;
            }
    	}
	}
	
	public int[] drawEdges(Vertex start, Vertex end) {
		int x1 = (int) buttonPlace.get(start).getLocation().getX();
		int x2 = (int) buttonPlace.get(end).getLocation().getX();
		
		int y1 = (int) buttonPlace.get(start).getLocation().getY();
		int y2 = (int) buttonPlace.get(end).getLocation().getY();
		return new int[] {x1,y1,x2,y2};
		
	}
		
	public static boolean intersectsComponent(Component component, Component[] components) {
        for (Component c : components) {
            if (c.getBounds().intersects(component.getBounds())) {
                return true;
            }
        }
        return false;
    }
	

	public JButton makeButton(Vertex v, Graph g) {
		ActionListenerExample newListener = new ActionListenerExample( v,  g);
		newListener.makeButton();
	    return newListener.butt;
	}
	
	public JFrame buildFrame() {
		 JFrame f=new JFrame("Dollar Game"); 
		 f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		 f.setSize(1920,1080);
		 f.setLocationRelativeTo(null);
	    return f;
	}
	
	
}

class ActionListenerExample implements ActionListener{
	JButton butt;
	Graph graph;
	Vertex vertex;
	
	public JButton makeButton() {
		String buttonValue = Integer.toString(vertex.value);
		JButton b1 = new JButton(buttonValue);
		b1.addActionListener(this);
		b1.setSize(50, 50);
		butt = b1;
	    return butt;
	}
	
	ActionListenerExample(Vertex v, Graph g){
		graph = g;
		vertex = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		graph.addDollars(vertex);
		String buttonValue = Integer.toString(vertex.value);
		butt.setText(buttonValue);
	}
	
}

class EdgesPanel extends JPanel{
	private final ArrayList<Line> lines = new ArrayList<Line>();

    public void addLine(int x1, int y1, int x2, int y2) {
        this.lines.add(new Line(x1+25, y1+25, x2+25, y2+25));
    }
	
	@Override
	public void paintComponent(Graphics g) {
		((Graphics2D)g).setStroke(new BasicStroke(3));
        for(final Line r : lines) {
            r.paint(g);
        }
    }
    
}


class Line {
    public final int x1;
    public final int x2;
    public final int y1;
    public final int y2;
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void paint(Graphics g) {
        g.drawLine(this.x1, this.y1, this.x2, this.y2);
    }
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Gui {
//	private void changeButtonPlace(JButton button) {
//=	    Random r = new Random();
//	    int newXloc = r.nextInt(getScreenWidth() - (2 * button.getWidth()));
//	    int newYloc = r.nextInt(getScreenHeight() - (3 * button.getHeight()));
//	    button.setX(newXloc);
//	    button.setY(newYloc);
//	}
	
	public JButton makeButton(Vertex v, Graph g) {
		ActionListenerExample newListener = new ActionListenerExample( v,  g);
		newListener.makeButton();
	    return newListener.butt;
	}
	
	public JFrame buildFrame() {
		 JFrame f=new JFrame("Button Example");  
	    f.setSize(400,400);  
	    f.setLayout(null);
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
		b1.setBounds(50,100,95,30);
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
		butt.setVisible(false);
		butt.setVisible(true);
	}
	
}

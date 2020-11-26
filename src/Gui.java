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
	
	public JButton makeButton(Vertex v ) {
		String buttonValue = Integer.toString(v.value);
		JButton b1 = new JButton(buttonValue);
		b1.setBounds(50,100,95,30);
	    return b1;
	}
	
	public JFrame buildFrame() {
		 JFrame f=new JFrame("Button Example");  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    return f;
	}
	
	
}

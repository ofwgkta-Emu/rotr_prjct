import javax.swing.JFrame;

public class Frame
{
    public static void main(String [] args)
	{
	    JFrame frame=new JFrame("Rage on the road v.1.0.2");
	    frame.add(new Board());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setSize(500,500);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
}

/**
 * This program gives UI that calculates the pizze price based on the size and topping selected
 * @author Guan Yue Wang
 *
 */


import javax.swing.*;

public class PizzaOrderFrame extends JFrame
{
	public PizzaOrderFrame()
	{
		setTitle( "Check Pizza Price" );
		setSize( 300, 250 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		JPanel panel = new PizzaOrderPanel();
		this.add( panel );
	}
	
	
	public static void main(String[] args) 
	{
		JFrame frame = new PizzaOrderFrame();
		frame.setVisible( true );

	}

}

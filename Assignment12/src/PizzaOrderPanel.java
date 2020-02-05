/**
 * This program constructs the pizza order program user interface
 * @author Guan Yue Wang
 *
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;



public class PizzaOrderPanel extends JPanel
{
	// declare buttons for pizza sizes and toppings
	private JRadioButton smallPizzaButton, mediumPizzaButton, largePizzaButton;
	private JCheckBox plainCheckBox, sausageCheckBox, mushroomCheckBox, pepperoniCheckBox;
	private JTextField priceField;
	private double price;
	
	
	public PizzaOrderPanel()
	{
		// Create ActionListener for the panel
		ActionListener listener = new PanelListener();

		// create radio buttons for pizza sizes
		
		smallPizzaButton = new JRadioButton( "Small" );
		mediumPizzaButton = new JRadioButton( "Medium" );
		largePizzaButton = new JRadioButton( "Large" );


		
		// create button group for pizza size
		ButtonGroup sizeGroup = new ButtonGroup();
		
		// add size button to size group
		sizeGroup.add( smallPizzaButton );
		sizeGroup.add( mediumPizzaButton );
		sizeGroup.add( largePizzaButton );
		
		// Create a button border
		Border buttonBorder = BorderFactory.createEtchedBorder();
		buttonBorder = BorderFactory.createTitledBorder( buttonBorder, "Pizza Size" );
		
		// Create a button panel and add pizza size buttons to the panel
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		smallPizzaButton.addActionListener(listener);
		mediumPizzaButton.addActionListener(listener);
		largePizzaButton.addActionListener(listener);
		buttonPanel.add( smallPizzaButton );
		buttonPanel.add( mediumPizzaButton );
		buttonPanel.add( largePizzaButton );
		buttonPanel.setBorder( buttonBorder );

		// Create check boxes for pizza toppings
		plainCheckBox = new JCheckBox( "Plain" );
		sausageCheckBox = new JCheckBox( "Sausage" );
		mushroomCheckBox = new JCheckBox( "Mushroom" );
		pepperoniCheckBox = new JCheckBox( "Pepperoni" );
	
		
		// Create a border for toppings group
		Border toppingBorder = BorderFactory.createEtchedBorder();
		toppingBorder = BorderFactory.createTitledBorder( toppingBorder,"Toppings" );
		
		// Create a toppings panel & add toppings check boxes
		JPanel toppingPanel = new JPanel();
		toppingPanel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		plainCheckBox.addActionListener(listener);
		sausageCheckBox.addActionListener(listener);
		mushroomCheckBox.addActionListener(listener);
		pepperoniCheckBox.addActionListener(listener);
		toppingPanel.add( plainCheckBox );
		toppingPanel.add( sausageCheckBox );
		toppingPanel.add( mushroomCheckBox );
		toppingPanel.add( pepperoniCheckBox );
		toppingPanel.setBorder( toppingBorder );
		
		
		
		// Create price field
		priceField = new JTextField(5);
	    priceField.setEditable(false);
	    priceField.setText("0");
		
		// Create a border for price panel
		Border priceBorder = BorderFactory.createEtchedBorder();
		priceBorder = BorderFactory.createTitledBorder( priceBorder,"Price" );
		
		// Create a price panel and add the text field
		
		JPanel pricePanel = new JPanel();
		pricePanel.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		pricePanel.add(priceField);
		pricePanel.setBorder( priceBorder);
		
		
		
		
		// Add panels to main panel
		this.setLayout( new BorderLayout() );
		this.add( buttonPanel, BorderLayout.NORTH );
		this.add( toppingPanel, BorderLayout.CENTER );
		this.add( pricePanel, BorderLayout.SOUTH );

	}
	
	/**
	 * This class constructs action listener
	 * @author Guan Yue Wang
	 *
	 */
	public class PanelListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{	
			price = 0;
			
			// add size price to the total price
			
			if (smallPizzaButton.isSelected())
			{
				price +=10.95;
			}
			else if (mediumPizzaButton.isSelected())
			{
				price +=13.95;
			}
			else if (largePizzaButton.isSelected())
			{
				price +=16.95;
			}
			
			// add topping price to the total price
			if (sausageCheckBox.isSelected())
			{
				price +=1;
			}
			
			if (pepperoniCheckBox.isSelected())
			{
				price +=1;
			}
			
			if (mushroomCheckBox.isSelected())
			{
				price +=1;
			}
			
			// set price and refresh the panel
			
			priceField.setText(" $ " + price);
			repaint();
			
			
			
		}
		
		
	}
	
}

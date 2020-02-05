/**
 * This class constructs the song database program user interface
 * @author Guan Yue Wang
 *
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;


public class SongDatabaseFrame extends JFrame implements ActionListener
{
	// declare output file location
	String outputFile;
	// declare array list to store song list
	private ArrayList<Song>newSongList;
	// create combobox for song descriptions
	private JComboBox<Song> songComboBox = new JComboBox<Song>();
	// create labels
	private JLabel selectSongLabel = new JLabel ("Select Song:");
	private JLabel itemCodeLabel = new JLabel ("ItemCode:");
	private JLabel descriptionLabel = new JLabel ("Description");
	private JLabel artistLabel = new JLabel ("Artist:");
	private JLabel albumLabel = new JLabel ("Album:");
	private JLabel priceLabel = new JLabel ("Price:");
	// create text fields
	private JTextField itemCodeField = new JTextField (25);
	private JTextField descriptionField = new JTextField (25);
	private JTextField artistField = new JTextField (25);
	private JTextField albumField = new JTextField (25);
	private JTextField priceField = new JTextField (25);
	// create buttons
	private JButton addButton = new JButton ("Add");
	private JButton editButton = new JButton ("Edit");
	private JButton deleteButton = new JButton ("Delete");
	private JButton acceptButton = new JButton ("Accept");
	private JButton cancelButton = new JButton ("Cancel");
	private JButton exitButton = new JButton ("Exit");
	// create panels
	private JPanel selectSongPanel = new JPanel();
	private JPanel itemCodePanel = new JPanel();
	private JPanel descriptionPanel = new JPanel();
	private JPanel artistPanel = new JPanel();
	private JPanel albumPanel = new JPanel();
	private JPanel pricePanel = new JPanel();
	private JPanel editPanel = new JPanel();
	private JPanel confirmPanel = new JPanel();
	private JPanel exitPanel = new JPanel();
	// declare add/edit check
	boolean isNewSong;
	
	
	/**
	 * Song Database Frame Constructor
	 * @param currentSongList	current song list in the database
	 * @param filePath			file path of the song database file
	 */
	
	public SongDatabaseFrame(ArrayList<Song> currentSongList, String filePath)
	{
		
		outputFile = filePath;	// get output file path
		
		newSongList = new ArrayList<Song>();	//declare array list to store songs
		
		for (Song aSong : currentSongList)
		{	// take song from current list to new song list and combo box
			newSongList.add(aSong);
			songComboBox.addItem(aSong);
		}
		// add combobox section to a panel
		selectSongPanel.add(selectSongLabel);
		selectSongPanel.add(songComboBox);
		// add item code section to a panel
		itemCodePanel.add(itemCodeLabel);
		itemCodePanel.add(itemCodeField);
		// add description section to a panel
		descriptionPanel.add(descriptionLabel);
		descriptionPanel.add(descriptionField);
		// add artist section to a panel
		artistPanel.add(artistLabel);
		artistPanel.add(artistField);
		// add album section to a panel
		albumPanel.add(albumLabel);
		albumPanel.add(albumField);
		// add price section to a panel
		pricePanel.add(priceLabel);
		pricePanel.add(priceField);
		// add modification buttons to a panel
		editPanel.add(addButton);
		editPanel.add(editButton);
		editPanel.add(deleteButton);
		// add confirm buttons to a panel
		confirmPanel.add(acceptButton);
		confirmPanel.add(cancelButton);
		// add exit buttons section to a panel
		exitPanel.add(exitButton);
		// add all panels to layouts
		this.setLayout(new FlowLayout());
		this.add(selectSongPanel);
		this.add(itemCodePanel);
		this.add(descriptionPanel);
		this.add(artistPanel);
		this.add(albumPanel);
		this.add(pricePanel);
		this.add(editPanel);
		this.add(confirmPanel);
		this.add(exitPanel);
		
		// get selected song
		Song selectedSong = (Song) songComboBox.getSelectedItem();
		// display selected song info
		displaySongInfo(selectedSong);
		// set buttons
		acceptButton.setEnabled(false);
		cancelButton.setEnabled(false);
		// add action listeners
		songComboBox.addActionListener(this);
		addButton.addActionListener(this);
		editButton.addActionListener(this);
		deleteButton.addActionListener(this);
		acceptButton.addActionListener(this);
		cancelButton.addActionListener(this);
		exitButton.addActionListener(this);
		
	}
	
	/**
	 * Action Performer
	 */
	
	public void actionPerformed (ActionEvent e)
	{	
		Object source = e.getSource();	// get sourse
		Song selectedSong;

		if (source == songComboBox) 
		{	// if user select combo box
			selectedSong = (Song) songComboBox.getSelectedItem();
			displaySongInfo(selectedSong);	// display song information
		}

		else if (source == addButton) 
		{	// if user click add button
			isNewSong = true;	// confirm it's new song
			// reset all fields
			itemCodeField.setText("");
			descriptionField.setText("");
			artistField.setText("");
			albumField.setText("");
			priceField.setText("0");

			itemCodeField.setEnabled(true);
			descriptionField.setEnabled(true);
			artistField.setEnabled(true);
			albumField.setEnabled(true);
			priceField.setEnabled(true);

			addButton.setEnabled(false);
			editButton.setEnabled(false);
			deleteButton.setEnabled(false);

			acceptButton.setEnabled(true);
			cancelButton.setEnabled(true);
		       }

		else if (source == editButton) 
		{	// if user click edit button
			isNewSong = false;	// confirm it's not new song

			descriptionField.setEnabled(true);
			artistField.setEnabled(true);
			albumField.setEnabled(true);
			priceField.setEnabled(true);

			addButton.setEnabled(false);
			editButton.setEnabled(false);
			deleteButton.setEnabled(false);

			acceptButton.setEnabled(true);
			cancelButton.setEnabled(true);
		}

		else if (source == deleteButton) 
		{	// if user click delete button
			
			// remove song from the array list
			newSongList.remove((Song) songComboBox.getSelectedItem());
			
			// remove song from the combo box
			int removeIndex = songComboBox.getSelectedIndex();
			songComboBox.removeItemAt(removeIndex);
			
			// reset view and display the first song
			songComboBox.setSelectedIndex(0);
			Song firstSong = (Song) songComboBox.getSelectedItem();
			displaySongInfo(songComboBox.getItemAt(0));
			
		}

		else if (source == acceptButton) 
		{	// if user click accept button
			
			
			if (isNewSong == true)
			{	// if it's adding new song
				// create new song object
				Song newSong = new Song(itemCodeField.getText(), descriptionField.getText(), artistField.getText(),
						albumField.getText(), Double.parseDouble(priceField.getText()));
				// add new song to array list
				newSongList.add(newSong);
				
				// add new song to combo box
				songComboBox.addItem(newSong);
				songComboBox.setSelectedIndex(newSongList.size() - 1);
				
				selectedSong = (Song) songComboBox.getSelectedItem();
				displaySongInfo(selectedSong);


			}
			
			else
			{	// if it's editing old song
				
				selectedSong = (Song) songComboBox.getSelectedItem();
				
				// check and update field value to song object
				
				if (!selectedSong.getDescription().equalsIgnoreCase(descriptionField.getText()))
				{
					selectedSong.setDescription(descriptionField.getText());
				}
				if (!selectedSong.getArtist().equalsIgnoreCase(artistField.getText()))
				{
					selectedSong.setArtist(artistField.getText());
				}
				if (!selectedSong.getAlbum().equalsIgnoreCase(albumField.getText()))
				{
					selectedSong.setAlbum(albumField.getText());
				}

				if (selectedSong.getPrice() != (Double.parseDouble(priceField.getText())))
				{
					selectedSong.setPrice(Double.parseDouble(priceField.getText()));
				}
				displaySongInfo(selectedSong);
				
			}
			
			acceptButton.setEnabled(false);
			cancelButton.setEnabled(false);

			addButton.setEnabled(true);
			editButton.setEnabled(true);
			deleteButton.setEnabled(true);
			
		} 
		else if (source == cancelButton) 
		{	// if user click cancel button
			isNewSong = false;
			selectedSong = (Song) songComboBox.getSelectedItem();
			displaySongInfo(selectedSong);
			
			acceptButton.setEnabled(false);
			cancelButton.setEnabled(false);

			addButton.setEnabled(true);
			editButton.setEnabled(true);
			deleteButton.setEnabled(true);
	
		} 
		else if (source == exitButton) 
		{	// if user click exit button
			try
			{
			PrintWriter output = new PrintWriter(outputFile);

			for(Song aSong: newSongList) 
				{	// output each item in newSongList to output file
				  output.println(aSong.getItemCode() + "," + aSong.getDescription() + ","
						  + aSong.getArtist() +"," + aSong.getAlbum() + "," + aSong.getPrice());
				}
			
			output.close();
			}
			
			catch (FileNotFoundException outputEception) 
			{
				System.out.println("output failure");
			}
			
			System.out.println("\nDatabase Updated - " + outputFile);
			System.exit(0);
		}

		

		
	}
		
	/**
	 * Display information for selected song
	 * @param selectedSong	song to be displayed
	 */
	
	private void displaySongInfo (Song selectedSong)
	{
		// change fields info based on selected song info
		itemCodeField.setText(selectedSong.getItemCode());
		descriptionField.setText(selectedSong.getDescription());
		artistField.setText(selectedSong.getArtist());
		albumField.setText(selectedSong.getAlbum());
		priceField.setText(selectedSong.getPrice()+"");
	       
		itemCodeField.setEnabled(false);
		descriptionField.setEnabled(false);
		artistField.setEnabled(false);
		albumField.setEnabled(false);
		priceField.setEnabled(false);
				
	}
}

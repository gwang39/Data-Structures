/**
 * This program creates Song Database UI that allows user modify song list in the database
 * @author Guan Yue Wang
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;


public class SongDatabase extends JFrame
{

	public static void main(String[] args) 
	{
		// create array list to store song object
		ArrayList<Song> songList = new ArrayList<Song>();
		Scanner input = new Scanner(System.in);
		
		// get file location
		System.out.print("Please input the location of song database text file: ");

		String fileName = input.nextLine(); //D:\java_workplace\SongDatabase\Database.txt
		
		String choice = "";

		try 
		{	// read existing text data file
			Scanner infile = new Scanner(new File(fileName));

			while (infile.hasNextLine()) 
			{	// read each line
				String line = infile.nextLine();
				//	store each piece of info based on delimiter
				String[] item = line.split(",");	
				// create song object based on info
				Song newSong = new Song(item[0], item[1], item[2], item[3], Double.parseDouble(item[4]));
				// add song object to song array list
				songList.add(newSong);
			}
			
			// create new song database user interface
			SongDatabaseFrame database = new SongDatabaseFrame(songList,fileName);
			database.setTitle("Song Database");
			database.setSize(400, 400);
			database.setVisible(true);
			database.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

		catch (FileNotFoundException e) 
		{	// if there's no existing text data file
			System.out.print("\nNo Existing Song Database Found. Create A New Database? (Y/N):");

			choice = input.nextLine();
			
			if (choice.equalsIgnoreCase("y")) 
			{	// if yes
				// add one song using default constructor
				Song songSlot = new Song();
				songList.add(songSlot);
				// create new song database user interface
				SongDatabaseFrame newDatabase = new SongDatabaseFrame(songList,fileName);
				newDatabase.setTitle("Song Database");
				newDatabase.setSize(400, 400);
				newDatabase.setVisible(true);
				newDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			else
			{	// if no
				System.out.println("Program Terminated");
			}
		}
	}
}


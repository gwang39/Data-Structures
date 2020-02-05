/**
 * This class simulates a song and its characteristics
 * @author Guan Yue Wang
 *
 */


public class Song 
{
	//declare variables
	
	private String itemCode, description, artist, album;
	private double price;
	
	
	/**
	 * Song default constructor
	 */
	
	public Song()
	{
		itemCode="00";
		description = "N/A";
		artist = "N/A";
		album = "N/A";
		price = 0;
	}
	
	
	/**
	 * Song constructor
	 * @param itemCode1		the item code of the song
	 * @param description1	the description of the song
	 * @param artist1		the artist of the song
	 * @param album1		the album of the song
	 * @param price1		the price of the song
	 */
	
	public Song(String itemCode1, String description1, String artist1, String album1, double price1)
	{
		this.itemCode = itemCode1;
		this.description = description1;
		this.artist = artist1;
		this.album = album1;
		this.price = price1;
	}
	
	/**
	 * Get the item code of of the song
	 * @return	the item code of the song
	 */
	
	public String getItemCode()
	{
		return itemCode;
	}
	
	/**
	 * Get the description of the song
	 * @return	the description of the song
	 */
	
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * Get the artist of the song
	 * @return	the artist of the song
	 */
	
	public String getArtist()
	{
		return artist;
	}
	
	/**
	 * Get the album of the song
	 * @return	the album of the song
	 */
	
	public String getAlbum()
	{
		return album;
	}
	
	/**
	 * Get the price of the song
	 * @return	the price of the song
	 */
	
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * Set the new description of the song
	 * @param newDescription	the new description of the song
	 */
	
	public void setDescription(String newDescription)
	{
		this.description = newDescription;
	}
	
	/**
	 * Set the new artist of the song
	 * @param newArtist	the new artist of the song
	 */
	
	public void setArtist(String newArtist)
	{
		this.artist = newArtist;
	}
	
	/**
	 * Set the new album of the song
	 * @param newAlbum	the new album of the song
	 */
	
	public void setAlbum(String newAlbum)
	{
		this.album = newAlbum;
		
	}
	
	/**
	 * Set the new price of the song
	 * @param newPrice	the new price of the song
	 */
	
	public void setPrice(double newPrice)
	{
		this.price = newPrice;
		
	}
	
	/**
	 * override toString to display description
	 */
	
	public String toString()
	{
		return description;
	}
	
	
}

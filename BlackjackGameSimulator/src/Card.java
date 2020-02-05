/**
 * This class constructs one Poker card
 * @author Guan Yue Wang
 *
 */


public class Card 
{
	
	/**
	 * The number value on the card
	 */
	private int cardNumber;
	
	/**
	 * The suit name String of the card
	 */
	private String cardSuit = "";
	

	
	/**
	 * Card constructor
	 * @param number	the number value on the card
	 * @param suit		the suit name of the card
	 */
	
	public Card (int number, String suit)
	{
		cardNumber = number;
		
		cardSuit = suit;
		
	}
	
	/**
	 * Card default constructor
	 */
	
	public Card()
	{
		cardNumber = 0;
		cardSuit = "";
	}
	
	
	/**
	 * Get the number value on the card
	 * @return		the number value on the card
	 */
	
	public int getCardNumber()
	{
		return cardNumber;
		
	}
	
	/**
	 * Get the suit name on the card
	 * @return		the suit name of the card
	 */
	
	public String getCardSuit()
	{
		return cardSuit;
	}
	
	
	/**
	 * @return		the card details - suit and number
	 */
	
	public String toString()
	{
		String cardName = "";
		
		switch (cardNumber)
		{	// match card value to string
		case 1:
			cardName = "Ace";
			break;
		case 2:
			cardName = "Two";
			break;
		case 3:
			cardName = "Three";
			break;
		case 4:
			cardName = "Four";
			break;
		case 5:
			cardName = "Five";
			break;
		case 6:
			cardName = "Six";
			break;
		case 7:
			cardName = "Seven";
			break;
		case 8:
			cardName = "Eight";
			break;
		case 9:
			cardName = "Nine";
			break;
		case 10:
			cardName = "Ten";
			break;
		case 11:
			cardName = "Jack";
			break;
		case 12:
			cardName = "Queen";
			break;
		case 13:
			cardName = "King";
			break;
			
		default:
			cardName = "N/A";
			break;
		}
		
		cardName = cardSuit + "-" + cardName;
				
		return cardName;
		
	}
	
	
}































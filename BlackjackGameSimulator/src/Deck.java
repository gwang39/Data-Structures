/**
 * This class simulates one Poker card deck (52 cards) and it's corresponding actions
 * @author Guan Yue Wang
 *
 */



public class Deck 
{
	/**
	 * An array stores all the 52 cards
	 */
	
	private Card[] cards = new Card[52];
	
	private String cardSuit = "";
	
	private int cardCount = 52;
	
	/**
	 * Deck constructor
	 */
	
	public Deck()
	{
		int count = 0;
		
		for (int s = 1; s <=  4; s++)
		{	//for each suit
			
			switch (s)
			{
			case 1:
				cardSuit = "Diamond";
				break;
			case 2:
				cardSuit = "Club";
				break;
			case 3:
				cardSuit = "Spade";
				break;
			case 4:
				cardSuit = "Heart";
				break;
			default:
				cardSuit = "N/A";
				break;
			}
			
			for (int i = 1; i <= 13; i++)
			{	// for each card number in a suit
				
				cards[count] = new Card(i,cardSuit);	//	create a new card
				count ++;
			}
			
			
		}
				
		
	}
	
	/**
	 * Shuffle cards in the deck
	 */
	
	public void shuffle()
	{
		int randomCard;
		
		Card tempCard;
		
		for (int i = 0; i < cardCount; i++)
		{
			randomCard = (int )(Math.random() * 52);	// random number 0 - 51
			
			// swap position of Card i and chosen random Card
			
			tempCard = cards[i];
			
			cards [i] = cards[randomCard];
			
			cards [randomCard] = tempCard;
			
		}

	}
	
	/**
	 * Deal next card in the deck
	 * @return		next Card in the deck
	 */
	
	public Card dealCard()
	{	

		Card nextCard = cards[0];	//get next card
		
		for (int i = 1; i < cardCount; i++)
		{
			cards[i-1] = cards[i];			
		}
		
		cards[cardCount - 1] = null;	//set last duplicate card to null after everything shifted forward
		
		cardCount = cardCount - 1;
		
		return nextCard;
		
		
	}
	
	
	/**
	 * Print all cards left in the deck
	 */
	
	public void printCards()
	{
		for ( int i = 0; i < cardCount; i++)
		{
			System.out.print(cards[i].toString() + "\n");
			
		}
		
	}
	
	
}





















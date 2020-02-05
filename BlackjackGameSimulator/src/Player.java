/**
 * This class simulates the Black Jack player (also dealer)
 * @author Guan Yue Wang
 *
 */


public class Player
{
	/**
	 * create Card array to store cards in player's hand
	 */
	
	private Card[] playerHand = new Card[11];	// extreme case 11 cards 1,1,1,1,2,2,2,2,3,3,3 - 21 points
	
	private int handCount = 0;	// number of cards on hand
	
	/**
	 * Player constructor
	 */
	
	public Player()
	{	// set all space to null on player's hand
		for (int i = 0; i < 11; i++)
		{
			playerHand[i] = null;
		}
		handCount = 0;
	}
	
	/**
	 * Reset player's hand
	 */
	
	public void clearHand()
	{	// reset everything to null on player's hand
		for (int i = 0; i < 11; i++)
		{
			playerHand[i] = null;
		}
		handCount = 0;
	}
	
	
	/**
	 * Get next card from the deck
	 * @param nextCard	next card in the deck
	 */

	
	public void getCard(Card nextCard)
	{	// get next card and put into player's hand
		playerHand[handCount] = nextCard;
		// hand count increase by one
		handCount +=1;
		
	}
	
	
	/**
	 * Get the total points in player's current hand 
	 * @return		the current points in player's hand
	 */
	
	public int getCurrentPoints()
	{
		int totalPoints = 0;
		int cardPoint;
		int aceCount = 0;
		
		for (int i = 0; i < handCount; i++)
		{
			cardPoint = playerHand[i].getCardNumber();
			
			if (cardPoint == 1)
			{	// if ace, add 11 to total points
				totalPoints += 11;
				aceCount +=1;
			}
			else if (cardPoint > 10)
			{	// if jack queen king, add 10 to total points
				totalPoints += 10;
			}
			else
			{
				totalPoints += cardPoint;
			}
			
		}
		
		while (aceCount >0 && totalPoints > 21)
		{	// if player has ace and total points > 21, minus 10 from the points to prevent from busting
			totalPoints -=10;
			aceCount-=1;
		}
			
		return totalPoints;
		
	}
	
	/**
	 *  Print the calculated points of the hand
	 */
	public void showPoints()
	{
		System.out.println ("Points: " + this.getCurrentPoints());
	}
	
	/**
	 * Print the current cards in player's hand
	 */
	
	public void showPlayerHand()
	{
		System.out.println();
		System.out.println("Player's Hand:");
		
		for (int i = 0; i < handCount; i++)
		{
			System.out.print(playerHand[i].toString() + "|" );
		}
		
		System.out.println();
		
	}
	
	/**
	 * Print the current cards in dealer's hand
	 * @param hideFirst		if user wants to hide the first card in hand
	 */
	
	public void showDealerHand(boolean hideFirst)
	{
		System.out.println();
		System.out.println("Dealer's Hand:");
		
		if (hideFirst)
		{	// hide first card if required
			for (int i = 0; i < handCount; i++)
			{
				if (i == 0)
				{	
					System.out.print("1st Card|");
				}
				else
				{
					System.out.print(playerHand[i].toString() + "|" );
				}
				
			}
		}

		else
		{	// print all cards in hand
			for (int i = 0; i < handCount; i++)
			{
				System.out.print(playerHand[i].toString() + "|" );
			}

		}
		
		System.out.println();
	}
	
	
	
}

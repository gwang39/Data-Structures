/**
 * Project 2
 * This program simulates a Black Jack game
 * @author Guan Yue Wang
 */


import java.util.Scanner;


public class BlackjackGameSimulator 
{

	public static void main(String[] args)
	{
		// Declare variables
		
		Deck deck1 = new Deck();	// create new deck
		
		Player gwang = new Player();	// create new player
		
		Player dealer = new Player();	// create new dealer
		
		Scanner input = new Scanner (System.in);
		
		int money = 100;	// player money
		
		String nextRound = "Y";
		
		System.out.print("Black Jack - Game Begin!");
		
		// Game start
		
		deck1.shuffle();	// shuffle deck
		
		while (money > 0 && nextRound.equalsIgnoreCase("Y"))
		{	// keep running till user runs our of money or terminates the game
			
			int bet = -1;
			
			while (bet < 0 || bet > money)
			{	// make sure valid bet input
				System.out.print("\nPlease place your bet from 0 to " + money +": ");
				bet = input.nextInt();	// get user bet
				input.nextLine();
			}

			
			System.out.println();
			
			gwang.clearHand();	// reset player hand
			dealer.clearHand();	//	reset dealer hand
			
			String choice = "";
			
			// PLAYER INITIAL ROUND
			
			try
			{	// player get next card from deck
				gwang.getCard(deck1.dealCard());
			}
			catch (ArrayIndexOutOfBoundsException noCard)
			{	// if there's no more card, terminate the game
				System.out.println("\nNO MORE CARD. GAME OVER.");
				break;
			}
			
			try
			{	// player get next card from deck
				gwang.getCard(deck1.dealCard());
			}
			catch (ArrayIndexOutOfBoundsException noCard)
			{	// if there's no more card, terminate the game
				System.out.println("\nNO MORE CARD. GAME OVER.");
				break;
			}
			
			gwang.showPlayerHand();	// print player's hand
			gwang.showPoints();	// calculate player's point
			
			
			
			if (gwang.getCurrentPoints() == 21)
			{	// player wins immediately if he gets 21 points
				System.out.print("Player - Black Jack!");
			}
			
			
			// DEALER INITIAL ROUND
			
			else
			{
				try
				{	// dealer get next card from deck
					dealer.getCard(deck1.dealCard());
				}
				catch (ArrayIndexOutOfBoundsException noCard)
				{	// if there's no more card, terminate the game
					System.out.println("\nNO MORE CARD. GAME OVER.");
					break;
				}
				
				try
				{	// dealer get next card from deck
					dealer.getCard(deck1.dealCard());
				}
				catch (ArrayIndexOutOfBoundsException noCard)
				{	// if there's no more card, terminate the game
					System.out.println("\nNO MORE CARD. GAME OVER.");
					break;
				}
				
				dealer.showDealerHand(true);	// show dealer's hand with hidden first card
				
				if (dealer.getCurrentPoints() == 21)
				{	// dealer wins immediately if he gets 21 points
					System.out.print("Dealer - Black Jack!");
				}
				
				else
				{	// ask player if he wants to hir or stay
					
					while (!choice.equalsIgnoreCase("S") && gwang.getCurrentPoints()<21)
					{	// loop till either player chooses to stay or he gets or exceeds 21 points
						System.out.print("\nPlayer Choice: H - HIT or S - STAY: ");
						choice = input.nextLine();	// get user choice
						
						// PLAYER CHOICE ROUND
						
						if (choice.equalsIgnoreCase("H"))
						{	// if player chooses to hit
							try
							{	// player get next card from deck
								gwang.getCard(deck1.dealCard());
							}
							catch (ArrayIndexOutOfBoundsException noCard)
							{	// if there's no more card, terminate the game
								System.out.println("\nNO MORE CARD. GAME OVER.");
								break;
							}
							
							gwang.showPlayerHand();	// show player hand
							gwang.showPoints();	// show player points
							
						}
						
						
						// DEALER CHOICE ROUND
						
						else
						{
							if (gwang.getCurrentPoints()<21)
							{	// if player is still in game
								while(dealer.getCurrentPoints()<17)
								{	// dealer hits till greater than 17
									System.out.println("\nDealer hits");
									try
									{
										dealer.getCard(deck1.dealCard());
									}
									catch (ArrayIndexOutOfBoundsException noCard)
									{
										System.out.println("\nNO MORE CARD. GAME OVER.");
										break;
									}
									
									dealer.showDealerHand(true);	// show dealer hand with first card hidden
								}
								
							}
							
						}
						
					}
					
				}
				
			}

			
			// OUTPUT
			// Compare points and display game results
			
			System.out.println("\nResults");

			if (gwang.getCurrentPoints() > 21)
			{	// player loses if greater than 21 points
				System.out.println("WINNER - DEALER");
				money -= bet;	// player lose money
			}
			
			else if (dealer.getCurrentPoints() > 21)
			{	// dealer loses if greater than 21 points
				System.out.println("WINNER - PLAYER");
				money += bet;	//player win money
			}
			
			else if (gwang.getCurrentPoints() > dealer.getCurrentPoints() && gwang.getCurrentPoints() <22)
			{	// player wins if he has valid points larger than dealer
				System.out.println("WINNER - PLAYER");
				money += bet;	// player win money
			}
			
			else if (gwang.getCurrentPoints() < dealer.getCurrentPoints() && dealer.getCurrentPoints() <22)
			{	// dealer wins if he has valid points larger than player
				System.out.println("WINNER - DEALER");
				money -= bet;	// player win money
			}
			
			else if (gwang.getCurrentPoints() == dealer.getCurrentPoints() && dealer.getCurrentPoints() <22 && gwang.getCurrentPoints() <22)
			{	// tie if two people have the same valid points
				System.out.println("TIE");
			}
			
			else
			{
				System.out.println("ERROR");
			}
			
			gwang.showPlayerHand();
			gwang.showPoints();
			
			dealer.showDealerHand(false);
			dealer.showPoints();
			
			System.out.println("\nPlayer's Money Left: " + money);	// display bet results and total money left
			
			if (money > 0)
			{	//	continue if player still has money
				System.out.print("\nOne more round? (Y/N): ");	// ask if player wants one more round
				nextRound = input.nextLine();
				
				while (!nextRound.equalsIgnoreCase("Y")&!nextRound.equalsIgnoreCase("N"))
				{	// check valid input
					System.out.print("\nInvalid Input - One more round? (Y/N): ");
					nextRound = input.nextLine();
				}
				
				if (nextRound.equalsIgnoreCase("N"))
				{	// terminate if player chooses 'N'
					System.out.println("\nUSER TERMINATED. GAME OVER.");
				}
				
			}
			
			else
			{	// terminate if player doesn't have any money
				System.out.println("\nYOU RAN OUT OF MONEY. GAME OVER.");
			}
			
		}

	}

}

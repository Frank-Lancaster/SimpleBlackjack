package simpleBlackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {

	int[] deck;
	int playerNum;
	int compNum;
	
	public void generateGame() {
		deck = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 11};
		playerNum = 0;
		compNum = 0;
	}
	
	public int getCard() {
		int index = new Random().nextInt(deck.length - 1);
		int n = deck[index];
		for(int i = index; i < deck.length - 1; i++) {
			deck[i] = deck [i+1];
		}
		return n;
	}
	
	public void dealCards() {
		compNum += getCard();
		compNum += getCard();
		playerNum += getCard();
		playerNum += getCard();
	}
	
	public void playerHit() {
		playerNum += getCard();
	}
	
	public void compHit() {
		compNum += getCard();
	}
	
	public void compare() {
		System.out.println("You scored " + playerNum +", and I scored " + compNum + ".");
		if(playerNum == 21 && compNum == 21) {
			System.out.println("We both got 21! It's a tie.");
			System.exit(0);
		} else if (playerNum == 21){
			System.out.println("You got 21! You win.");
			System.exit(0);
		} else if (compNum == 21){
			System.out.println("I got 21. You lose.");
			System.exit(0);
		} else if (playerNum > 21 && compNum > 21){
			System.out.println("We both busted.");
			System.exit(0);
		} else if (playerNum > 21){
			System.out.println("You busted. You lose.");
			System.exit(0);
		} else if (compNum > 21){
			System.out.println("I busted. You win.");
			System.exit(0);
		} else if (playerNum > compNum){
			System.out.println("You scored higher than me. You win.");
			System.exit(0);
		} else {
			System.out.println("I scored higher than you. You lose.");
			System.exit(0);
		}  
	}
	
	public void playGame() {
		System.out.println("Welcome. I'll deal the cards.");
		dealCards();
		
		while(true) {
			System.out.println("(Your total is " + playerNum + ")");
			System.out.println("Hit? (0 for yes / 1 for no)");
			Scanner reader = new Scanner(System.in);  
			int n = reader.nextInt(); 
			if(n == 0) {
				playerHit();
				if(playerNum > 21) {
					compare();
				}
			} else {
				reader.close();
				break;
			}
		}
		
		while(true) {
			if(21 - compNum > 7) {
				System.out.println("I'll hit.");
				compHit();
			} else {
				break;
			}
		}
		System.out.println("Alright. Let's compare.");
		compare();
		
		
		
	}
}

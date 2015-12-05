
/*
 * David Casarrubias-Mena
 * Siem Yahmana
 * COSC 120
 * In this program we have created a simple hangman game. There are 20 words in the game, and the word will be chose at random. 
 * The user will have 6 tries to try to guess the word correctly. 
 */

import java.util.*;

public class Application {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		Random r = new Random(); // create a random number generator.
		
		String word = " "; // string that will store the word generated 
		int n; // variable that will be used to generate 20 random words. 
		int lives = 6; // Number of lives from the start
		int incorrect = 0; // initialize incorrect tries to 0. Will be used to keep track of number of wrongs.
		char letter; // creates a variable of type char that will be used to store the letter entered by the user. 
		int wins = 0; // initializes number of wins to 0. 
		int losses = 0; // initializes number of losses to 0. 
		String s; // create a string that will store the letter entered by user. 
		String replay; // string that will be used to store the decision of the user. 
		
		StringBuilder s1; // create a stringbuilder that will store the original word.
		StringBuilder s2; // create a second stringbuilder that will store the underscores. 

		do{ // continue to iterate as long as the user does not exit the program. 
			lives = 6; // initializes the lives the user has to 6. 
			n = r.nextInt(20) + 1; // generates a random number between 1 -20
			
			switch(n){ // switch statement that selects a word based on the random number generated.
			case 1: 
				word = "Elephant"; break; // if number generated is 1, then word is set to Elephant. 
			
			case 2: word = "Colts"; break; // if number generated is 2, then word is set to Colts. 
				
			case 3: word = "Airport"; break; // if number generated is 3, then word is set to Airport. 

			case 4: word = "Fallout4"; break; // if number generated is 4, then word is set to Fallout4. 
				
			case 5: word = "Facebook"; break; // if number generated is 5, then word is set to Facebook. 
		
			case 6: word = "Twitter"; break; // if number generated is 6, then word is set to Twitter. 
	
			case 7: word = "UnitedStates"; break; // if number generated is 7, then word is set to UnitedStates. 
			
			case 8: word = "Cancun"; break; // if number generated is 8, then word is set to Cancun. 
				
			case 9: word = "Uber"; break; // if number generated is 9, then word is set to Uber. 
				
			case 10: word = "Mathematics"; break; // if number generated is 10, then word is set to Mathematics. 
				
			case 11: word = "Physics"; break; // if number generated is 11, then word is set to Physics. 
				
			case 12: word = "ComputerScience"; break; // if number generated is 12, then word is set to ComputerScience. 
		
			case 13: word = "Chemistry"; break; // if number generated is 13, then word is set to Chemistry. 
				 
			case 14: word = "Apple"; break; // if number generated is 14, then word is set to Apple. 
				
			case 15: word = "Microsoft"; break; // if number generated is 15, then word is set to Microsoft. 
				
			case 16: word = "Youtube"; break; // if number generated is 16, then word is set to Youtube. 
				
			case 17: word = "Reddit"; break; // if number generated is 17, then word is set to Reddit. 
			
			case 18: word = "SMCM"; break; // if number generated is 18, then word is set to SMCM. 
				
			case 19: word = "GoogleChrome"; break; // if number generated is 19, then word is set to GoogleChrome. 
				
			case 20: word = "Firefox"; break; // if number generated is 20, then word is set to Firefox. 
				
			}
				s1 = new StringBuilder(word); // create a stringbuilder called s1 and pass the word randomly selected as a parameter to stringbuilder
				s2 = new StringBuilder(word); // create a stringbuilder called s2 pass the word randomly selected as a parameter to the second stringbuilder
				
				int start = 0; // Initializes the start to 0
				//int end = word.length(); // initializes the end to the length of the word.
				
				s2.delete(start, word.length()); // deletes the characters in the stringbuilder s2 from 0 to the length of the string.
				
			for(int i = 0; i < word.length(); i++){ // goes through the length of the word generated and sets the correct number of underscores. 
				s2.append("_ "); // adds the underscores to the end of the second stringbuilder which is currently empty. 
			}
			
			
			while(lives > 0){ // whiles the user still has guesses remaining
				int correct = 0;  // initializes number of correct guesses to 0.
				System.out.println("You have " + lives + " guessing remaining"); // informs user of the number of guesses they have remaining. 
				System.out.println(s2); // prints out the second stringbuilder which contains all the underscores.  
				
				System.out.println("Enter a letter: ");
				s = input.nextLine(); // reads in string from the user
				letter = s.charAt(0); // sets the char letter equal to the value of the string read in by the user at the 0th index. 
				
			        
				for(int i = 0; i < s1.length(); i++){ // check if letter is in the word and place in the correct underscore
					if(letter == Character.toLowerCase(s1.charAt(i)) || letter == Character.toUpperCase(s1.charAt(i))){ // checks to see if the letter entered by the user exists in the current index. Makes sure to ignore cases
						s2.setCharAt(i*2, s1.charAt(i)); // if there is a letter that is in the correct word, then replace the underscore by setting the correct letter in its correct index. 
						correct++; // correct counter. Increments every time the letter appears in the word. 
					}
					
				}
				
				if(correct == 0){ // if there wasn't a letter that matched at a given index, then subtract 1 from the lives counter.
					lives--; // subtracts one from lives. 
				}
				
				
				if(s2.toString().replaceAll("\\s+", "").equalsIgnoreCase(s1.toString())){ // checks to see if user correctly guessed the word by comparing it to the first stringbuilder that contains the original word. 
					System.out.println(s2);
					System.out.println("You have won!"); // informs user that they have won. 
					lives=-1; // sets lives to -1 in order to not trip up the next if statement. 
					wins++; // increments the win counter if user guesses the word correctly. 
				}
				
				if(lives == 0){ // if the user has no lives remaining, then inform user that they have lost and print out the correct word. 
					System.out.println("You lose"); // informs user that they lost
					System.out.println("The word was: " + word); // prints out the correct word. 
					losses++; // increases the number of losses by one. 
				}
			
			}
			
			System.out.println("Do you wish to play again? Enter yes to continue, no to exit"); // asks user if they wish to play again.
			replay = input.nextLine(); // reads in response from user.
		}while(!replay.equalsIgnoreCase("NO")); // program runs as long as user does not enter no. 
		
		System.out.println("Game Over"); // displays game over once user exits the game
		System.out.println("You won: " + wins + " times"); // Displays the number of times the user won.
		System.out.println("You lost: " + losses + " times"); // Displays the number of ties the user lost. 

	}
}

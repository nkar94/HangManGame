import java.util.Scanner;


public class HangManProtocol {
	GameData gd;
	
	public HangManProtocol(GameData gd){
		this.gd=gd;
		
	}

	
    int WAITING = 0;
    int STARTGAME = 1;
    int STARTGUESS = 2;
    int DONE = 3;
    int state = WAITING;
    
	public String start(String input){
		String output=null;
		if(state==WAITING){
			output = "Welcome to Hangman! Press Enter to Start!";
			state=STARTGAME;
		}
		else if(state==STARTGAME){
			System.out.println(gd.word);
			output = gd.hidden.toString() + " Lives:"+gd.lives + " Guess a Letter OR type gamebreaker to guess the word:";
			state=STARTGUESS;
		}
		else if(state==STARTGUESS){
			if(gd.word.equals(gd.hidden.toString())){
				
				output ="Yayyyyyy! The word was " + gd.hidden.toString()+ " You Win! You still had "+gd.lives+ " Lives remaining.";
				state=DONE;
			}
			else if(gd.lives==0){
				output = "Sorry, you lose :(. The word was "+gd.word;
				state=DONE;
			}
			else{
				char letter = input.charAt(0);
				if(gd.guesses.indexOf(letter)==-1){
					gd.guesses +=(letter);
					if(gd.word.indexOf(letter)==-1){
						gd.lives--;
						output = gd.hidden.toString() + " Lives:"+gd.lives + " Guess a Letter OR type gamebreaker to guess the word:";
						state=STARTGUESS;
					}
					else{
						revealGuess(gd.word,gd.hidden,letter);
						output = gd.hidden.toString() + " Lives:"+gd.lives + " Guess a Letter OR type gamebreaker to guess the word:";
						state=STARTGUESS;

					}
				}
				else{
					gd.lives--;
					output = gd.hidden.toString() + " Lives:"+gd.lives + " Guess a Letter OR type gamebreaker to guess the word:";

					state=STARTGUESS;
				}
			}
		}
		else if(state==DONE){
            output = "Game Over";
            state = WAITING;
		}
		return output;
	}
	
	public char guessLetter(){
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a letter: ");
		String str = reader.next();
		char c = str.charAt(0);
		return c;
	}
    public void revealGuess(String word, StringBuffer hidden, char letter)
   {
      for (int index = 0; index < word.length(); index++)
         if (word.charAt(index) == letter){
            hidden.setCharAt(index, letter);
         }
   }
    public StringBuffer hiddenWord(String word)
   {
      StringBuffer hidden = new StringBuffer(word.length());
      for (int counter=0; counter < word.length(); counter++)
    	  hidden.append('-');
      return hidden;
   }
}

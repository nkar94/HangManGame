import java.io.PrintWriter;


public class GameBreakerProtocol {
	GameData gd;
    PrintWriter out;


	public GameBreakerProtocol (GameData gd, PrintWriter out){
		this.gd=gd;
		this.out=out;
	}
	
	public String start(String input){
		String output = "Game Over";
		String[] guess = input.split(" ", 2);
		if(gd.word.equals(guess[1].toString())){
			out.println("You guessed correctly! The word was " + gd.word + ". You still had " + gd.lives + " lives remaining." );	
		}
		else{
			out.println("You guessed wrong. The word was " + gd.word +". Your Guess was:" + guess[1]);
		}
		return output;
		
	}

}


public class GuessedLettersProtocol {
	GameData gd;
	String output;
	public GuessedLettersProtocol(GameData gd){
		this.gd=gd;
	}
	
	public String start(){
		output = "Guessed Letters: " + gd.guesses + " Guess a letter:";
		return output;
	}

}

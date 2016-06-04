import java.io.PrintWriter;


public class HintProtocol {

	GameData gd;
	PrintWriter out;
	String output;
	public HintProtocol(GameData gd, PrintWriter out) {
		this.out=out;
		this.gd=gd;
	}
	public String start(String input){
		gd.lives = gd.lives-1;
		//out.println(input); testing
		String[] hint = input.split(" ", 2);
		if(hint[1].equalsIgnoreCase("first")){
			gd.revealGuess(gd.word, gd.hidden, gd.word.charAt(0));
			//testing
			//out.println("first " + "   " + gd.word + "    "+ gd.word.charAt(0));
			//out.println(gd.word);
			//out.println(gd.word.charAt(0));
			output=gd.hidden.toString() + " Lives:"+gd.lives + " Guess a Letter OR type gamebreaker to guess the word:";
		}
		else{
			gd.revealGuess(gd.word, gd.hidden, gd.word.charAt(gd.word.length()-1));
			//testing
			//out.println("last " + "   " + gd.word + "       " +(gd.word.length()-1));
			//out.println(gd.word);
			//out.println(gd.word.length()-1);
			output=gd.hidden.toString() + " Lives:"+gd.lives + " Guess a Letter OR type gamebreaker to guess the word:";
		}
		return output;
		
	}

}

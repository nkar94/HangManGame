import java.util.Scanner;


public class HangMan {
	static String[] words = {"abruptly","affix","axiom","bagpipes","bandwagon",
			"banjo","bikini","blitz","bookworm","boxcar","buffalo","buffoon","cobweb",
			"croquet","duplex","dwarves","equip","exodus","fishhook","fixable",
			"foxglove","galaxy","gazebo","gizmo","glowworm","haiku","haphazard",
			"hyphen","icebox","injury","ivory","ivy","jaundice","jawbreaker","jaywalk", 
            "jazzy","jigsaw","jiujitsu","jockey","joyful","juicy","jumbo","kazoo",
            "keyhole","khaki","kilobyte","kiosk","kiwifruit","knapsack" ,"larynx",
            "luxury","marquis","megahertz","microwave","mystify","nightclub",
            "nowadays","numbskull","ovary","oxidize","oxygen","pajama","peekaboo", 
            "pixel","pizazz","pneumonia", "polka","quartz","quiz","quorum",
            "razzmatazz","rhubarb","rickshaw","schizophrenia","sphinx","spritz",
            "squawk","subway","swivel","topaz","unknown","unworthy","unzip",
            "uptown","vaporize","vixen","vodka","vortex","walkway","waltz",
            "wavy","waxy","wheezy","whiskey","whomever","wimpy","wizard",
            "xylophone","yippee","youthful","zigzag","zilch","zodiac"
            ,"zombie"};
	
	static int randomWord = (int) (Math.random() * words.length);
	static String guesses="";
	static String word = words[randomWord];
	static int lives = 7;
	static boolean done = false;
	static boolean gamebreaker;
	public static void main(String[] args) {
		//System.out.println("Word:"+word);
		
		StringBuffer hidden = hiddenWord(word);
		while(!done){
			
			System.out.println(word);
			System.out.println("Lives:"+lives);
            System.out.println("---------Guesses---------");
            System.out.println(guesses);
            System.out.println("-------------------------");
			System.out.println("Word: "+hidden.toString());
			char letter =guessLetter();
			if(guesses.indexOf(letter)==-1){
				guesses += letter;
	            if(word.indexOf(letter)==-1){
	            	lives--;
	            }
	            else{
	            	revealGuess(word, hidden, letter);
	            }
			}
			else{
				lives--;
				System.out.println("Already Guessed");
			}
			//printArray(guesses);
			if(word.equals(hidden.toString())){
				System.out.println("YOU WIN!!!");
				done=true;
			}
			else if (lives <= 0){
				System.out.println("You Lose :(");
				done=true;
			}
			
		}
		
		System.out.println("The word was "+word);
		
		/*
		String hidden = word.replaceAll("s","-");
		char[] hiddenWord = hidden.toCharArray();
		System.out.println("Hidden"+hidden);
		System.out.println(hiddenWord);
		
		while(word!=hiddenWord.toString()){
			char letter=guessLetter();
			word.indexOf(letter);
			int replace=word.indexOf(letter);
			hiddenWord[replace]=letter;
			System.out.println(hiddenWord);
		}
		*/
	}

	
	public static char guessLetter(){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a letter: ");
		String str = reader.next();
		char c = str.charAt(0);
		return c;
	}
    public static void revealGuess(String word, StringBuffer hidden, char letter)
   {
      for (int index = 0; index < word.length(); index++)
         if (word.charAt(index) == letter){
            hidden.setCharAt(index, letter);
         }
   }
    public static StringBuffer hiddenWord(String word)
   {
      StringBuffer hidden = new StringBuffer(word.length());
      for (int counter=0; counter < word.length(); counter++)
    	  hidden.append('-');
      return hidden;
   }

	
}

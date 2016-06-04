
public class GameData {
	//String[] words = {"abruptly","affix","axiom","bagpipes","bandwagon"};
	String[] words = {"abruptly","affix","axiom","bagpipes","bandwagon",
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
	int randomWord = (int) (Math.random() * words.length);
	String word = words[randomWord];
	String guesses="";
	int lives = 7;
	boolean done = false;
	StringBuffer hidden= hiddenWord(word);
	
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

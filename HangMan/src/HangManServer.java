import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HangManServer {

	public static void main(String[] args) throws IOException {

		int port = 4444;

		try ( 
				ServerSocket server = new ServerSocket(port);
				Socket client = server.accept();
				PrintWriter out =new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				) {

			String inputLine, outputLine;
			GameData gd = new GameData();
			HangManProtocol play = new HangManProtocol(gd);
			GameBreakerProtocol gb = new GameBreakerProtocol(gd, out);
			HintProtocol hp = new HintProtocol(gd, out);
			GuessedLettersProtocol gl = new GuessedLettersProtocol(gd);
			outputLine = play.start(null);
			System.out.println(outputLine);
			out.println(outputLine);
			boolean hint = true;
			int counter = 0;

			while ((inputLine = in.readLine()) != null) {
				String[] input = inputLine.split(" ", 2);

				if(input[0].equals("protocol3")){
					out.println("Guess the word");
					String guess  = in.readLine();
					outputLine = gb.start(guess);
				}
				else if(input[0].equals("protocol2")){
					if(hint==true){
						//hint=false;
						hint=true; //testing 
						out.println("Would you like to reveal the first Letter or the last letter? Enter first or last");
						String response = in.readLine();
						outputLine = hp.start(response);
					}
					else{
						out.println("You ran out of hints. Guess a letter:");
						outputLine = play.start(input[1]);
					}
				}
				else if(input[0].equals("protocol1")){
					if(counter!=3){
						outputLine = gl.start();
						counter++;
					}
					else{
						out.println("Sorry, you can only ask for the letters you guessed 3 times. Guess Again");
						outputLine = play.start(input[1]);
					}
				}
				else{
					outputLine = play.start(input[1]);
				}
				out.println(outputLine);
				if (outputLine.equals("Game Over")){
					server.close();
					in.close();
					out.close();
					break;
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
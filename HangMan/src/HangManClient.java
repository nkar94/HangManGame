import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class HangManClient {
	public static void main(String[] args) throws IOException {

		String hostName = "localhost";
		int portNumber = 4444;

		try (
				Socket socket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				) {
			BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
			String server;
			String client;

			while ((server = in.readLine()) != null) {
				System.out.println("Server: " + server);
				if (server.equals("Game Over")){
					socket.close();
					out.close();
					in.close();
					break;
				}
				client = input.readLine();
				if(client.equalsIgnoreCase("gamebreaker")){
					client = "protocol3 " + client;
					out.println(client);
				}
				else if(client.equalsIgnoreCase("hint")){
					client = "protocol2 " + client;
					out.println(client);

				}
				else if(client.equalsIgnoreCase("guesses")){
					client = "protocol1 " + client;
					out.println(client);
				}
				else{
					client = "protocol0 " + client;
					out.println(client);
				}
			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
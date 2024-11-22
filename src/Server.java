import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket socket= serverSocket.accept();
            String clientMessage = "";
            String serverMessage="";
            Scanner scanner = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            while(true){
                clientMessage = reader.readLine();
                System.out.println("Client Message: "+ clientMessage);

                System.out.println("Server Typing...");
                serverMessage = scanner.nextLine();
                pw.println(serverMessage);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",12345);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            String clientMessage = "";
            String serverMessage ="";
            boolean serverBye= false;
            boolean clientBye=false;
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Client typing ...");
                clientMessage = scanner.nextLine();
                pw.println(clientMessage);
                if(clientMessage.equalsIgnoreCase("bye")){
                    clientBye=true;
                }

                serverMessage = reader.readLine();
                System.out.println("Server message: "+ serverMessage);
                if(serverMessage.equalsIgnoreCase("bye")){
                    serverBye=true;
                }

                if(serverBye && clientBye){
                    System.out.println("Both client and server send bye");
                    break;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

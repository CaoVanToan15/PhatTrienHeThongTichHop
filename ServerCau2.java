package socket;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class ServerCau2 {
public static void main(String[] args) {

try {
	ServerSocket server = new ServerSocket(8888);
	System.out.println("Server da duoc tao");
	Socket client = server.accept();
	System.out.println("Client da ket noi den server");
	Scanner inFromClient = new Scanner(client.getInputStream());
	PrintStream outToClient = new PrintStream(client.getOutputStream());
	outToClient.println("Xin chao, ban muon tim sach gi?");
	String a = inFromClient.nextLine();
	System.out.println("client: " + a);
	BufferedReader br= new BufferedReader(new FileReader("E:\\text.txt"));
	String tep=br.readLine();
	if(tep.contains(a))
		outToClient.println("Co sach " + a);
	else
		outToClient.println("Rat tiec khong co sach " + a);
	} catch (IOException e) {
// TODO Auto-generated catch block
		e.printStackTrace();
}
}
}
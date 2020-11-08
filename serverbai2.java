package lab4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class serverbai2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		try {
			serverSocket= new ServerSocket(8000);
			System.out.println("Server da duoc tao");
			Socket clientSocket=serverSocket.accept();
			dos= new DataOutputStream(clientSocket.getOutputStream());
			dis=new DataInputStream(clientSocket.getInputStream());
			Scanner input=new Scanner(System.in);
			 while (true) {
		            String str = dis.readUTF(); //String
	
		            
		            if (str.equalsIgnoreCase("q")) { 
		                break;
		            } else {
		                System.out.println("Client: " + str);
		            }
		            System.out.print("\nI: ");
		            dos.writeUTF(input.nextLine()); 
		            dos.flush(); 
		        }
		} catch (Exception e) {
			// TODO: handle exception
	        dos.close();

	        serverSocket.close();

	        dis.close();

		}
		
	}

}

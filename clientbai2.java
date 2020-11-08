package lab4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class clientbai2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket mySocket=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		try {
			mySocket=new Socket("localhost",8000);
			dos=new DataOutputStream(mySocket.getOutputStream());
			dis=new DataInputStream(mySocket.getInputStream());
			Scanner input=new Scanner(System.in);

	        while(true){
	            System.out.print("\nI: ");
	            dos.writeUTF(input.nextLine());
	            dos.flush();

	            String str = dis.readUTF();
	            
	            if(str.equalsIgnoreCase("q")){
	                break;
	            }
	            else System.out.println("Server: "+str);
	        }
		} catch (IOException e) {
			// TODO: handle exception
	        dos.close();

	        mySocket.close();

	        dis.close();

		}
	}

}

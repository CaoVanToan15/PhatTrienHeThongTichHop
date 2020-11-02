package lab5;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		//Kết nối với cổng mà server đã tạo
		service chuyenbay=(service)Naming.lookup("rmi://localhost:8888/muave");
		try {
			Scanner input = new Scanner(System.in);

			int x;

		while(true)

		{

			System.out.print("\nChọn thông tin muốn xem: ");

			x =input.nextInt();
		}
	}
		
	}

}
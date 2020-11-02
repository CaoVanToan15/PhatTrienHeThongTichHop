package lab5;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class server {

	public static void main(String[] args) throws RemoteException {
		// Tạo cổng server
		LocateRegistry.createRegistry(8888);
		service chuyenbay=(service)Naming.lookup("rmi://localhost:8888/muave")
		try {
			Naming.rebind("rmi://localhost:8888/muave", new chuyenbay());
			System.out.println("Xin chào bạn cần xem thông gì");
			while(true)
			{
				Scanner scan = new Scanner(System.in) {
					System.out.println("Vui lòng chọn dịch vụ :\n1.xem thông tin.\n2.mua vé.\n3.Trả vé:\n");
					int x=scan.nextInt();
					switch(x)
					{
					case 1:
					{
						
						String thongtin1=chuyenbay.information(M01, " 14h ngày 1-11-2020", "HN", "TPHCM", "2 tiếng", 100, 50, 50);
						System.out.println("\nmã M01\n"+thongtin1);
						
						String thongtin2=chuyenbay.information(M02, " 21h ngày 1-11-2020", "TPHCM", "DN", "1 tiếng", 100, 50, 50);
						System.out.println("\nmã M02\n"+thongtin2);
		
						String thongtin3=chuyenbay.information(M03, " 22h ngày 1-11-2020", "TPHCM", "HN", "2 tiếng", 100, 65, 35);
						System.out.println("\nmã M03\n"+thongtin3);
						break;
					}
					case 2:
					{
						double tonggia=0;
						System.out.println("GIÁ VÉ :\n1:1000000\n2:1500000\n3:2000000\n4:2500000\n5:3000000\n");
						System.out.println("Mời Bạn Nhập vào số vé cần mua : ");	
						int sove=scan.nextInt();
						System.out.println("Mời Bạn chọn giá vé :");
						int giave=scan.nextInt();
						if(giave==1000000)
						{
							tonggia=chuyenbay.muave(sove, 1000000);
						}
						else if(giave==1500000)
						{
							tonggia=chuyenbay.muave(sove, 1500000);
						}
						else if(giave==2000000)
						{
							tonggia=chuyenbay.muave(sove, 2000000);
						}
						else if(giave==2500000)
						{
							tonggia=chuyenbay.muave(sove, 2500000);
						}
						else if(giave==3000000)
						{
							tonggia=chuyenbay.muave(sove, 3000000);
						}
						else 
						{
							System.out.println("Bạn Nhập Sai");
						}
						System.out.println("Tổng Tiền Mua Vé:"+tonggia+" VNĐ");
						break;
					}
					case 3:
					{
						System.out.println("Mời bạn nhập vào số vé trả : ");	
						int vetra=scan.nextInt();
						System.out.println("Mời bạn chọn giá vé trả:");
						int nhapve=scan.nextInt();
						double tonggia=0;
						if(nhapve==1000000)
						{
							tonggia=chuyenbay.trave(vetra, 1000000);
						}
						else if(nhapve==1500000)
						{
							tonggia=chuyenbay.trave(vetra, 1500000);
						}
						else if(nhapve==2000000)
						{
							tonggia=chuyenbay.trave(vetra, 2000000);
						}
						else if(nhapve==2500000)
						{
							tonggia=chuyenbay.trave(vetra, 2500000);
						}
						else if(nhapve==3000000)
						{
							tonggia=chuyenbay.trave(vetra, 3000000);
						}
						else 
						{
							System.out.println("Bạn Nhập Sai");
						}
						System.out.println("Tổng Tiền Nhận Lại:"+tonggia +" VNĐ");
					}
					}
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
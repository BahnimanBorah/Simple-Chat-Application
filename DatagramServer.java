import java.io.*;
import java.net.*;

class DatagramServer{

private DatagramSocket server = null;
private DatagramPacket recpacket = null;
private DatagramPacket senpacket = null;


public DatagramServer(int port){
		
		try{
			server = new DatagramSocket(port);
			System.out.println("Server created...");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try{
					String message="",msg="";
					while(!msg.equals("stop")){
						byte[] receive = new byte[65535];
						byte[] send = new byte[65535];
						recpacket = new DatagramPacket(receive,receive.length);
						server.receive(recpacket);
						msg = new String(receive,0,65535);
						System.out.println("Client says: "+ msg);
						message = reader.readLine();
						send = message.getBytes();
						senpacket = new DatagramPacket(send,send.length,
						recpacket.getAddress(),recpacket.getPort());
						server.send(senpacket);
					}			
					System.out.println("Closing connection...");
					try{
						server.close();
					}catch(Exception e){e.printStackTrace();}	
				}catch(Exception e){e.printStackTrace();}
		}catch(Exception e){e.printStackTrace();}
	}
public static void main(String[] args){
	DatagramServer myDataServer = new DatagramServer(8008);

	}

}

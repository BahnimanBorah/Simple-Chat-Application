
import java.io.*;
import java.net.*;

class DatagramClient{

private DatagramSocket server = null;
private DatagramPacket recpacket = null;
private DatagramPacket senpacket = null;


public DatagramClient(){
		
		try{
			server = new DatagramSocket();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try{	
					String msg="",message="";
					while(!message.equals("stop")){
						byte[] receive = new byte[65535];
						byte[] send = new byte[65535];
						message = reader.readLine();
						send = message.getBytes();
						senpacket = new DatagramPacket(send,send.length,
						InetAddress.getLocalHost(),8008);
						server.send(senpacket);
						recpacket = new DatagramPacket(receive,receive.length);
						server.receive(recpacket);
						msg = new String(receive,0,65535);
						System.out.println("Server says: "+ msg);
					}
					System.out.println("Closing connection...");
					try{
						server.close();
					}catch(Exception e){e.printStackTrace();}	
				}catch(Exception e){e.printStackTrace();}
		}catch(Exception e){e.printStackTrace();}
	}
public static void main(String[] args){
	DatagramClient myClient = new DatagramClient();

	}

}

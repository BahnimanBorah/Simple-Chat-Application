import java.io.*;
import java.net.*;

class Client{

private Socket socket = null;
private DataInputStream input = null;
private DataOutputStream output = null;

public Client(String address,int port){
	try{
		socket = new Socket(address,port);
		System.out.println("Connected ..!");
		
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String read="",write="";
		
		while(!read.equals("stop")){
			write = reader.readLine();
			output.writeUTF(write);
			read = input.readUTF();
			System.out.println("Server says: "+read);
		}
	System.out.println("Closing connection...");
	try{
	input.close();
	output.close();
	socket.close();
	}catch(Exception e){e.printStackTrace();}
	}catch(Exception e){e.printStackTrace();}

	}

public static void main(String[] args){
	Client myClient = new Client("localhost",7007);

	}

}

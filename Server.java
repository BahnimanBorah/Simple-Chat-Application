import java.io.*;
import java.net.*;

class Server{

private DataInputStream input = null;
private DataOutputStream output = null;
private ServerSocket server = null;
private Socket socket = null;
public Server(int port){
	try{
	server = new ServerSocket(port);
	System.out.println("Server created !");
	socket = server.accept();
	System.out.println("Client accepted !");
	
	input = new DataInputStream(socket.getInputStream());
	output = new DataOutputStream(socket.getOutputStream());
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String read="",write="";
	
	while(!read.equals("stop")){
		read = input.readUTF();
		System.out.println("Client says: "+read);
		write = reader.readLine();
		output.writeUTF(write);
	
	}
	System.out.println("Closing connection..");
	try{
	server.close();
	socket.close();
	input.close();output.close();
	}catch(Exception e){e.printStackTrace();}

	
	}catch(Exception e){e.printStackTrace();}
}
public static void main(String[] args){
Server myServer = new Server(7007);

}

}

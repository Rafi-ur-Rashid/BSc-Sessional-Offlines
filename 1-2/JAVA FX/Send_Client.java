
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Send_Client implements Runnable{
    DatagramPacket pac;
    DatagramSocket soc;
    String Serv_name,From,Serv_IP,Body,To;
    public Send_Client(String Server,String Client,String to,String Server_IP,String body) {
        Serv_name=Server;
        From=Client;
        To=to;
        Serv_IP=Server_IP;
        Body=body;
        new Thread(this).start();
    }
    

    @Override
    public void run() {
                try {
                    send();
                } catch (Exception e) {
                    System.out.println(e);
                }
            
  }
    public void send() throws UnknownHostException, SocketException, IOException {

     
        String s = "Via: " + Serv_name + "\n" + "To: " + To + "\n" + "From: " + From + "\n" + "Body: " + Body+"\n";
        byte data[] = s.getBytes();
        pac = new DatagramPacket(data, data.length);
        pac.setPort(9050);
        InetAddress add=InetAddress.getByName(Serv_IP);
        pac.setAddress(add);
        soc = new DatagramSocket();
        soc.send(pac);
        soc.close();
        
    }
}


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.scene.control.Button;

public class Client{

    DatagramPacket Packet;
    DatagramSocket Socket;
    String Client_Name;
    String Serv_Name;
    String port;
    String Serv_IP;
    Button b;
    public Client(String C, String port,String S,String Server_IP) throws UnknownHostException {
        Client_Name = C;
        this.port = port;
        Serv_Name = S;
        Serv_IP=Server_IP;
        try {
            String s = "Via: " + Serv_Name + "\n" + "To: " + Serv_Name + "\n" + "From: " + Client_Name + "\n" + "Port: " + port + "\n";
            byte data[] = s.getBytes();
            Packet = new DatagramPacket(data, data.length);
            Packet.setAddress(InetAddress.getByName(Serv_IP));
            Packet.setPort(9050);
            Socket = new DatagramSocket();
            Socket.send(Packet);
            Socket.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
    
//    public static void main(String[] args){
//        
//        //new Client(args[0],args[1],args[2],args[3]);
//        //launch(args);
//        
//    }

    
}

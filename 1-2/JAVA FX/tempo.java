
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class tempo {
    DatagramPacket packet;
        String Via,To,From,Check,Body;
        int port;
        InetAddress Adress;
    tempo(DatagramPacket pc)
    {
        packet=pc;
        StringTokenizer st = new StringTokenizer(new String(packet.getData()), "\n");
        Via = st.nextToken().substring(5);
        To = st.nextToken().substring(4);
        From = st.nextToken().substring(6);
        Check = st.nextToken();
        try {
            Adress=InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        }
        Body = null;
        port = 0;
        if ((Check.substring(0, 4).equals("Body"))) {
            Body = Check.substring(6);
        } else if ((Check.substring(0, 4).equals("Port"))) {
            port = Integer.parseInt(Check.substring(6));
            

        }
    }
    
}


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Hashtable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//public class Server extends Application implements Runnable {
public class Server extends Application implements Runnable{
    DatagramPacket packet;
    DatagramSocket socket;
    public Hashtable<String, tempo> table= new Hashtable<>();
    String Server_name;

    public Server(String Serv_name) throws SocketException, IOException {
        Server_name = Serv_name;
        new Thread(this).start();
        
    }

    @Override
    public void run() {

        while (true) {
            try {
                receive();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void receive() throws SocketException, IOException {
        byte Data[] = new byte[10000];
        packet = new DatagramPacket(Data, Data.length);
        socket = new DatagramSocket(9050);
        socket.receive(packet);
        tempo t=new tempo(packet),t2=null;
        if(t.Body==null)
        {
            t.Body="Body";
            table.put(t.From, t);
            socket.close();
            return;
        } 
        
        else
        {
            t2=table.get(t.To);
        }
        socket.close();  
        
        if(t2==null)
        {
            return;
        }
        else
        {
            send("Via: " + Server_name + "\n" + "To: " + t.To + "\n" + "From: " + t.From+ "\n" + "Body: " +t.Body+"\n",t2.port,t2.Adress);
            socket.close();
        }
            
    }

    public void send(String s, int port, InetAddress Adress) throws SocketException, IOException {
        byte[] b = s.getBytes();
        DatagramPacket pc = new DatagramPacket(b, b.length);
        pc.setPort(port);
        pc.setAddress(Adress);
        DatagramSocket sc = new DatagramSocket();
        sc.send(pc);
    }
    @Override public void start(Stage primaryStage) throws Exception {
        //primaryStage.setResizable(false);
        Parent root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) throws IOException{
        launch(args);
        new Server("asus");
    }

    
}



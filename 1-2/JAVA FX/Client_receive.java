
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Client_receive implements Runnable {

    String Port;
    String[] To = new String[10];
    int i = 0;
    TextArea T,tn;
    ComboBox<String> cb;

    public Client_receive(String port, TextArea t, ComboBox CB,TextArea TN) {
        Port = port;
        T = t;
        cb = CB;
        tn=TN;
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
        byte Data[] = new byte[1000];
        DatagramPacket pac = new DatagramPacket(Data, Data.length);
        DatagramSocket soc = new DatagramSocket(Integer.parseInt(Port));
        soc.receive(pac);
        tempo t = new tempo(pac);
        String Old = T.getText();
        String New = Old + t.From + " says: " + t.Body + "\n";
        T.setText(New);
        for (int j = 0; j < To.length; j++) {
            if (!(t.From).equals(To[j])) {
                tn.setText("New Message (1)");
                cb.getItems().remove(t.From);
                cb.getItems().add(0, t.From);
                break;
            }

        }
        To[i++]=t.From;
        soc.close();

    }

}

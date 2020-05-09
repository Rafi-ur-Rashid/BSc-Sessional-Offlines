
import com.sun.javafx.css.SizeUnits;
import java.io.IOException;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Open_Client {

    String port = "" + ((new Random().nextInt(4000)) + 5000);
    Label fn, tn;
    TextField ST;
    String To, Body;

    public Open_Client(String User) throws IOException {
        new Client(User, port, "asus", "127.0.0.1");
        Stage window = new Stage();
        window.setTitle(User);
        Pane layout = new Pane();
        //Button
        Button button = new Button();
        button.setText("Send");
        button.setPrefSize(69, 31);
        button.setLayoutX(690);
        button.setLayoutY(492);
        //friend msg
        TextArea tx = new TextArea();
        tx.setEditable(false);
        tx.setPrefSize(502, 264);
        tx.setLayoutX(257);
        tx.setLayoutY(19);
        tx.setPromptText("Message From Your Friend");
        tx.setWrapText(true);
        //tx.setFont(System 21);
        //reciever
        TextField tf = new TextField();
        tf.setPrefSize(199, 44);
        tf.setLayoutX(257);
        tf.setLayoutY(302);
        tf.setPromptText("Write Reciever name");
        //Write msg
        TextField Tf = new TextField();
        Tf.setPrefSize(478, 115);
        Tf.setLayoutX(257);
        Tf.setLayoutY(362);
        Tf.setPromptText("Write  message here");
        //notify list
        ComboBox<String> cb = new ComboBox<>();
        cb.setPrefSize(175, 50);
        cb.setLayoutX(14);
        cb.setLayoutY(14);
        //notify text
        TextArea tn = new TextArea();
        tn.setEditable(false);
        tn.setPrefSize(142, 50);
        tn.setLayoutX(14);
        tn.setLayoutY(14);
        tn.setText("New Message (0)");
        //labels
        ToggleButton L1 = new ToggleButton("To"), L2 = new ToggleButton(User);
        L1.setPrefSize(89, 38);
        L1.setLayoutX(110);
        L1.setLayoutY(303);
        L2.setPrefSize(89, 38);
        L2.setLayoutX(110);
        L2.setLayoutY(398);
        L1.setDisable(true);
        L2.setDisable(true);
        layout.getChildren().addAll(button, tx, tf, Tf, cb, L1, L2,tn);
        Scene scene = new Scene(layout, 778, 537);
        window.setScene(scene);
        window.show();
        new Client_receive(port, tx,cb,tn);
        tf.setOnKeyTyped(e -> {
            String old = tf.getText();
            String string = old + e.getCharacter();
            To = string;
        });
        Tf.setOnKeyTyped(e -> {
            String old = Tf.getText();
            String string = old + e.getCharacter();
            Body = string;
        });

        button.setOnAction(e -> {
            new Send_Client("asus", User, To, "127.0.0.1", Body);
            Tf.clear();
            String old = tx.getText();
            tx.setText(old + User + "     : " + Body + "\n");
        });

    }

}

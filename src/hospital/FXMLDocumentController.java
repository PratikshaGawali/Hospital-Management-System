package hospital;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Pratiksha
 */
public class FXMLDocumentController  {
    
    @FXML
    private Button btn1;
    @FXML
    private TextField t;
    @FXML
    private PasswordField p;
    @FXML
    private Label error;

    public void actionPerformed(ActionEvent e) throws IOException
    {
        if(e.getSource()==btn1 && t.getText().equals("pratiksha")&&p.getText().equals("123"))
        {
            Stage stage=(Stage) btn1.getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("Start.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            error.setText("Ooops!!TryAgain");
            p.setText("");
            t.setText("");
            p.requestFocus();
        }
    }  
}

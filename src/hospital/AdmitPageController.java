package hospital;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pratiksha
 */
public class AdmitPageController {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField pid;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField phno;
    @FXML
    private TextField address;
    @FXML
    private TextField admitDate;
    @FXML
    private TextField dischDate;
    @FXML
    private TextField room_no;
    @FXML
    private Button ok;
    @FXML
    private Button back;
    
    public void actionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException, IOException
    {
        if(e.getSource()==back)
        {
            Stage stage=(Stage)back.getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("Start.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        String s1=pid.getText();
        String s2=fname.getText();
        String s3=lname.getText();
        String s4=phno.getText();
        String s5=address.getText();
        String s6=admitDate.getText();
        String s7=dischDate.getText();
        String s8=room_no.getText();
        
        try
        {
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/PRATIKSHA","pratiksha","pratiksha123");
            PreparedStatement st=con.prepareStatement("insert into pratiksha.patient_admitted values(?, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1,Integer.parseInt(s1));
            st.setString(2, s2);
            st.setString(3, s3);
            st.setInt(4, Integer.parseInt(s4));
            st.setString(5, s5);
            st.setString(6, s6);
            st.setString(7, s7);
            st.setInt(8, Integer.parseInt(s8));
            if(e.getSource()==ok)
            {
                st.executeUpdate();
                Stage stage=(Stage)ok.getScene().getWindow();
                Parent root=FXMLLoader.load(getClass().getResource("Start.fxml"));
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}

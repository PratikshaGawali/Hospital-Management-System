package hospital;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Pratiksha
 */
public class VisitPatientController{
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField pid;
    @FXML
    private TextField pfnm;
    @FXML
    private TextField plnm;
    @FXML
    private TextField phone;
    @FXML
    private TextField pdate;
     @FXML
    private TextField paddr;
    @FXML
    private Button pok;
    @FXML
    private Button pback;
    
    public void actionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException, IOException
    {
        if(e.getSource()==pback)
        {
            Stage stage=(Stage)pback.getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("ShowVisitor.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        String s1= pid.getText();
        String s2= pfnm.getText();
        String s3= plnm.getText();
        String s4= phone.getText();
        String s5= pdate.getText();
        String s6= paddr.getText();
       
        try
        {
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/PRATIKSHA","pratiksha","pratiksha123");
            PreparedStatement st=con.prepareStatement("insert into patient_visitor values(?,?,?,?,?,?)");
            st.setInt(1,Integer.parseInt(s1));
            st.setString(2, s2);
            st.setString(3, s3);
            st.setLong(4, Long.parseLong(s4));
            st.setString(5, s6);
            st.setString(6, s5);

            if(e.getSource()==pok)
            {
                st.executeUpdate();
                Stage stage=(Stage)pok.getScene().getWindow();
                Parent root=FXMLLoader.load(getClass().getResource("Start.fxml"));
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}

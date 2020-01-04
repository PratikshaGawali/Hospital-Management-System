package hospital;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author Pratiksha
 */

public class StartController  
{
    /**
     * Initializes the controller class.
     */
    @FXML
    private Button newvisit;
    
    @FXML
    private Button newadmit;
    
    @FXML
    private Button visitinfo;
    
    @FXML
    private Button specialinfo;
    
    @FXML
    private Button generalinfo;
    
    @FXML
    private Button Logout;
        
    public void actionPerformed1(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
    {
        if(event.getSource()==newadmit)
        {
            Stage stage=(Stage) newadmit.getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("AdmitPage.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
         
        if(event.getSource()==visitinfo)
        {
            Stage stage=(Stage) visitinfo.getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("PatientDetails.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource()==newvisit)
        {
            Stage stage=(Stage) newvisit.getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("ShowVisitor.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource()==generalinfo)
        {
            try
            {
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/PRATIKSHA","pratiksha","pratiksha123");
                Statement st=con.createStatement();
                String sql="select count(p_id) from pratiksha.patient_admitted join room on patient_admitted.p_roomno=room.roomno where ward='G'";
                ResultSet rs=st.executeQuery(sql);
                while(rs.next())
                {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Room Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Rooms Available for General category: "+(10-rs.getInt(1)));
                    alert.showAndWait();
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        
        if(event.getSource()==specialinfo)
        {
            try
            {
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/PRATIKSHA","pranali","pranali123");
                Statement st=con.createStatement();
                String sql="select count(p_id) from pratiksha.patient_admitted join room on patient_admitted.p_roomno=room.roomno where ward='S'";
                ResultSet rs=st.executeQuery(sql);
                while(rs.next())
                {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Room Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Rooms Available for Special category: "+(10-rs.getInt(1)));
                    alert.showAndWait();
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        
        if(event.getSource()==Logout)
        {
            Stage stage=(Stage) Logout.getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }      
    }
}
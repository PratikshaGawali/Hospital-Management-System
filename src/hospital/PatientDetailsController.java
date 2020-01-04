package hospital;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Pratiksha
 */
public class PatientDetailsController implements Initializable
{
    @FXML
    private TableView<Admin> tableView;
    
    @FXML
    private TableColumn<Admin, Integer> idColumn;
    
    @FXML
    private TableColumn<Admin, String> fNameColumn;
    
    @FXML
    private TableColumn<Admin, String> lNameColumn;
    
    @FXML
    private TableColumn<Admin, Long> phonenoColumn;
    
    @FXML
    private TableColumn<Admin, String> addressColumn;
    
    @FXML
    private TableColumn<Admin, String> admitDateColumn;
    
    @FXML
    private TableColumn<Admin, String> dischargeDateColumn;
    
    @FXML
    private TableColumn<Admin, Integer> roomnoColumn;
    
    @FXML 
    private Button back;
    
    @FXML
    private Button search;
    
    @FXML
    private TextField searchBar;
    
    ObservableList<Admin> patient = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        idColumn.setCellValueFactory(new PropertyValueFactory<Admin, Integer> ("id"));        
        fNameColumn.setCellValueFactory(new PropertyValueFactory<Admin, String> ("firstName"));    
        lNameColumn.setCellValueFactory(new PropertyValueFactory<Admin, String> ("lastName"));
        phonenoColumn.setCellValueFactory(new PropertyValueFactory<Admin, Long> ("contact"));     
        addressColumn.setCellValueFactory(new PropertyValueFactory<Admin, String> ("address"));    
        admitDateColumn.setCellValueFactory(new PropertyValueFactory<Admin, String> ("admitDate"));
        dischargeDateColumn.setCellValueFactory(new PropertyValueFactory<Admin, String> ("dischargeDate"));
        roomnoColumn.setCellValueFactory(new PropertyValueFactory<Admin, Integer> ("roomno"));
        
        tableView.setItems(getPatients());
    }
    
    public ObservableList<Admin> getPatients()
    {
        try
        {
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/PRATIKSHA","pratiksha","pratiksha123");
            Statement st=con.createStatement();
            String sql="SELECT * FROM PRATIKSHA.PATIENT_ADMITTED";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                patient.add(new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return patient;
    }
    
    public void goBack() throws IOException
    {
        Stage stage=(Stage)back.getScene().getWindow();
        Parent root=FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void search()
    {
        FilteredList<Admin> filteredData = new FilteredList<>(patient, p -> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            filteredData.setPredicate(admin -> 
            {
                if (newValue == null || newValue.isEmpty()) 
                {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (admin.getFirstName().toLowerCase().contains(lowerCaseFilter)) 
                {
                    return true;
                } 
                else if (admin.getLastName().toLowerCase().contains(lowerCaseFilter)) 
                {
                    return true;
                }
                return false;
            });
        });

        SortedList<Admin> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
}

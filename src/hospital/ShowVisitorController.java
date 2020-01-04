package hospital;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Pratiksha
 */
public class ShowVisitorController implements Initializable
{
    @FXML
    private Button addvisitor;

    @FXML
    private TableView<Visitor> vtableView;
    
    @FXML
    private TableColumn<Visitor, Integer> vidColumn;
    
    @FXML
    private TableColumn<Visitor, String> vfNameColumn;
    
    @FXML
    private TableColumn<Visitor, String> vlNameColumn;
    
    @FXML
    private TableColumn<Visitor, Long> vphonenoColumn;
    
    @FXML
    private TableColumn<Visitor, String> vaddressColumn;
    
    @FXML
    private TableColumn<Visitor, String> vvisitDateColumn;
    
    @FXML 
    private Button back;
    
    @FXML
    private Button search;
    
    @FXML
    private TextField searchBar;
    
    ObservableList<Visitor> visitor = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        vidColumn.setCellValueFactory(new PropertyValueFactory<Visitor, Integer> ("vid"));        
        vfNameColumn.setCellValueFactory(new PropertyValueFactory<Visitor, String> ("vfirstName"));    
        vlNameColumn.setCellValueFactory(new PropertyValueFactory<Visitor, String> ("vlastName"));
        vphonenoColumn.setCellValueFactory(new PropertyValueFactory<Visitor, Long> ("vcontact")); 
        vvisitDateColumn.setCellValueFactory(new PropertyValueFactory<Visitor, String> ("vvisitDate"));    
        vaddressColumn.setCellValueFactory(new PropertyValueFactory<Visitor, String> ("vaddress"));    
        
        vtableView.setItems(getVisitors());
    }
    
    public ObservableList<Visitor> getVisitors()
    {
        try
        {
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/PRATIKSHA","pratiksha","pratiksha123");
            Statement st=con.createStatement();
            String sql="SELECT * FROM PRATIKSHA.PATIENT_VISITOR";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                visitor.add(new Visitor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6)));
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return visitor;
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
        FilteredList<Visitor> filteredData = new FilteredList<>(visitor, p -> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            filteredData.setPredicate(visitor2 -> 
            {
                if (newValue == null || newValue.isEmpty()) 
                {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (visitor2.getVfirstName().toLowerCase().contains(lowerCaseFilter)) 
                {
                    return true;
                } 
                else if (visitor2.getVlastName().toLowerCase().contains(lowerCaseFilter)) 
                {
                    return true;
                }
                return false;
            });
        });

        SortedList<Visitor> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(vtableView.comparatorProperty());
        vtableView.setItems(sortedData);
    }
    
    public void addVisitor(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
    {
        if(event.getSource()==addvisitor)
        {
            Stage stage=(Stage)addvisitor.getScene().getWindow();
            Parent root=FXMLLoader.load(getClass().getResource("VisitPatient.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}

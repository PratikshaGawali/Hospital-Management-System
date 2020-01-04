package hospital;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author pratiksha
 */
public class Admin 
{
    private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private LongProperty contact;
    private StringProperty address;
    private StringProperty admitDate;
    private StringProperty dischargeDate;
    private IntegerProperty roomno;
    
    public Admin()
    {
        id = null;
        firstName = null;
        lastName = null;
        contact = null;
        address = null;
        admitDate = null;
        dischargeDate = null;
        roomno = null;
    }
    
    public Admin(int id, String firstName, String lastName, Long contact, String address, String admitDate, String dischargeDate, int roomno)
    {
        super();
        this.id=new SimpleIntegerProperty(id);
        this.firstName=new SimpleStringProperty(firstName);
        this.lastName=new SimpleStringProperty(lastName);
        this.contact=new SimpleLongProperty(contact);
        this.address=new SimpleStringProperty(address);
        this.admitDate=new SimpleStringProperty(admitDate);
        this.dischargeDate=new SimpleStringProperty(dischargeDate);
        this.roomno=new SimpleIntegerProperty(roomno);
    }
    
    public int getId()
    {
        return id.get();
    }
    
    public void setId(SimpleIntegerProperty id)
    {
        this.id = id;
    }
    
    public String getFirstName()
    {
        return firstName.get();
    }
    
    public void setFirstName(SimpleStringProperty firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName.get();
    }
    
    public void setLastName(SimpleStringProperty lastName)
    {
        this.lastName = lastName;
    }
    
    public Long getContact()
    {
        return contact.get();
    }
    
    public void setContact(SimpleLongProperty contact)
    {
        this.contact = contact;
    }
    
    public String getAddress()
    {
        return address.get();
    }
    
    public void setAddress(SimpleStringProperty address)
    {
        this.address = address;
    }
    
    public String getAdmitDate()
    {
        return admitDate.get();
    }
    
    public void setAdmitDate(SimpleStringProperty admitDate)
    {
        this.admitDate = admitDate;
    }
    
    public String getDischargeDate()
    {
        return dischargeDate.get();
    }
    
    public void setDischargeDate(SimpleStringProperty dischargeDate)
    {
        this.dischargeDate = dischargeDate;
    }
    
    public int getRoomno()
    {
        return roomno.get();
    }
    
    public void setRoomno(SimpleIntegerProperty roomno)
    {
        this.roomno = roomno;
    }
}

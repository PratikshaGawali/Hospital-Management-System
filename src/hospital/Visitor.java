/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Pratiksha
 */
public class Visitor 
{
    private IntegerProperty vid;
    private StringProperty vfirstName;
    private StringProperty vlastName;
    private LongProperty vcontact;
    private StringProperty vaddress;
    private StringProperty vvisitDate;
    
    public Visitor()
    {
        vid = null;
        vfirstName = null;
        vlastName = null;
        vcontact = null;
        vaddress = null;
        vvisitDate = null;
    }
    
    public Visitor(int vid, String vfirstName, String vlastName, Long vcontact, String vaddress, String vvisitDate)
    {
        super();
        this.vid=new SimpleIntegerProperty(vid);
        this.vfirstName=new SimpleStringProperty(vfirstName);
        this.vlastName=new SimpleStringProperty(vlastName);
        this.vcontact=new SimpleLongProperty(vcontact);
        this.vaddress=new SimpleStringProperty(vaddress);
        this.vvisitDate=new SimpleStringProperty(vvisitDate);
    }
    
    public int getVid()
    {
        return vid.get();
    }
    
    public void setVid(SimpleIntegerProperty vid)
    {
        this.vid = vid;
    }
    
    public String getVfirstName()
    {
        return vfirstName.get();
    }
    
    public void setVfirstName(SimpleStringProperty vfirstName)
    {
        this.vfirstName = vfirstName;
    }
    
    public String getVlastName()
    {
        return vlastName.get();
    }
    
    public void setVlastName(SimpleStringProperty vlastName)
    {
        this.vlastName = vlastName;
    }
    
    public Long getVcontact()
    {
        return vcontact.get();
    }
    
    public void setVcontact(SimpleLongProperty vcontact)
    {
        this.vcontact = vcontact;
    }
    
    public String getVaddress()
    {
        return vaddress.get();
    }
    
    public void setVaddress(SimpleStringProperty vaddress)
    {
        this.vaddress = vaddress;
    }
    
    public String getVvisitDate()
    {
        return vvisitDate.get();
    }
    
    public void setVvisitDate(SimpleStringProperty vvisitDate)
    {
        this.vvisitDate = vvisitDate;
    }
}

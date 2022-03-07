
package automobile_estate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEV SASMAL
 */
public class C_OWNER {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    
    public int getId()
    {
        return this.id;
    }
    public void setId(int ID)
    {
        this.id = ID;
    }
    public String getFname()
    {
        return this.firstName;
    }
    public void setFname(String FNAME)
    {
        this.firstName = FNAME;
    }
    public String getLname()
    {
        return this.lastName;
    }
    public void setLname(String LNAME)
    {
        this.lastName = LNAME;
    }
    public String getPhone()
    {
        return this.phone;
    }
    public void setPhone(String PHONE)
    {
        this.phone = PHONE;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String EMAIL)
    {
        this.email = EMAIL;
    }
    public String getAddress()
    {
        return this.address;
    }
    public void setAddress(String ADDRESS)
    {
        this.address = ADDRESS;
    }
    
    public C_OWNER() {}
    
    public C_OWNER(int ID,String FNAME,String LNAME,String PHONE,String EMAIL,String ADDRESS)
    {
        this.id = ID;
        this.firstName = FNAME;
        this.lastName = LNAME;
        this.phone = PHONE;
        this.email = EMAIL;
        this.address = ADDRESS;
    }
    
    //create a function to add a new owner 
    //first create the owner in the database
    public boolean addNewOwner(C_OWNER owner)
    {
        PreparedStatement ps;
        String addQuery ="INSERT INTO `car_owner`(`fname`, `lname`, `phone`, `email`, `address`) VALUES (?,?,?,?,?)";
        
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
            ps.setString(1,owner.getFname());
            ps.setString(2,owner.getLname());
            ps.setString(3,owner.getPhone());
            ps.setString(4,owner.getEmail());
            ps.setString(5,owner.getAddress());
            
            return (ps.executeUpdate() > 0);
              
            
        } catch (SQLException ex) {
            Logger.getLogger(C_OWNER.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
    
    //create a function to edit the selected owner data
    public boolean editOwnerData(C_OWNER owner)
    {
       PreparedStatement ps;
        String editQuery ="UPDATE `car_owner` SET `fname`=?,`lname`=?,`phone`=?,`email`=?,`address`=? WHERE `id`=?";
        
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(editQuery);
            ps.setString(1,owner.getFname());
            ps.setString(2,owner.getLname());
            ps.setString(3,owner.getPhone());
            ps.setString(4,owner.getEmail());
            ps.setString(5,owner.getAddress());
            ps.setInt(6, owner.getId());
            
            return (ps.executeUpdate() > 0);
              
            
        } catch (SQLException ex) {
            Logger.getLogger(C_OWNER.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }  
    }
    //create a function to delete the selected owner 
    public boolean deleteOwner(int ownerId)
    {
        PreparedStatement ps;
        String deleteQuery ="DELETE FROM `car_owner` WHERE `id`=?";
        
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(deleteQuery);
            ps.setInt(1, ownerId);
            
            return (ps.executeUpdate() > 0);
              
            
        } catch (SQLException ex) {
            Logger.getLogger(C_OWNER.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
    
    //create a function to return an arraylist of owners
    public ArrayList<C_OWNER> ownerList()
    {
        ArrayList<C_OWNER> list = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `car_owner` ";
        
        try {
            st = THE_CONNECTION.getTheConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            
            C_OWNER owner;
            
            while(rs.next())
            {
                owner = new C_OWNER(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                
                list.add(owner);
            }
        } catch (SQLException ex) {
            Logger.getLogger(C_OWNER.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
    }
}

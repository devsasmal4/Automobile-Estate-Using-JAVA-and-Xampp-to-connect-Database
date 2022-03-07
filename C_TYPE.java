/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobile_estate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author DEV SASMAL
 */
public class C_TYPE {
    
    private int id;
    private String name;
    private String descp;
    
    //creating the inputs and showing outputs
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer ID)
    {
         this.id = ID;
    }
            
    public String getName()
    {
        return name;
    }
    public void setName(String NAME)
    {
        this.name = NAME;
    }
    public String getDescp()
    {
        return this.descp;
    }
    public void setDescp(String DESCP)
    {
        this.descp = DESCP;
    }
    
    //constructors
    public C_TYPE() {}
    
    public C_TYPE(Integer ID,String NAME,String DESCP)
    {
        this.id = ID;
        this.name = NAME;
        this.descp = DESCP;
    }
    //create a mathods to insert -edit -remove type
    public boolean execTypeQuery(String queryType,C_TYPE type)
    {
        PreparedStatement ps;
        
        //add anew type
        if(queryType.equals("add"))
        {
            try {
                //query -> Insert into C_type
                ps = THE_CONNECTION.getTheConnection().prepareStatement("INSERT INTO `car_type`(`name`, `descp`) VALUES (?,?)");
                ps.setString(1, type.getName());
                ps.setString(2, type.getDescp());
                
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                Logger.getLogger(C_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        else if(queryType.equals("edit"))
        {
            try {
                //query -> Update C_type
                ps = THE_CONNECTION.getTheConnection().prepareStatement("UPDATE `car_type` SET `name`=?,`descp`=? WHERE `id` =?");
                ps.setString(1, type.getName());
                ps.setString(2, type.getDescp());
                ps.setInt(3,type.getId());
                
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                Logger.getLogger(C_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        
        else if(queryType.equals("remove"))
        {
            try {
                //query -> Update C_type
                ps = THE_CONNECTION.getTheConnection().prepareStatement("DELETE FROM `car_type` WHERE `id`=?");
                ps.setInt(1,type.getId());
                
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                Logger.getLogger(C_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter The Correct Query( add,edit,remove )", "Invalid Operation", id);
            return false;
        }
    }

     //create a function to return a lsit of all types in a HashMap   
    public HashMap<String,Integer> getTypesMap()
    {
        HashMap<String, Integer> map = new HashMap();
        
        Statement st;
        ResultSet rs;
        
        try {
            st = THE_CONNECTION.getTheConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM `car_type`");
            
            C_TYPE type;
            
            while(rs.next())
            {
                type = new C_TYPE(rs.getInt(1), rs.getString(2),rs.getString(3));
                
                map.put(type.getName(), type.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(C_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    //create a function to get a type data by id
    //we can use getTYpesMap() function to get id and name
    //but we want the description to
    public C_TYPE getTypeById(Integer id)
    {
        PreparedStatement ps;
        ResultSet rs;
        
        C_TYPE type = new C_TYPE();
        
        try {
              ps = THE_CONNECTION.getTheConnection().prepareStatement("SELECT * FROM `car_type` WHERE `id` =?");
              ps.setInt(1, id);
               rs = ps.executeQuery();
               
               if(rs.next())
               {
                   type.setId(id);
                   type.setName(rs.getString(2));
                   type.setDescp(rs.getString(3));
               }
          } 
             catch (SQLException ex) {
            Logger.getLogger(C_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        }  
          return type;   
    }
}

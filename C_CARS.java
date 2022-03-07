/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobile_estate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DEV SASMAL
 */
public class C_CARS {
    
    private int ids;
    private String car_Model;
    private int car_Make;
    private int ownerId;
    private int price;
    private String address;
    private int seats;
    private int air_bags;
    private int engine;
    private int doors;
    private int fuel_capa;
    private String fuel_type;
    private boolean parking_sensors;
    private boolean antilock;
    private boolean roof;
    private int age;
    private boolean camera;
    private boolean voice;
    private boolean antitheft;
    private boolean fingerprint;
    private boolean maps;
    private boolean speed_sensors;
    private boolean crash_sensors;


    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getCar_Model() {
        return car_Model;
    }

    public void setCar_Model(String car_Model) {
        this.car_Model = car_Model;
    }

    public int getCar_Make() {
        return car_Make;
    }

    public void setCar_Make(int car_Make) {
        this.car_Make = car_Make;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getAir_bags() {
        return air_bags;
    }

    public void setAir_bags(int air_bags) {
        this.air_bags = air_bags;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
    
    public int getFuel_capa() {
        return fuel_capa;
    }

    public void setFuel_capa(int fuel_capa) {
        this.fuel_capa = fuel_capa;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public boolean isParking_sensors() {
        return parking_sensors;
    }

    public void setParking_sensors(boolean parking_sensors) {
        this.parking_sensors = parking_sensors;
    }

    public boolean isAntilock() {
        return antilock;
    }

    public void setAntilock(boolean antilock) {
        this.antilock = antilock;
    }

    public boolean isRoof() {
        return roof;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCamera() {
        return camera;
    }

    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public boolean isVoice() {
        return voice;
    }

    public void setVoice(boolean voice) {
        this.voice = voice;
    }

    public boolean isAntitheft() {
        return antitheft;
    }

    public void setAntitheft(boolean antitheft) {
        this.antitheft = antitheft;
    }

    public boolean isFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(boolean fingerprint) {
        this.fingerprint = fingerprint;
    }

    public boolean isMaps() {
        return maps;
    }

    public void setMaps(boolean maps) {
        this.maps = maps;
    }

    public boolean isSpeed_sensors() {
        return speed_sensors;
    }

    public void setSpeed_sensors(boolean speed_sensors) {
        this.speed_sensors = speed_sensors;
    }

    public boolean isCrash_sensors() {
        return crash_sensors;
    }

    public void setCrash_sensors(boolean crash_sensors) {
        this.crash_sensors = crash_sensors;
    }
    
            
    public C_CARS() {}
    public C_CARS(int IDS, String CAR_MODEL,int CAR_MAKE, int OWNERID,int PRICE, String ADDRESS,
                  int SEATS, int AIR_BAGS,int ENGINE,int DOORS, int FUEL_CAPA, String FUEL_TYPE,
                  boolean PARKING_SENSORS,boolean ANTILOCK, boolean ROOF,int AGE,boolean CAMERA,
                  boolean VOICE,boolean ANTITHEFT,boolean FINGERPRINT,boolean MAPS,boolean SPEED_SENSORS,boolean CRASH_SENSORS)
    {
        this.ids = IDS;
        this.car_Model = CAR_MODEL;
        this.car_Make = CAR_MAKE;
        this.ownerId = OWNERID;
        this.price = PRICE;
        this.address = ADDRESS;
        this.seats = SEATS;
        this.air_bags = AIR_BAGS;
        this.engine = ENGINE;
        this.doors = DOORS;
        this.fuel_capa = FUEL_CAPA;
        this.fuel_type = FUEL_TYPE;
        this.parking_sensors = PARKING_SENSORS;
        this.antilock = ANTILOCK;
        this.roof = ROOF;
        this.age = AGE;
        this.camera = CAMERA;
        this.voice = VOICE;
        this.antitheft = ANTITHEFT;
        this.fingerprint = FINGERPRINT;
        this.maps = MAPS;
        this.speed_sensors = SPEED_SENSORS;
        this.crash_sensors = CRASH_SENSORS;
    }
    //create a function to add a new car
    public boolean addNewCars(C_CARS cars)
    {
         PreparedStatement ps;
        String addQuery ="INSERT INTO `cars`(`car_model`, `car_make`, `ownerid`, `price`, `address`, `seats`, `air_bags`, `engine`, `doors`, `fuel_capa`, `fuel_type`, `parking_sensors`, `antilock`, `roof`, `age`, `camera`, `voice`, `antitheft`, `fingerprint`, `maps`, `speed_sensors`, `crash_sensors`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
            ps.setString(1,cars.getCar_Model());
            ps.setInt(2,cars.getCar_Make());
            ps.setInt(3,cars.getOwnerId());
            ps.setInt(4,cars.getPrice());
            ps.setString(5,cars.getAddress());
            ps.setInt(6,cars.getSeats());
            ps.setInt(7,cars.getAir_bags());
            ps.setInt(8,cars.getEngine());
            ps.setInt(9,cars.getDoors());
            ps.setInt(10,cars.getFuel_capa());
            ps.setString(11,cars.getFuel_type());
            ps.setBoolean(12,cars.isParking_sensors());
            ps.setBoolean(13,cars.isAntilock());
            ps.setBoolean(14,cars.isRoof());
            ps.setInt(15,cars.getAge());
            ps.setBoolean(16,cars.isCamera());
            ps.setBoolean(17,cars.isVoice());
            ps.setBoolean(18,cars.isAntitheft());
            ps.setBoolean(19,cars.isFingerprint());
            ps.setBoolean(20,cars.isMaps());
            ps.setBoolean(21,cars.isSpeed_sensors());
            ps.setBoolean(22,cars.isCrash_sensors());
            
            return (ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    //create a function to edit a new car
    public boolean editCars(C_CARS cars)
    {
        PreparedStatement ps;
        String editQuery ="UPDATE `cars` SET `car_model`=?,`car_make`=?,`ownerid`=?,`price`=?,`address`=?,`seats`=?,`air_bags`=?,`engine`=?,`doors`=?,`fuel_capa`=?,`fuel_type`=?,`parking_sensors`=?,`antilock`=?,`roof`=?,`age`=?,`camera`=?,`voice`=?,`antitheft`=?,`fingerprint`=?,`maps`=?,`speed_sensors`=?,`crash_sensors`=? WHERE `id` = ?";
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(editQuery);
            ps.setString(1,cars.getCar_Model());
            ps.setInt(2,cars.getCar_Make());
            ps.setInt(3,cars.getOwnerId());
            ps.setInt(4,cars.getPrice());
            ps.setString(5,cars.getAddress());
            ps.setInt(6,cars.getSeats());
            ps.setInt(7,cars.getAir_bags());
            ps.setInt(8,cars.getEngine());
            ps.setInt(9,cars.getDoors());
            ps.setInt(10,cars.getFuel_capa());
            ps.setString(11,cars.getFuel_type());
            ps.setBoolean(12,cars.isParking_sensors());
            ps.setBoolean(13,cars.isAntilock());
            ps.setBoolean(14,cars.isRoof());
            ps.setInt(15,cars.getAge());
            ps.setBoolean(16,cars.isCamera());
            ps.setBoolean(17,cars.isVoice());
            ps.setBoolean(18,cars.isAntitheft());
            ps.setBoolean(19,cars.isFingerprint());
            ps.setBoolean(20,cars.isMaps());
            ps.setBoolean(21,cars.isSpeed_sensors());
            ps.setBoolean(22,cars.isCrash_sensors());
            ps.setInt(23,cars.getIds());
            
            return (ps.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    //create a function to delete a new car
    public boolean removeCars(int ids)
    {
        PreparedStatement ps;
        String deleteQuery ="DELETE FROM `cars` WHERE `id`=?";
        
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(deleteQuery);
            ps.setInt(1, ids);
            
            return (ps.executeUpdate() > 0);
              
            
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
    
    //create a function to delete a new car
    public C_CARS searchCars(int ids)
    {
        PreparedStatement ps;
        ResultSet rs;
        C_CARS cars = null;
        
        String searchQuery="SELECT * FROM `cars` WHERE `id` = ?";
        
        try {
            
            ps = THE_CONNECTION.getTheConnection().prepareStatement(searchQuery);
            ps.setInt(1,ids);
            rs = ps.executeQuery();           
            if(rs.next())
            {
              cars = new C_CARS(rs.getInt("id"), 
                                rs.getString("car_model"), 
                                rs.getInt("car_make"), 
                                rs.getInt("ownerid"), 
                                rs.getInt("price"), 
                                rs.getString("address"), 
                                rs.getInt("seats"), 
                                rs.getInt("air_bags"), 
                                rs.getInt("engine"), 
                                rs.getInt("doors"), 
                                rs.getInt("fuel_capa"), 
                                rs.getString("fuel_type"), 
                                rs.getBoolean("parking_sensors"),
                                rs.getBoolean("antilock"), 
                                rs.getBoolean("roof"), 
                                rs.getInt("age"), 
                                rs.getBoolean("camera"), 
                                rs.getBoolean("voice"), 
                                rs.getBoolean("antitheft"), 
                                rs.getBoolean("fingerprint"), 
                                rs.getBoolean("maps"), 
                                rs.getBoolean("speed_sensors"), 
                                rs.getBoolean("crash_sensors"));
              
              return cars;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cars;
    }
    //create a function to return an arraylist of cars
    public ArrayList<C_CARS> carsList()
    {
        
         ArrayList<C_CARS> list = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `cars` ";
        
        try {
            st = THE_CONNECTION.getTheConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            
            C_CARS cars;
            
            while(rs.next())
            {
                cars = new C_CARS(rs.getInt("id"), 
                                rs.getString("car_model"), 
                                rs.getInt("car_make"), 
                                rs.getInt("ownerid"), 
                                rs.getInt("price"), 
                                rs.getString("address"), 
                                rs.getInt("seats"), 
                                rs.getInt("air_bags"), 
                                rs.getInt("engine"), 
                                rs.getInt("doors"), 
                                rs.getInt("fuel_capa"), 
                                rs.getString("fuel_type"), 
                                rs.getBoolean("parking_sensors"),
                                rs.getBoolean("antilock"), 
                                rs.getBoolean("roof"), 
                                rs.getInt("age"), 
                                rs.getBoolean("camera"), 
                                rs.getBoolean("voice"), 
                                rs.getBoolean("antitheft"), 
                                rs.getBoolean("fingerprint"), 
                                rs.getBoolean("maps"), 
                                rs.getBoolean("speed_sensors"), 
                                rs.getBoolean("crash_sensors"));
                
                list.add(cars);
            }
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
    }


    //create a function to return a list of cars depending on the selected type
    //create a function to return an arraylist of cars
    public ArrayList<C_CARS> carsListByCarmake(int carmakes)
    {
        
         ArrayList<C_CARS> list = new ArrayList<>();
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `cars` WHERE `car_make` = ?";
        
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
            ps.setInt(1, carmakes);
            rs = ps.executeQuery();
            
            C_CARS cars;
            
            while(rs.next())
            {
                cars = new C_CARS(rs.getInt("id"), 
                                rs.getString("car_model"), 
                                rs.getInt("car_make"), 
                                rs.getInt("ownerid"), 
                                rs.getInt("price"), 
                                rs.getString("address"), 
                                rs.getInt("seats"), 
                                rs.getInt("air_bags"), 
                                rs.getInt("engine"), 
                                rs.getInt("doors"), 
                                rs.getInt("fuel_capa"), 
                                rs.getString("fuel_type"), 
                                rs.getBoolean("parking_sensors"),
                                rs.getBoolean("antilock"), 
                                rs.getBoolean("roof"), 
                                rs.getInt("age"), 
                                rs.getBoolean("camera"), 
                                rs.getBoolean("voice"), 
                                rs.getBoolean("antitheft"), 
                                rs.getBoolean("fingerprint"), 
                                rs.getBoolean("maps"), 
                                rs.getBoolean("speed_sensors"), 
                                rs.getBoolean("crash_sensors"));
                
                list.add(cars);
            }
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
    }

    
     //create a function to add images
    public boolean addImages(int car_id,String the_image_path)
    {
         PreparedStatement ps;
        String addQuery ="INSERT INTO `car_images`(`car_id`, `the_image`) VALUES (?,?)";
        try {
             try {
                 FileInputStream carimage = new FileInputStream(new File(the_image_path));
                 
                 ps = THE_CONNECTION.getTheConnection().prepareStatement(addQuery);
                 ps.setInt(1,car_id);
                 ps.setBinaryStream(2,carimage);
                 
                 return (ps.executeUpdate() > 0);
            
             } catch (FileNotFoundException ex) {
                 //Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null,ex.getMessage()+"Invalid File", "Image Error",2);
                 return false;
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    //create a function to get the selected car list of image list
    public HashMap<byte[], Integer> carImageList(int carid)
    {
        
         HashMap<byte[], Integer> list = new HashMap<byte[], Integer>();
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `car_images` WHERE `car_id` = ?";
        
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
            ps.setInt(1, carid);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                list.put(rs.getBytes("the_image"),rs.getInt("id"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
    }
 
    
     //create a function to get image by id
    public byte[] getImageById(int imageid)
    {     
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT `the_image` FROM `car_images` WHERE `id` = ?";
        
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(selectQuery);
            ps.setInt(1, imageid);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                return rs.getBytes("the_image");
            }
            else
            {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
            return null; 
        }
    }
    
     //create a function to remove image by id
    public boolean removeCarImage(int imageid)
    {     
        PreparedStatement ps;
        ResultSet rs;
        
        String deleteQuery = "DELETE FROM `car_images` WHERE `id` = ?";
        
        try {
            ps = THE_CONNECTION.getTheConnection().prepareStatement(deleteQuery);
            ps.setInt(1, imageid);
           
            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(C_CARS.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        }
    }
    
}

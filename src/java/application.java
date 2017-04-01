
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Priyamvada
 */
public class application {
   private int applicationId;
    private String userId;
    private int jobId;
    public String appStatus;
    private String uname;
    private int age;
    private String phone;
    private String email;
    
    
    private job appJob;
    private user appUser;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public job getAppJob() {
        return appJob;
    }

    public void setAppJob(job appJob) {
        this.appJob = appJob;
    }

    public user getAppUser() {
        return appUser;
    }

    public void setAppUser(user appUser) {
        this.appUser = appUser;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public application(int applicationId, String userId, int jobId, String appStatus, String uname, int age, String phone, String email) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.jobId = jobId;
        this.appStatus = appStatus;
        this.uname = uname;
        this.age = age;
        this.phone = phone;
        this.email = email;
      
    }

    
    
             
    public void getAppJobDetails(int jid){
    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //return ("Internal Error, Please try again later");
        }
        
        //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
        
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
        
            //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
             connection = DriverManager.getConnection(DB_URL,"seerapup8892","1347006");
            
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("Select * from job where jid='"+jid+"'");
            
            if(resultSet.next()) {                
                
                appJob = (new job(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(4),"1st Jan 2015", resultSet.getInt(3), "notsent"));
            }
            //int r = statement.executeUpdate("insert into job values('test123','"+jobTitle+ "','" +postions+ "','" + jobdesc+ "','notsent')");
            
            //return ("Job Posted!");
        }
        catch(SQLException e){
        
            e.printStackTrace();
            //return ("Internal Error. Please Try Again Later");
        }
        
        finally{
        
            try{
            
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e){
            
                e.printStackTrace();
            }
        }

    }
    
    public void getAppUserDetails(String uid){
    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //return ("Internal Error, Please try again later");
        }
        
        //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
        
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
        
            //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
             connection = DriverManager.getConnection(DB_URL,"seerapup8892","1347006");
            
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("Select * from accounts where AID='"+uid+"'");
            
            if(resultSet.next()) {                
                
                appUser = (new user(resultSet.getString(1), resultSet.getString(2), resultSet.getString(4)));
                    
            }
            //int r = statement.executeUpdate("insert into job values('test123','"+jobTitle+ "','" +postions+ "','" + jobdesc+ "','notsent')");
            
            //return ("Job Posted!");
        }
        catch(SQLException e){
        
            e.printStackTrace();
            //return ("Internal Error. Please Try Again Later");
        }
        
        finally{
        
            try{
            
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e){
            
                e.printStackTrace();
            }
        }

    }
    
    public void getApplicationDetails(int aid){
    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //return ("Internal Error, Please try again later");
        }
        
        //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
        
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
        
            //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
             connection = DriverManager.getConnection(DB_URL,"seerapup8892","1347006");
            
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("Select * from application where ApplicationID='"+aid+"'");
            
            if(resultSet.next()) {                
                
                    uname = resultSet.getString(6);
                    age = resultSet.getInt(7);
                    phone = resultSet.getString(8);
                    email = resultSet.getString(9);
            }
            //int r = statement.executeUpdate("insert into job values('test123','"+jobTitle+ "','" +postions+ "','" + jobdesc+ "','notsent')");
            
            //return ("Job Posted!");
        }
        catch(SQLException e){
        
            e.printStackTrace();
            //return ("Internal Error. Please Try Again Later");
        }
        
        finally{
        
            try{
            
                connection.close();
                statement.close();
                resultSet.close();
            }
            catch(Exception e){
            
                e.printStackTrace();
            }
        }

    }  
}

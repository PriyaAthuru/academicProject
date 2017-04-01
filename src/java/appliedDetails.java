/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Priyamvada
 */
@ManagedBean
@RequestScoped
public class appliedDetails {
    public static int job_id;
    public static String User_id;
    Boolean Applied = false;
    Boolean Allowwd = false;
    int jid;
    List<applicationDetails> appliedjobs = new ArrayList<applicationDetails>();
  //  private applicationForm newform;

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String User_id) {
        this.User_id = User_id;
    }

    public List<applicationDetails> getAppliedjobs() {
        return appliedjobs;
    }

    public void setAppliedjobs(List<applicationDetails> appliedjobs) {
        this.appliedjobs = appliedjobs;
    }

    public String appliedJobs(String User_id)
    {
     setUser_id(User_id);
     return ("appliedJobs");
    }
        
    /**
     * Creates a new instance of appliedDetails
     */
    public List<applicationDetails> jobsapplied()
    {  
        
        appliedjobs.clear();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null; 
            
        }
        final String DATABSE_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";
        
        
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultset = null;
        Statement statement1 = null;
        ResultSet resultset1 = null;
        try
        {
            connection = DriverManager.getConnection(DATABSE_URL,"seerapup8892","1347006");
            statement = connection.createStatement();//set of results
            statement1 = connection.createStatement();
            resultset = statement.executeQuery("select * from application where ApplicantID = '"+User_id+"'");                     
            while(resultset.next())
            {
            jid = resultset.getInt(3);
            applicationDetails aNewone = new applicationDetails(resultset.getInt(1),resultset.getInt(3),resultset.getString(5),resultset.getString(2),null);
            appliedjobs.add(aNewone);
            resultset1 = statement1.executeQuery("select * from job where JID ='"+jid+"'");
            if(resultset1.next())
            {
                aNewone.setAppjob(resultset1.getString(2));
             if(!(resultset1.getString(5).equals("sent"))) 
             {
              aNewone.setApplicationStatus("reviewing");             
             }
            }
            }
           return appliedjobs;
          
            }
        catch(SQLException e)
        {
            //Handle the exceptions
            
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                resultset.close();
                statement.close();
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }
    }
 /*   public String applicationWd(String User_id,String Job_id) {      
        setJob_id(Job_id);
        setUser_id(User_id);
        return ("index");
    } */
     public String appliedDetails(String User_id,int job_id) {
        setJob_id(job_id);
        setUser_id(User_id);       
  //      return ("jobApplication");
        return ("applicationWithDraw");
    }
    public String applicationWithDraw()
    {
        String appstatus;    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return("Internal Error");        
        }
        final String DATABSE_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";
        
        
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultset = null;
        Statement statement1 = null;
        ResultSet resultset1 = null;
        try
        {
            connection = DriverManager.getConnection(DATABSE_URL,"seerapup8892","1347006");
            statement = connection.createStatement();//set of results
            statement1 = connection.createStatement();
            resultset = statement.executeQuery("select * from application where ApplicantID = '"+User_id+"' and JobID = '"+job_id+"'");
            if(resultset.next())
            {
            appstatus = resultset.getString(5);
            jid = resultset.getInt(3);
            resultset1 = statement1.executeQuery("SELECT * FROM `job` WHERE JID = '"+jid+"'");
            if(resultset1.next())
            {
             if((resultset1.getString(5).equals("sent"))|| appstatus.equals("Selected")|| appstatus.equals("Rejected")) 
             {
                   Allowwd = false;
             }
                else
                {
                    Allowwd = true;
                   
                }
            }
            }
            if(Allowwd)
            {
               int r = statement.executeUpdate("delete from application where ApplicantID = '"+User_id+"' and JobID = '"+job_id+"'");
           //    return("You have successfully withdrawn your application");
              return "Application withdrawal successful ";  
            }
            else
            {
               return "Sorry!!you cannot withdraw your application";  
            }
        }
        catch(SQLException e)
        {
            //Handle the exceptions
            
            e.printStackTrace();
            return("Internal Error"); 
        }
        finally
        {
            try
            {
                resultset.close();
                resultset1.close();
                statement.close();
                statement1.close();
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return("Internal Error");  
            }
        } 
    }
    
    }
    

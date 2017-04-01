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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Priyamvada
 */
@ManagedBean
@RequestScoped
public class applicationForm {
    public static String Login_id;
    public static int JOB_ID;
    private String ApplicationID;
    private String AppFullName;
    private int AppAge;
    private String AppPhone;
    private String ContactEmail;
    private String REducation;
    private int Experience;
    String ApplicationStatus;
    String HRID = "1002";
    public String getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(String ApplicationID) {
        this.ApplicationID = ApplicationID;
    }

    public String getAppFullName() {
        return AppFullName;
    }

    public void setAppFullName(String AppFullName) {
        this.AppFullName = AppFullName;
    }

    public int getAppAge() {
        return AppAge;
    }

    public void setAppAge(int AppAge) {
        this.AppAge = AppAge;
    }

    public String getAppPhone() {
        return AppPhone;
    }

    public void setAppPhone(String AppPhone) {
        this.AppPhone = AppPhone;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String ContactEmail) {
        this.ContactEmail = ContactEmail;
    }
    
    public String getLogin_id() {
        return Login_id;
    }

    public void setLogin_id(String Login_id) {
        this.Login_id = Login_id;
    }

    public int getJOB_ID() {
        return JOB_ID;
    }

    public void setJOB_ID(int JOB_ID) {
        this.JOB_ID = JOB_ID;
    }

    public String getREducation() {
        return REducation;
    }

    public void setREducation(String REducation) {
        this.REducation = REducation;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }
    
public applicationForm()
{
    
}
    /**
     * Creates a new instance of applicationForm
     */
    public String applicationForm(String Login_id,int JOB_ID) 
    {
      setLogin_id(Login_id);
      setJOB_ID(JOB_ID);
  // return ("confirmation");
      return ("applicationForm");
    }
    public String applicationDetails()
    {
        ApplicationID = "2";
        ApplicationStatus = "Pending";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ("Internal Error");           
        }
        final String DATABSE_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";
        
        
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultset = null;
        try
        {
            connection = DriverManager.getConnection(DATABSE_URL,"seerapup8892","1347006");
            statement = connection.createStatement();//set of results
            resultset = statement.executeQuery("select * from application where ApplicantID = '"+Login_id+"' and JobID='"+JOB_ID+"'");          
            
            if(resultset.next())
            {     
             return ("notSuccessful");             
            }
            else
            {
               int r = statement.executeUpdate("INSERT INTO `application`(`ApplicantID`, `JobID`, `HRID`, `ApplicationStatus`, `FullName`, `Age`, `Phone`, `ContactEmail`, `RecentEducation`, `Experience`) VALUES ('"+Login_id+"','"+JOB_ID+"','"+HRID+"','"+ApplicationStatus+"','"+AppFullName+"','"+AppAge+"','"+AppPhone+"','"+ContactEmail+"','"+REducation+"','"+Experience+"')");
                return ("confirmation");
            }
        }
        catch(SQLException e)
        {
            //Handle the exceptions          
            e.printStackTrace();
            return ("Internal Error");
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
                return ("Internal Error");
            }
        }
    }
}   

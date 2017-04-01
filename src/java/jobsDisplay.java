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
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Priyamvada
 */
@ManagedBean
@RequestScoped
public class jobsDisplay {
    /**
     * Creates a new instance of jobsDisplay
     */

    public jobsDisplay()
    {
        
    }
    public List<viewJobs> showJobs() {
    List<viewJobs> jobdisplay = new ArrayList<viewJobs>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        }
        catch (Exception e)
        {
            return null;
            
        }
       final String DATABSE_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";
       
        
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultset = null;
        try
        {
         connection = DriverManager.getConnection(DATABSE_URL,"seerapup8892","1347006");
         statement = connection.createStatement();//set of results
         resultset = statement.executeQuery("select * from job");
         while(resultset.next())
             {
                 if(resultset.getString(5).equals("notsent"))
                 {
               viewJobs aNewOne = new viewJobs(resultset.getInt(1),resultset.getString(2),resultset.getInt(3),resultset.getString(4));
           //  viewJobs aNewOne = new viewJobs("A","B",1,"C");
               jobdisplay.add(aNewOne);
                 }
            }
         return jobdisplay;
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
}

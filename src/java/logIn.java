/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.xml.ws.dump.LoggingDumpTube;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.text.Position;

/**
 *
 * @author Priyamvada
 */
@ManagedBean
@SessionScoped
public class logIn implements Serializable {

    private String LID;
    private String Lpwd;
    private optionsDetails nlogin;

    // post new job property
    private String jobTitle;
    private String jobdesc;
    private String dateOpen;
    private Integer postions;

    public ArrayList<job> jobsList = new ArrayList<job>();

    public ArrayList<job> jobsClosedList = new ArrayList<job>();

    public ArrayList<application> applicationList = new ArrayList<application>();

    public job selectedJob;
    public application selectedApp;

    public String newAppStatus;

    public ArrayList<String> appStausArr = new ArrayList<String>();

    public ArrayList<job> getJobsList() {
        return jobsList;
    }

    public void setJobsList(ArrayList<job> jobsList) {
        this.jobsList = jobsList;
    }

    public ArrayList<application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(ArrayList<application> applicationList) {
        this.applicationList = applicationList;
    }

    public application getSelectedApp() {
        return selectedApp;
    }

    public void setSelectedApp(application selectedApp) {
        this.selectedApp = selectedApp;
    }

    public ArrayList<String> getAppStausArr() {
        return appStausArr;
    }

    public void setAppStausArr(ArrayList<String> appStausArr) {
        this.appStausArr = appStausArr;
    }

    public String getNewAppStatus() {
        return newAppStatus;
    }

    public void setNewAppStatus(String newAppStatus) {
        this.newAppStatus = newAppStatus;
    }

    public job getSelectedJob() {
        return selectedJob;
    }

    public void setSelectedJob(job selectedJob) {
        this.selectedJob = selectedJob;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }

    public Integer getPostions() {
        return postions;
    }

    public void setPostions(Integer postions) {
        this.postions = postions;
    }

    public String getLID() {
        return LID;
    }

    public void setLID(String LID) {
        this.LID = LID;
    }

    public String getLpwd() {
        return Lpwd;
    }

    public void setLpwd(String Lpwd) {
        this.Lpwd = Lpwd;
    }

    public optionsDetails getNlogin() {
        return nlogin;
    }

    public void setNlogin(optionsDetails nlogin) {
        this.nlogin = nlogin;
    }

    public ArrayList<job> getJobsClosedList() {
        return jobsClosedList;
    }

    public void setJobsClosedList(ArrayList<job> jobsClosedList) {
        this.jobsClosedList = jobsClosedList;
    }

    public String logIn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            //return to internalError.xhtml
            return ("internalError");
        }
        final String DATABSE_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        try {
            connection = DriverManager.getConnection(DATABSE_URL, "seerapup8892", "1347006");
            statement = connection.createStatement();
            resultset = statement.executeQuery("select * from accounts where AID = '" + LID + "'");
            if (resultset.next()) {
                if (Lpwd.equals(resultset.getString(3))) {
                    //  Name = (resultset.getString(2));
                    nlogin = new optionsDetails(LID, resultset.getString(4));
                    //     Nlogin.DisplayMenu();
                    if (resultset.getString(1).equals("Stu")) {
                        return "welcome";
                    } else {
                        return "managerIndex";
                    }
                    //      LoggedIn = false;
                } else {
                    return "loginNotOk";
                }
            } else {
                return "loginNotOk";
            }
        } catch (SQLException e) {
            //Handle the exceptions

            e.printStackTrace();
            return "loginNotOk";
        } finally {
            try {
                resultset.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
                return "loginNotOk";
            }
        }
    }

    public String postNewJob() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
            return ("Internal Error, Please try again later");
        }

        //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
            connection = DriverManager.getConnection(DB_URL, "seerapup8892", "1347006");

            statement = connection.createStatement();

            //resultSet = statement.executeQuery("Select * from users");
            //int r = statement.executeUpdate("insert into 'job' ('Jtitle','positions','Jdes','NotificationStatus') values('" + jobTitle + "','2','" + jobdesc + "','notsent')");
            int r = statement.executeUpdate("INSERT INTO `job`(`Jtitle`, `positions`, `Jdes`, `NotificationStatus`) VALUES ('" + jobTitle + "','" + postions + "','" + jobdesc + "','notsent')");
            return ("Job Posted!");
        } catch (SQLException e) {

            e.printStackTrace();
            return ("Internal Error. Please Try Again Later");
        } finally {

            try {

                connection.close();
                statement.close();
                resultSet.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

    }

    public void createJobsList() {

        //////
        jobsList.clear();

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
            //return ("Internal Error, Please try again later");
        }

        //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
            connection = DriverManager.getConnection(DB_URL, "seerapup8892", "1347006");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("Select * from job");

            while (resultSet.next()) {

                if (resultSet.getString(5).equals("notsent")) {

                    jobsList.add(new job(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4), "1st Jan 2015", resultSet.getInt(3), resultSet.getString(5)));
                }
            }
            //int r = statement.executeUpdate("insert into job values('test123','"+jobTitle+ "','" +postions+ "','" + jobdesc+ "','notsent')");

            //return ("Job Posted!");
        } catch (SQLException e) {

            e.printStackTrace();
            //return ("Internal Error. Please Try Again Later");
        } finally {

            try {

                connection.close();
                statement.close();
                resultSet.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        /////
        //ArrayList<job> jobsList = new ArrayList<job>();
//        jobsList.add(new job("id111","Job1","job Desc1","1st Jan 2015", 2,"notsent"));
//        jobsList.add(new job("id112","Job2","job Desc2","1st Jan 2015", 3,"notsent"));
//        jobsList.add(new job("id113","Job3","job Desc3","1st Jan 2015", 4,"notsent"));
//        jobsList.add(new job("id114","Job4","job Desc4","1st Jan 2015", 5,"notsent"));
//        jobsList.add(new job("id115","Job5","job Desc5","1st Jan 2015", 6,"notsent"));
//        jobsList.add(new job("id116","Job6","job Desc6","1st Jan 2015", 7,"notsent"));
        //return jobsList;
    }

    public void createClosedJobsList() {

        //////
        jobsClosedList.clear();

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
            //return ("Internal Error, Please try again later");
        }

        //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
            connection = DriverManager.getConnection(DB_URL, "seerapup8892", "1347006");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("Select * from job");

            while (resultSet.next()) {

                if (resultSet.getString(5).equals("sent")) {

                    jobsClosedList.add(new job(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4), "1st Jan 2015", resultSet.getInt(3), resultSet.getString(5)));
                }
            }
            //int r = statement.executeUpdate("insert into job values('test123','"+jobTitle+ "','" +postions+ "','" + jobdesc+ "','notsent')");

            //return ("Job Posted!");
        } catch (SQLException e) {

            e.printStackTrace();
            //return ("Internal Error. Please Try Again Later");
        } finally {

            try {

                connection.close();
                statement.close();
                resultSet.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        /////
        //ArrayList<job> jobsList = new ArrayList<job>();
//        jobsList.add(new job("id111","Job1","job Desc1","1st Jan 2015", 2,"notsent"));
//        jobsList.add(new job("id112","Job2","job Desc2","1st Jan 2015", 3,"notsent"));
//        jobsList.add(new job("id113","Job3","job Desc3","1st Jan 2015", 4,"notsent"));
//        jobsList.add(new job("id114","Job4","job Desc4","1st Jan 2015", 5,"notsent"));
//        jobsList.add(new job("id115","Job5","job Desc5","1st Jan 2015", 6,"notsent"));
//        jobsList.add(new job("id116","Job6","job Desc6","1st Jan 2015", 7,"notsent"));
        //return jobsList;
    }

    public void findAndSetSelectedJob(int jobid) {

        for (job tempJob : jobsList) {

            if (tempJob.getId() == jobid) {

                selectedJob = tempJob;
            }

        }

    }

    public void createApplicationList(int jobid) {

        //save jobid to some 
        findAndSetSelectedJob(jobid);
        applicationList.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
            //return ("Internal Error, Please try again later");
        }

        //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
            connection = DriverManager.getConnection(DB_URL, "seerapup8892", "1347006");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("Select * from application where JobID = '" + selectedJob.getId() + "'");

            while (resultSet.next()) {

                applicationList.add(new application(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8),
                        resultSet.getString(9)));
            }
            //int r = statement.executeUpdate("insert into job values('test123','"+jobTitle+ "','" +postions+ "','" + jobdesc+ "','notsent')");

            //return ("Job Posted!");
        } catch (SQLException e) {

            e.printStackTrace();
            //return ("Internal Error. Please Try Again Later");
        } finally {

            try {

                connection.close();
                statement.close();
                resultSet.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        //ArrayList<job> jobsList = new ArrayList<job>();
//        applicationList.add(new job("id111","App1","App Desc1","1st Jan 2015", 2,"notsent"));
//        applicationList.add(new job("id112","App2","App Desc2","1st Jan 2015", 3,"notsent"));
//        applicationList.add(new job("id113","App3","App Desc3","1st Jan 2015", 4,"notsent"));
//        applicationList.add(new job("id114","App4","App Desc4","1st Jan 2015", 5,"notsent"));
//        applicationList.add(new job("id115","App5","App Desc5","1st Jan 2015", 6,"notsent"));
//        applicationList.add(new job("id116","App6","App Desc6","1st Jan 2015", 7,"notsent"));
        //return jobsList;
    }

    public void setStatusArray() {

        appStausArr.clear();

        appStausArr.add("Selected");
        appStausArr.add("Rejected");

    }

    public void getSelectedAppDetails(int aid) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
            //return ("Internal Error, Please try again later");
        }

        //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
            connection = DriverManager.getConnection(DB_URL, "seerapup8892", "1347006");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("Select * from application where ApplicationID='" + aid + "'");

            if (resultSet.next()) {

                selectedApp = new application(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8),
                        resultSet.getString(9));

                newAppStatus = selectedApp.appStatus;
            }
            //int r = statement.executeUpdate("insert into job values('test123','"+jobTitle+ "','" +postions+ "','" + jobdesc+ "','notsent')");

            //return ("Job Posted!");
        } catch (SQLException e) {

            e.printStackTrace();
            //return ("Internal Error. Please Try Again Later");
        } finally {

            try {

                connection.close();
                statement.close();
                resultSet.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

    }

    public String updateAppStatusInDB(String status) {

        if (selectedApp.getAppStatus().equals(status)) {

            // ne need to update status in db
            return "nochangeinstatus";

        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");

            } catch (Exception e) {
                e.printStackTrace();
                return ("Internal Error, Please try again later");
            }

            //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
            final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";

            Connection connection = null;
            Statement statement = null;
            //ResultSet resultSet = null;

            try {

                //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
                connection = DriverManager.getConnection(DB_URL, "seerapup8892", "1347006");

                statement = connection.createStatement();

                //resultSet = statement.executeQuery("Select * from users");
                int r = statement.executeUpdate("update application set ApplicationStatus = '" + status + "' where ApplicationID = '" + selectedApp.getApplicationId() + "'");

                selectedApp.setAppStatus(status);
                return ("Application Status updated!");
            } catch (SQLException e) {

                e.printStackTrace();
                return ("Internal Error. Please Try Again Later");
            } finally {

                try {

                    connection.close();
                    statement.close();
                    //resultSet.close();
                } catch (Exception e) {

                    e.printStackTrace();
                    return ("Error in connection closeing");
                }
            }

        }

    }

    public String sendNotification() {

        if (selectedJob.getNotificationStatus().equals("notsent")) {

            boolean pendingStatusFound = false;
            int selectedCount = 0;
            for (application app : applicationList) {

                if (app.appStatus.equals("Pending")) {

                    pendingStatusFound = true;
                    break;
                }

                if (app.getAppStatus().equals("Selected")) {

                    selectedCount++;
                }
            }

            if (pendingStatusFound) {

                return "Can not send notification! Please make sure all application are selected or rejected";
            } else {

                if (selectedCount >= 1) {

                    if (selectedCount <= selectedJob.getPostions() && applicationList.size() > 0) {

                        try {
                            Class.forName("com.mysql.jdbc.Driver");

                        } catch (Exception e) {
                            e.printStackTrace();
                            return ("Internal Error, Please try again later");
                        }

                        //final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/tandulwadkarp06";
                        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/seerapup8892";

                        Connection connection = null;
                        Statement statement = null;
                        //ResultSet resultSet = null;

                        try {

                            //connection = DriverManager.getConnection(DB_URL, "tandulwadkarp06", "1136627");
                            connection = DriverManager.getConnection(DB_URL, "seerapup8892", "1347006");

                            statement = connection.createStatement();

                            //resultSet = statement.executeQuery("Select * from users");
                            int r = statement.executeUpdate("update job set NotificationStatus = 'sent' where JID = '" + selectedJob.getId() + "'");

                            selectedJob.setNotificationStatus("sent");
                            return ("Application Status updated!");
                        } catch (SQLException e) {

                            e.printStackTrace();
                            return ("Internal Error. Please Try Again Later");
                        } finally {

                            try {

                                connection.close();
                                statement.close();
                                //resultSet.close();
                            } catch (Exception e) {

                                e.printStackTrace();
                                return ("Error in connection closeing");
                            }
                        }
                    } else {

                        return "Can not send notification! Please make sure number of selected applicants are less than or equal to positions available.";
                    }
                } else {

                    return "Can not send notification! Please make sure you select at least one candidate for job before sending notification";

                }
            }

        } else {

            return "Notification for this job is already sent";
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Priyamvada
 */
public class job {
  private int id;
    private String jobTitle;
    private String jobdesc;
    private String dateOpen;
    private int postions;
    private String notificationStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPostions() {
        return postions;
    }

    public void setPostions(int postions) {
        this.postions = postions;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public job(int id, String jobTitle, String jobdesc, String dateOpen, int postions, String notificationStatus) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.jobdesc = jobdesc;
        this.dateOpen = dateOpen;
        this.postions = postions;
        this.notificationStatus = notificationStatus;
    }
}

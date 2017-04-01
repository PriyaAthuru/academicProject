/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Priyamvada
 */
@ManagedBean
@RequestScoped
public class applicationDetails {
    private int Application_ID;
    private int Job_ID;
    private String ApplicationStatus;
    private String ApplicantID;
    private String appjob;

    public String getApplicantID() {
        return ApplicantID;
    }

    public void setApplicantID(String ApplicantID) {
        this.ApplicantID = ApplicantID;
    }

    public String getAppjob() {
        return appjob;
    }

    public void setAppjob(String appjob) {
        this.appjob = appjob;
    }

    public int getApplication_ID() {
        return Application_ID;
    }

    public void setApplication_ID(int Application_ID) {
        this.Application_ID = Application_ID;
    }

    public int getJob_ID() {
        return Job_ID;
    }

    public void setJob_ID(int Job_ID) {
        this.Job_ID = Job_ID;
    }


    public String getApplicationStatus() {
        return ApplicationStatus;
    }

    public void setApplicationStatus(String ApplicationStatus) {
        this.ApplicationStatus = ApplicationStatus;
    }

    public applicationDetails(int Application_ID, int Job_ID, String ApplicationStatus, String ApplicantID, String appjob) {
        this.Application_ID = Application_ID;
        this.Job_ID = Job_ID;
        this.ApplicationStatus = ApplicationStatus;
        this.ApplicantID = ApplicantID;
        this.appjob = appjob;
    }


 
    /**
     * Creates a new instance of applicationform
     */   
}

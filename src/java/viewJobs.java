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
@ManagedBean(name = "viewjobs")
@RequestScoped
public class viewJobs {
    private int jobID;
    private String jobtitle="";
    private int jobpos;
    private String jobDes="";
    public viewJobs()
    {
        
    }
    public viewJobs(int jobID, String jobtitle, int jobpos, String jobDes) {
        this.jobID = jobID;
        this.jobtitle = jobtitle;
        this.jobpos = jobpos;
        this.jobDes = jobDes;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public int getJobpos() {
        return jobpos;
    }

    public void setJobpos(int jobpos) {
        this.jobpos = jobpos;
    }

    public String getJobDes() {
        return jobDes;
    }

    public void setJobDes(String jobDes) {
        this.jobDes = jobDes;
    }
    /**
     * Creates a new instance of viewJob
     */
    
}

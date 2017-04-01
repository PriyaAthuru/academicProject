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
public class optionsDetails {
    private String UserId;
    private String UserName;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public optionsDetails(String UserId, String UserName) {
        this.UserId = UserId;
        this.UserName = UserName;
    }


    /**
     * Creates a new instance of optionsDetails
     */

    
}

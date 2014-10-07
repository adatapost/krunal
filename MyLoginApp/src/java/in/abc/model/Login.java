/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.model;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class Login {
    private String userName;
    private String userPass;
    private String userEmail;
    private String userRole;
    private String question;
    private String answer;

    public Login() {
    }

    public Login(String userName, String userPass, String userEmail, String userRole, String question, String answer) {
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.question = question;
        this.answer = answer;
    }

    public Login(String userName) {
        this.userName = userName;
    }

    public Login(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Login other = (Login) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Login{" + "userName=" + userName + ", userEmail=" + userEmail + ", userRole=" + userRole + ", question=" + question + ", answer=" + answer + '}';
    }
    
}

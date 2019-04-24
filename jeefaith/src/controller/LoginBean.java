package controller;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.UserDAO;
import bean.User;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = -5433850275008415405L;

    private String username;
    private String password;
    private String userReg;
    private String passReg;
    private String PassConfirm;
    private String nom;
    private String prenom;
    private String email;
    private User user;

    public String login() {
        UserDAO userDao = new UserDAO();
        ArrayList<User> list = userDao.findAll();
            System.out.println(list);

            for(User user : list) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                setUser(user);
                return "success";
            }
        }
            return "";
    }

    public String register() {
        UserDAO dao = new UserDAO();
        boolean t = dao.insertUser(userReg, passReg, nom, prenom, email);

        if (t) {
            setUsername(userReg);
            setPassword(passReg);
            return login();
        }
        return "";
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getUserReg() {
        return userReg;
    }
    public void setUserReg(String userReg) {
        this.userReg = userReg;
    }
    public String getPassReg() {
        return passReg;
    }
    public void setPassReg(String passReg) {
        this.passReg = passReg;
    }
    public String getPassConfirm() {
        return PassConfirm;
    }
    public void setPassConfirm(String passConfirm) {
        PassConfirm = passConfirm;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String returnAction() throws Exception {
	    UserDAO userDAO = new UserDAO();
	    System.out.println(userDAO.findAll());
	    System.out.println( "in returnAction" );
        return password.equals( "007" ) ? "success" : "failure";
    }
    
}
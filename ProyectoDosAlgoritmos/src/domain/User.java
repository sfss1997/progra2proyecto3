
package domain;

/**
 *
 * @author Nicole
 */
public class User  implements java.io.Serializable {
    
    private int idUser;
    private String name;
    private String role;
    private String user;
    private String password;

    public User() {
    }

    public User(int idUser, String name, String role, String user, String password) {
        this.idUser = idUser;
        this.name = name;
        this.role = role;
        this.user = user;
        this.password = password;
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", name=" + name + ", role=" + role + ", user=" + user + ", password=" + password + '}';
    }
    
    
}

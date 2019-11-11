/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.ejb;

import gr.kourtzis.dgs.entity.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Athanasios Kourtzis
 */
@Remote
public interface UserAdministrationBeanRemote {
    /**
     * The method returns all users saved in the database.
     * @return A list of User objects.
     */
    public List<User> readAllUsers();
    
    /**
     * The method searches the database for a user with a 
     * specific email address.
     * @param email A String object which contains the email address.
     * @return A User object.
     */
    public User readUser(final String email);
    public User readUser(int id);
    
    /**
     * The method searches for all the emails saved in the database.
     * @return A list of String objects.
     */
    public List<String> readAllEmails();
    
    /**
     * The method creates a User object in the database
     * @param user The User object to be created.
     */
    public void create(final User user);
    
    /**
     * The method updates an existing user object in the database.
     * @param user The User object to be updated.
     */
    public void update(final User user);
    
    public void delete(final User user);
}

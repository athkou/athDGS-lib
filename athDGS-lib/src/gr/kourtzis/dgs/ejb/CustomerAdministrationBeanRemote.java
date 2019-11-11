/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.ejb;

import gr.kourtzis.dgs.entity.Customer;
import gr.kourtzis.dgs.entity.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Athanasios Kourtzis
 */
@Remote
public interface CustomerAdministrationBeanRemote {
    /**
     * The method returns all customer objects saved in the database.
     * @return A list of customer objects.
     */
    public List<Customer> readEntries();
    
    /**
     * The method returns a customer object. A user object is passed by 
     * as a parameter. The customer returned must have the same id as
     * the if from the user object.
     * @param user A User object.
     * @return A customer object or null.
     */
    public Customer readEntry(final User user);
    
    /**
     * The method creates a customer entry in the database.
     * @param customer The Customer object to be added.
     */
    public void create(final Customer customer);
    
    /**
     * The method updates an existing customer object from the database.
     * @param customer The customer object to be updated.
     */
    public void update(final Customer customer);
    
    /**
     * The method deletes an existing customer object from the database.
     * @param customer The customer object to be deleted.
     */
    public void delete(final Customer customer);
    
    /**
     * The method returns the size of the customer object saved
     * in the database.
     * @return A Long variable.
     */
    public Long count();
}

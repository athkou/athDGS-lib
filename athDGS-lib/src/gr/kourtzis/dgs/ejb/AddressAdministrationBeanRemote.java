/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.ejb;

import gr.kourtzis.dgs.entity.Address;
import gr.kourtzis.dgs.entity.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Athanasios Kourtzis
 */
@Remote
public interface AddressAdministrationBeanRemote {
    /**
     * The method returns all address objects saved in the database.
     * @return A list of address objects.
     */
    public List<Address> readEntries();
    
    /**
     * The method returns a address object. The address object  
     * must have the same id with the id from the user object.
     * @param user A user object.
     * @return An address object or null.
     */
    public Address readEntry(final User user);
    
    /**
     * The method adds an address object to the database.
     * @param address The Address object to be added.  
     */
    public void create(final Address address);
    
    /**
     * The method updates an existing address object from the database.
     * @param address The Address object to be updated.
     */
    public void update(final Address address);
    
    /**
     * The method deletes an existing address object from the database.
     * @param address The Address object to be deleted.
     */
    public void delete(final Address address);
    
    /**
     * The method returns the size of the Address objects 
     * saved in the database.
     * @return A Long variable.
     */
    public Long count();
}

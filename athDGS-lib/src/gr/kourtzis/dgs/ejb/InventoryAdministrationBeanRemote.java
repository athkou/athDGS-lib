/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.ejb;

import gr.kourtzis.dgs.entity.Game;
import gr.kourtzis.dgs.entity.Inventory;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Athanasios Kourtzis
 */
@Remote
public interface InventoryAdministrationBeanRemote {
    /**
     * The method returns a list with all Inventory object
     * saved in the database.
     * @return A list of Inventory objects.
     */
    public List<Inventory> readEntries();
    
    /** 
     * The method returns a list of integer variables. The variables contain 
     * the id of every Inventory object.
     * @return A list of Integers.
     */
    public List<Integer> readIdEntries();
    
    /**
     * The method returns a Inventory object from the database. 
     * A Game object is used as a parameter to match the id's from 
     * both game and the returning inventory objects.
     * @param game A Game object.
     * @return An Inventory object or null.
     */
    public Inventory readEntry(final Game game);
    
    /**
     * The method creates a new Inventory object in the database.
     * @param inventory The Inventory object to be created.
     */
    public void create(final Inventory inventory);
    
    /**
     * The method updates an existing inventory object
     * in the database.
     * @param inventory The Inventory object to be updated.
     */
    public void update(final Inventory inventory);
    
    /**
     * The method deletes an existing inventory object from the database.
     * @param inventory The Inventory object to be deleted.
     */
    public void delete(final Inventory inventory);
    
    /**
     * The method returns the size of the inventory objects
     * saved in the database.
     * @return A Long variable.
     */
    public Long count();
}

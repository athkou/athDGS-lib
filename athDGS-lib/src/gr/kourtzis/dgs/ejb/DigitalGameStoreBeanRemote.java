/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.ejb;

import gr.kourtzis.dgs.entity.Category;
import gr.kourtzis.dgs.entity.Game;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Athanasios Kourtzis
 */
@Remote
public interface DigitalGameStoreBeanRemote {
    /**
     * The method reads all categories from the database
     * @return A list of category objects
     */
    public List<Category> getCategories();
    
    /**
     * The method adds a category to the database.
     * @param category The category to be added. 
     */
    public void addCategory(final Category category);
    
    /**
     * The method updates a category that is already saved in the database
     * @param category The category to be updated.
     */
    public void update(final Category category);
    
    /**
     * The method deletes a category from the database
     * @param category The category to be deleted.
     */
    public void delete(final Category category);
    
    /**
     * The method returns the total amount of category objects
     * stored in the database
     * @return A Long variable
     */
    public Long count();

    /**
     * The method returns the games for a specific category.
     * @param category_id An integer which is the primary key
     *                    representing a category.
     * @return A list of game objects
     */
    public List<Game> getGamesByCategory(int category_id);
    
    /**
     * The method returns all the games saved in the database.
     * @return A list of game objects.
     */
    public List<Game> getAllGames();
}

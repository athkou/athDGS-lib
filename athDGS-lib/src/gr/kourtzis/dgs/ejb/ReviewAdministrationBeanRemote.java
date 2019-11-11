/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.ejb;

import gr.kourtzis.dgs.entity.Game;
import gr.kourtzis.dgs.entity.Review;
import gr.kourtzis.dgs.entity.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Athanasios Kourtzis
 */
@Remote
public interface ReviewAdministrationBeanRemote {
    public List<Review> readEntries();
    public List<Review> readEntries(boolean reviewFlagged);
    public List<Review> readEntriesByUser(final User user);
    public List<Review> readEntriesByGame(final Game game);
    
    public Review readEntry(int id);
    
    public void create(final Review review);
    public void update(final Review review);
    
    public Long count();
}

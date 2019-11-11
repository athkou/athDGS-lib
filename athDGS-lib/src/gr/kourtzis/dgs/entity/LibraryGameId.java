/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Athanasios Kourtzis
 */

@Getter
@Setter

@Embeddable
public class LibraryGameId implements Serializable {
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "game_id")
    private int gameId;
    
    public LibraryGameId() {
    }
    
    public LibraryGameId(int userId, int gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.userId;
        hash = 67 * hash + this.gameId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibraryGameId other = (LibraryGameId) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }
        return true;
    }
}

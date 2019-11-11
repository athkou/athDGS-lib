/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Athanasios Kourtzis
 */

@Getter
@Setter

@Entity
@Table(name = "game_library")
public class LibraryGame implements Serializable {
    @EmbeddedId
    private LibraryGameId libraryGameId;
    
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    private Game game;
    
    @Column(name = "license_key")
    private String licenseKey;
    
    @Column(name = "added_on")
    private Date addedOn;

    public LibraryGame(final LibraryGameId libraryGameId, String licenseKey, Date addedOn) {
        this.libraryGameId = libraryGameId;
        this.licenseKey = licenseKey;
        this.addedOn = addedOn;
    }
    
    public LibraryGame(){
    }
}

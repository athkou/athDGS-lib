/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "game")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int gameId;
    
    @Basic
    private String title;
    
    @Lob
    private String description;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
    @JoinColumn(name = "category_id") 
    private Category category;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game", orphanRemoval = true)
    Set<LibraryGame> libraryGames;
   
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "games")
    private Set<MyOrder> orders;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "games")
    private Set<Review> reviews;
    
    /**
     * This constructor initializes a game object with all member methods having
     * custom values.It is used mostly used when a game is created 
     * after reading an entry from the database.
     * @param gameId An integer variable containing the primary key from the database.
     * @param title A String variable containing the title of the game.
     * @param description A String variable containing a description of the game.
     */
    public Game(int gameId, final String title, final String description) {
        this.title = title;
        this.gameId = gameId;
        this.description = description;
        
        category = new Category();
        
        orders = new HashSet<>();
        libraryGames = new HashSet<>();
    }

    /**
     * This constructor initializes a game object with custom values except
     * the gameId which is initialized with 0. The constructor is mostly used
     * when creating creating a category object before saving it to the database.
     * After persisting the object the gameId member variable is updated with 
     * the value from the database. 
     * @param title A String variable containing the title of the game.
     * @param description A String variable containing a description of the game.
     */
    public Game(final String title, final String description) {
        this(0, title, description);
    }

    /**
     * The default constructor. Initializes all member variables with default values
     * and is used when a game object is needed.
     */
    public Game() {
        this(0, "", "");
    }
    
    /**
     * The method adds a LibraryGame object to the game object 
     * and synchronizes both objects. 
     * @param libraryGame The libraryGame object added
     */
    public void addLibraryGame(LibraryGame libraryGame) {
        libraryGames.add(libraryGame);
        libraryGame.setGame(this);
    }
    
    /**
     * The method removes a LibraryGame object from the game object
     * and synchronizes both objects.
     * @param libraryGame 
     */
    public void removeLibraryGame(LibraryGame libraryGame) {
        libraryGames.remove(libraryGame);
        libraryGame.setGame(null);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", title=" + title + ", description=" + description + ", category=" + category.getGenre() + '}';
    }
}

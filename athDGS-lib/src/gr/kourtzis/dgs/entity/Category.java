/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    
    @Basic
    private String genre;
    @Lob
    private String description;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Game> games; 
    
    /**
     * This constructor initializes a category object with all member methods having
     * custom values. It is used mostly used when a category is created 
     * after reading an entry from the database.
     * @param categoryId An integer variable containing the primary key from the database.
     * @param title A String variable containing the genre of the category.
     * @param description A String variable containing a short description of the category.
     */
    public Category(int categoryId, final String title, final String description) {
        this.genre = title;
        this.categoryId = categoryId;
        this.description = description;
        
        games = new ArrayList<>();
    }
    
    /**
     * This constructor initializes a category object with custom values except
     * the categoryId which is initialized with 0. The constructor is mostly used
     * when creating creating a category object before saving it to the database.
     * After persisting the object the categoryId member variable is updated with 
     * the value from the database. 
     * @param title A String variable containing the genre of the category.
     * @param description A String variable containing a short description of the category.
     */
    public Category(final String title, final String description) {
        this(0, title, description);
    }
    
    /**
     * The default constructor. Initializes all member variables with default values
     * and is used when a default category object is needed.
     */
    public Category() {
        this(0, "", "");
    }
    
    /**
     * The method adds a game to a specific category. 
     * @param game The game object which is added to the category.
     */
    public void addGame(Game game) {
        games.add(game);
        game.setCategory(this);
    }
    
    /**
     * The method removes a game from a specific category.
     * @param game The game object which is removed from the category.
     */
    public void removeGame(Game game) {
        games.remove(game);
        game.setCategory(null);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.genre);
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
        final Category other = (Category) obj;
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return genre;
    }
    
    /**
     * The method returns a String object which contains more 
     * information about the category object than the default 
     * toString method.
     * @return A String object.
     */
    public String categoryToString() {
        StringBuilder builder = new StringBuilder();
        
        return builder.toString();
    }
}    

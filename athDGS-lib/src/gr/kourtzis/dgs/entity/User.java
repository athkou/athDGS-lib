/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Athanasios Kourtzis
 */
@Getter
@Setter
@ToString

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    
    @Column(unique = true, length = 250)
    private String email;
    
    @Column(name = "recovery_email")
    private String recoveryEmail;
    
    @Column(length = 64, nullable = false)
    private String password;
    
    @Column(name = "ip_address")
    private String ipAddress;
    
    @Column(name = "app_role", nullable = false)
    private String appRole;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MyOrder> orders;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<LibraryGame> libraryGames;
    
    
    /**
     * The default constructor. Initializes all member variables with default values
     * and is used when a default user object is needed.
     */
    public User() {
        this(0, "", "", "", "", "");
    }
    
    /**
     * This constructor initializes a user object with custom values except
     * the userId which is initialized with 0. The constructor is mostly used
     * when creating creating a user object before saving it to the database.
     * After persisting the object the userId member variable is updated with 
     * the value from the database. 
     * @param email A String representing an email address.
     * @param password A String representing a password.
     * @param recoveryEmail A String representing an email. This email is used
     *                      as a recovery email.
     * @param ipAddress A String containing the IP address of the user.
     * @param appRole A String variable containing a role for the user. Can
     *                have the values "user", "support" or "admin".
     */
    public User(final String email, 
                final String password,
                final String recoveryEmail,
                final String ipAddress,
                final String appRole) {
        this(0, email, password, recoveryEmail, ipAddress, appRole);
    }
    
    /**
     * This constructor initializes a user object with all member methods having
     * custom values. It is used mostly used when a user is created 
     * after reading an entry from the database.
     * @param userId An integer variable containing the primary key from the database.
     * @param email A String representing an email address.
     * @param password A String representing a password.
     * @param recoveryEmail A String representing an email. This email is used
     *                      as a recovery email.
     * @param ipAddress A String containing the IP address of the user.
     * @param appRole A String variable containing a role for the user. Can
     *                have the values "user", "support" or "admin".
     */
    public User(int userId,
                final String email,
                final String password,
                final String recoveryEmail,
                final String ipAddress,
                final String appRole) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.recoveryEmail = recoveryEmail;
        this.ipAddress = ipAddress;
        this.appRole = appRole;
        
        orders = new ArrayList<>();
        reviews = new ArrayList<>();
        
        libraryGames = new HashSet<>();
    }
    
    /**
     * The method adds a LibraryGame object to the user object 
     * and synchronizes both objects. 
     * @param libraryGame The libraryGame object added
     */
    public void addLibraryGame(LibraryGame libraryGame) {
        libraryGames.add(libraryGame);
        libraryGame.setUser(this);
    }
    
    /**
     * The method removes a LibraryGame object from the game object 
     * and synchronizes both objects. 
     * @param libraryGame The libraryGame object removed
     */
    public void removeLibraryGame(LibraryGame libraryGame) {
        libraryGames.remove(libraryGame);
        libraryGame.setUser(null);
    }
    
    /**
     * The method adds an order object to the user object
     * and synchronizes both objects.
     * @param order The order object added.
     */
    public void addOrder(MyOrder order) {
        orders.add(order);
        order.setUser(this);
    }
    
    /**
     * The method removes the order object from the user 
     * and synchronizes both objects.
     * @param order 
     */
    public void removeOrder(MyOrder order) {
        orders.remove(order);
        order.setUser(null);
    }
    
    /**
     * The method adds a review object to the user and 
     * synchronizes both object.
     * @param review The review object added.
     */
    public void addReview(Review review) {
        reviews.add(review);
        review.setUser(this);
    }
    
    /**
     * The method removes a review object from the user
     * and synchronizes both objects.
     * @param review The review object removed from the user.
     */
    public void removeReview(Review review) {
        reviews.remove(review);
        review.setUser(null);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.email);
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
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
}

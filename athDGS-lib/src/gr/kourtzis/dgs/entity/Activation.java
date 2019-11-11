/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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
@Table(name = "activation")
public class Activation implements Serializable {
    @Id
    private int activationId;
    
    @Column(name = "activation_token")
    private String activationToken;
    
    @Column(name = "created_on")
    private Date createdOn;
    
    @Column(name = "expiration_date")
    private Date expirationDate;
    
    @Column(name = "user_activated")
    private boolean userActivated;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    /**
     * The default constructor. Initializes all member variables with default values
     * and is used when a default category object is needed.
     */
    public Activation() {
        this(0, "", null, null, false);
    }
    
    /**
     * This constructor initializes an activation object with custom values except
     * the activationId which is initialized with 0.The constructor is mostly used
 when creating creating an activation object before saving it to the database. After persisting the object the activationId member variable is updated with 
 the value from the database. 
     * @param activationToken A String variable with contains an uuid.
     * @param createdOn
     * @param expirationDate A Date containing the expiration date 
     *                       after which the token is invalid
     * @param userActivated A boolean variable indicating if the user is 
     *                      activated(true) or not(false) 
     */
    public Activation(final String activationToken, 
                      final Date createdOn,
                      final Date expirationDate, 
                      boolean userActivated) {
        this(0, activationToken, createdOn, expirationDate, userActivated);
    }

    /**
     * This activation initializes a category object with all member methods having
     * custom values.It is used mostly used when a activation is created 
 after reading an entry from the database.
     * @param activationId An integer variable representing the id in the database.
     * @param activationToken A String variable containing an uuid.
     * @param createdOn
     * @param expirationDate A Date containing the expiration date after
     *                       which the token is invalid.
     * @param userActivated A boolean variable indicating if the user is 
     *                      activated(true) or not(false)
     */
    public Activation(int activationId, 
                      final String activationToken, 
                      final Date createdOn,
                      final Date expirationDate, 
                      boolean userActivated) {
        this.activationId = activationId;
        this.activationToken = activationToken;
        this.createdOn = createdOn;
        this.expirationDate = expirationDate;
        this.userActivated = userActivated;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Activation other = (Activation) obj;
        if (this.activationId != other.activationId) {
            return false;
        }
        return true;
    }
}

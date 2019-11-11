/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
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
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    private int customerId;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;
    
    @Column(name = "recovery_phone_number")
    private String recoveryPhoneNumber;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;
    
    /**
     * The default constructor. Initializes all member variables with default values
     * and is used when a default Customer object is needed.
     */
    public Customer() {
        this(0, "", "", "", "");
    }
    
    /**
     * This constructor initializes a customer object with custom values except
     * the customerId which is initialized with 0. The constructor is mostly used
     * when creating a customer object before saving it to the database.
     * After persisting the object the customerId member variable is updated with 
     * the value from the database.  
     * @param firstName A String variable containing the first name.
     * @param lastName A String variable containing the last name.
     * @param mobilePhoneNumber A String variable containing the 
     *                          primary mobile phone number.
     * @param recoveryPhoneNumber A String variable containing a secondary
     *                            mobile phone number which is used a recovery number.
     */
    public Customer(final String firstName,
                    final String lastName,
                    final String mobilePhoneNumber,
                    final String recoveryPhoneNumber) {
        this(0, firstName, lastName, mobilePhoneNumber, recoveryPhoneNumber);
    }
    
    /**
     * This constructor initializes a customer object with all member methods having
     * custom values. It is used mostly used when a customer is created 
     * after reading an entry from the database.
     * @param customerId An integer variable representing the id in the database.
     * @param firstName A String variable containing the first name.
     * @param lastName A String variable containing the last name.
     * @param mobilePhoneNumber A String variable containing the 
     *                          primary mobile phone number.
     * @param recoveryPhoneNumber A String variable containing a secondary
     *                            mobile phone number which is used a recovery number.
     */
    public Customer(int customerId, 
                    final String firstName,
                    final String lastName,
                    final String mobilePhoneNumber,
                    final String recoveryPhoneNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.recoveryPhoneNumber = recoveryPhoneNumber;
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
        final Customer other = (Customer) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        return true;
    }
}

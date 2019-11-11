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
@Table(name = "address")
public class Address implements Serializable {
    @Id
    private int addressId;
    
    @Column(name = "street_name")
    private String streetName;
    
    @Column(name = "postal_code")
    private String postalCode;
    
    private String city;
    private String country;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Customer customer;
    
    /**
     * The default constructor. Initializes all member variables with default values
     * and is used when a default category object is needed.
     */
    public Address() {
        this(0, "", "", "", "");
    }
    
    /**
     * This constructor initializes an address object with custom values except
     * the addressId which is initialized with 0. The constructor is mostly used
     * when creating creating an address object before saving it to the database.
     * After persisting the object the addressId member variable is updated with 
     * the value from the database. 
     * @param streetName A String variable.
     * @param postalCode A String variable.
     * @param city A String variable.
     * @param country A String variable.
     */
    public Address(final String streetName,
                   final String postalCode,
                   final String city,
                   final String country) {
        this(0, streetName, postalCode, city, country);
    }
    
    /**
     * This constructor initializes a address object with all member methods having
     * custom values. It is used mostly used when a address is created 
     * after reading an entry from the database.
     * @param addressId An integer representing the id in the database
     * @param streetName A String variable.
     * @param postalCode A String variable.
     * @param city A String variable.
     * @param country A String variable.
     */
    public Address(int addressId, 
                   final String streetName,
                   final String postalCode,
                   final String city,
                   final String country) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
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
        final Address other = (Address) obj;
        if (this.addressId != other.addressId) {
            return false;
        }
        return true;
    }
}

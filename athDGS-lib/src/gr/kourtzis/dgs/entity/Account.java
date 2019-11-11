/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Athanasios Kourtzis
 */
@Getter
@Setter

public class Account implements Serializable {
    public static final int EXPIRATION = 60 * 24;
    
    private User user;
    private Customer customer;
    private Activation activation;
    private Address address;
    private boolean sendEmail;
    
    private Date orphanAccountDate;
    
    /**
     * The default constructor. Initializes all member variables with default values
     * and is used when a default Account object is needed.
     */
    public Account() {
        this(new User(),
             new Customer(),
             new Activation(),
             new Address(),
             false);
    }
    
    /**
     * This constructor initializes an account object with all member methods having
     * custom values.
     * @param user A User object
     * @param customer A Customer object
     * @param activation An Activation object
     * @param address  An Address object
     * @param sendEmail 
     */
    public Account(final User user,
                   final Customer customer,
                   final Activation activation,
                   final Address address,
                   boolean sendEmail)
    {
        this.user = user;
        this.customer = customer;
        this.activation = activation;
        this.address = address;
        this.sendEmail = sendEmail;
    }
    
    /**
     * The method creates a new Date object. As parameter we pass a number 
     * which represends a time in minutes. This integer is important in order to 
     * calculate the expiration Date which is the returned from the method.
     * @param expireTimeInMinutes an integer parameter
     * @return A Date object
     */
    public static Date calculateExpireDate(int expireTimeInMinutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE, expireTimeInMinutes);
        
        return new Date(calendar.getTime().getTime());
    }
    
    public static Date calculateExpireDate(final Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        
        return new Date(calendar.getTime().getTime());
    }
}

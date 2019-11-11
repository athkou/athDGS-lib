/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
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
@Table(name = "inventory")
public class Inventory implements Serializable {
    @Id
    private int inventoryId;
    
    private int quantity;
    private double price;
    
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Game game;
    
    /**
     * The default constructor. Initializes all member variables with default values
     * and is used when a default Inventory object is needed.
     */
    public Inventory() {
        this(0, 0, 0.0);
    }
    
    /**
     * 
     * @param quantity An integer variable representing the quantity 
     *                 of available keys for a game.
     * @param price A double variable representing the price of a game.
     */
    public Inventory(int quantity, double price) {
        this(0, quantity, price);
    }
    
    public Inventory(int inventoryId, int quantity, double price) {
        this.inventoryId = inventoryId;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.inventoryId;
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
        final Inventory other = (Inventory) obj;
        if (this.inventoryId != other.inventoryId) {
            return false;
        }
        return true;
    }
}

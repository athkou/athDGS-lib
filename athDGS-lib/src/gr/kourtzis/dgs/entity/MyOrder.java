/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.kourtzis.dgs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "my_order")
public class MyOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    
    @Column(name = "order_date")
    private Date orderDate;
    
    @Column(name = "total_price")
    private double totalPrice;
    
    @Column(columnDefinition = "LONGBLOB", name = "invoice")
    private byte[] invoice;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToMany(fetch = FetchType.EAGER,
                cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "ordered_games",
               joinColumns = @JoinColumn(name = "order_id"),
               inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<Game> games;
    
    public MyOrder() {
        this(0, null, 0.0, null);
    }
    
    public MyOrder(final Date orderDate, double totalPrice, byte[] invoice) {
        this(0, orderDate, totalPrice, invoice);
    }
    
    public MyOrder(int orderId, final Date orderDate, double totalPrice, byte[] invoice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.invoice = invoice;
        
        games = new HashSet<>();
    }
    
    public void addGame(Game game) {
        games.add(game);
        game.getOrders().add(this);
    }
    
    public void removeGame(Game game) {
        games.remove(game);
        game.getOrders().remove(this);
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
        final MyOrder other = (MyOrder) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        return true;
    }
}

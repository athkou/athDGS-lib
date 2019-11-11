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
import javax.persistence.Lob;
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
@Table(name = "review")
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "created_on")
    private Date createdOn;
    
    @Lob
    @Column(name = "user_review")
    private String userReview;
    
    @Column(name = "review_flagged")
    private boolean reviewFlagged;
    
    @Column(name = "last_edited")
    private Date lastEdited;
    
    @Column(name = "last_edited_from")
    private int lastEditedFrom;
    
    @Column(name = "reason_for_edit")
    private String reasonForEdit;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user")
    private User user;
    
    @ManyToMany(fetch = FetchType.EAGER,
                cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
    })
    @JoinTable(name = "review_games",
               joinColumns = @JoinColumn(name = "review_id"),
               inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> games;
    
    public Review() {
        this(0, "", null, "", false, null, 0, "");
    }
    
    public Review(final String title,
                  final Date createdOn,
                  final String userReview,
                  boolean reviewFlagged,
                  final Date lastEdited,
                  int lastEditedFrom,
                  final String reasonForEdit) {
        this(0, title, createdOn, userReview, reviewFlagged, lastEdited, lastEditedFrom, reasonForEdit);
    }
    
    public Review(int reviewId,
                  final String title,
                  final Date createdOn,
                  final String userReview,
                  boolean reviewFlagged,
                  final Date lastEdited,
                  int lastEditedFrom,
                  final String reasonForEdit) {
        this.reviewId = reviewId;
        this.title = title;
        this.createdOn = createdOn;
        this.userReview = userReview;
        this.reviewFlagged = reviewFlagged;
        this.lastEdited = lastEdited;
        this.lastEditedFrom = lastEditedFrom;
        this.reasonForEdit = reasonForEdit;
        
        games = new HashSet<>();
    }
    
    /**
     * 
     * @param game
     * 
     */
    public void addGame(Game game) {
        games.add(game);
        game.getReviews().add(this);
    }
    
    /**
     * 
     * @param game 
     */
    public void removeGame(Game game) {
        games.remove(game);
        game.getReviews().remove(this);
    }
    
    public boolean isEdited() {
        return user.getUserId() != lastEditedFrom;
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
        final Review other = (Review) obj;
        if (this.reviewId != other.reviewId) {
            return false;
        }
        return true;
    }
}

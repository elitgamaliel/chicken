package com.uch.chicken.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "promotion")
@NamedQueries({
        @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_promotion")
    private Integer idPromotion;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cost")
    private BigDecimal cost;
    @Basic(optional = false)
    @Column(name = "igv")
    private BigDecimal igv;
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "percent_discount")
    private Integer percentDiscount;
    @Column(name = "cost_discount")
    private BigDecimal costDiscount;
    @Column(name = "igv_discount")
    private BigDecimal igvDiscount;
    @Column(name = "price_discount")
    private BigDecimal priceDiscount;
    @Basic(optional = false)
    @Column(name = "final_price")
    private BigDecimal finalPrice;
    @Column(name = "photo_promotion")
    private String photoPromotion;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "idPromotion", fetch = FetchType.LAZY)
    private List<PromotionProduct> promotionProductList;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}
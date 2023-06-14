package com.uch.chicken.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "promotion_product")
@NamedQueries({
        @NamedQuery(name = "PromotionProduct.findAll", query = "SELECT p FROM PromotionProduct p")})
public class PromotionProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_promotion_producto")
    private Integer idPromotionProducto;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product idProduct;
    @JoinColumn(name = "id_promotion", referencedColumnName = "id_promotion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Promotion idPromotion;

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
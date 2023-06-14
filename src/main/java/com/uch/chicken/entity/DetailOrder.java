package com.uch.chicken.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "detail_order")
@NamedQueries({
        @NamedQuery(name = "DetailOrder.findAll", query = "SELECT d FROM DetailOrder d")})
public class DetailOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detail_order")
    private Integer idDetailOrder;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "igv")
    private BigDecimal igv;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "cost_discount")
    private BigDecimal costDiscount;
    @Column(name = "igv_discount")
    private BigDecimal igvDiscount;
    @Column(name = "price_discount")
    private BigDecimal priceDiscount;
    @Column(name = "final_price")
    private BigDecimal finalPrice;
    @Column(name = "state")
    private String state;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_orders", referencedColumnName = "id_orders")
    @ManyToOne(fetch = FetchType.LAZY)
    private Orders idOrders;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product idProduct;

}

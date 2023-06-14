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
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orders")
    private Integer idOrders;
    @Basic(optional = false)
    @Column(name = "date_orders")
    @Temporal(TemporalType.DATE)
    private Date dateOrders;
    @Basic(optional = false)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @Column(name = "number")
    private String number;
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
    @Basic(optional = false)
    @Column(name = "cost_discount")
    private BigDecimal costDiscount;
    @Basic(optional = false)
    @Column(name = "igv_discount")
    private BigDecimal igvDiscount;
    @Basic(optional = false)
    @Column(name = "price_discount")
    private BigDecimal priceDiscount;
    @Basic(optional = false)
    @Column(name = "final_price")
    private BigDecimal finalPrice;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client idClient;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee idEmployee;
    @OneToMany(mappedBy = "idOrders", fetch = FetchType.LAZY)
    private List<DetailOrder> detailOrderList;

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

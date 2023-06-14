package com.uch.chicken.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person idPerson;
    @OneToMany(mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<Orders> ordersList;

}

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
@Table(name = "profile_module")
@NamedQueries({
        @NamedQuery(name = "ProfileModule.findAll", query = "SELECT p FROM ProfileModule p")})
public class ProfileModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profile_module")
    private Integer idProfileModule;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_module", referencedColumnName = "id_module")
    @ManyToOne(fetch = FetchType.LAZY)
    private Module idModule;
    @JoinColumn(name = "id_profile", referencedColumnName = "id_profile")
    @ManyToOne(fetch = FetchType.LAZY)
    private Profile idProfile;
}
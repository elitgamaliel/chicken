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
@Table(name = "user_profile")
@NamedQueries({
        @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u")})
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_profile")
    private Integer idUserProfile;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_profile", referencedColumnName = "id_profile")
    @ManyToOne(fetch = FetchType.LAZY)
    private Profile idProfile;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User idUser;
}
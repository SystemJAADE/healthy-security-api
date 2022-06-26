package com.systemjaade.healthy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class HealthyUser {
    @Id
    @Basic(optional = false)
    @Column(name = "users_id")
    private int userID;

    @Column(name = "user" )
    @Basic(optional = false)
    private String username;

    @Column(name = "password")
    @Basic(optional = false)
    private String password;

}

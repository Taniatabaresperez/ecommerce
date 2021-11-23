package com.ecommerce.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_email",unique = true,length = 50,nullable = false)
    private String email;
    @Column(name = "user_password",length = 50,nullable = false)
    private String password;
    @Column(name = "user_name",length = 80,nullable = false)
    private String name;
}

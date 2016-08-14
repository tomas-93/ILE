package com.tomas.ile.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 12/08/2016
 */
@Entity
@Table(name = "user")
@NamedQueries(value = {
        @NamedQuery(name="user.find",query="from UserEntity")
})
public class UserEntity implements Serializable
{
    private Long id;
    private String name;
    private String surname;
    private String email;

    public UserEntity()
    {
    }

    public UserEntity(String name, String surname, String email)
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}

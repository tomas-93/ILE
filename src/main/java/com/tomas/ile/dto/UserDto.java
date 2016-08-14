package com.tomas.ile.dto;

import com.tomas.ile.valid.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 12/08/2016
 */
public class UserDto
{
    private Long id;
    @NotEmpty(message = "{error.user.form.name}")
    @NotNull(message = "{error.user.form.name}")
    @Valid
    private String name;
    @NotEmpty(message = "{error.user.form.surname}")
    @NotNull(message = "{error.user.form.surname}")
    @Valid
    private String surname;
    @Email(message="{error.user.form.email}")
    @Valid
    private String email;

    public UserDto()
    {

    }

    public UserDto(String name, String surname, String email)
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public UserDto(Long id, String name, String surname, String email)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}

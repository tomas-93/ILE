package com.tomas.ile.services;

import com.tomas.ile.dto.UserDto;

import java.util.List;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 12/08/2016
 */
public interface UserServices
{
    /**
     * Obtitne un usuario
     *
     * @param id Identificador del ususrio
     * @return El objeto encontrado, retorna null si no lo encuentra
     */
    UserDto getUser(long id);

    /**
     * Obtiene una lista de usuarios de la base de datos
     *
     * @return Retorna un objeeto list con los usuarios de la base de datos
     */
    List<UserDto> getAllUser();

    /**
     * Agrega un ususario
     *
     * @param userDto reprecenta el objeto que encapsula los nuevos datos
     */
    void addUserDto(UserDto userDto);

    /**
     * Actualiza un objeto de la base de datos
     *
     * @param userDto reprecenta el objeto que encapsula los nuevos datos
     */
    void updateUserDto(UserDto userDto);

    /**
     * Elimina un objeto de la base de datos
     *
     * @param id Identificador que reprecenta un objeto de la base de datos
     */
    void removeUserDto(Long id);

}

package com.tomas.ile.services;

import com.tomas.ile.dto.UserDto;
import com.tomas.ile.entity.UserEntity;
import com.tomas.ile.repository.DAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 12/08/2016
 */
@Service
@Transactional
public class UserServicesImp implements UserServices
{
    @Inject
    private DAO dao;

    /**
     * Obtitne un usuario
     *
     * @param id Identificador del ususrio
     * @return El objeto encontrado, retorna null si no lo encuentra
     */
    @Override
    public UserDto getUser(long id)
    {
        UserEntity userEntity = dao.get(UserEntity.class, id);
        return new UserDto(userEntity.getId(), userEntity.getName(), userEntity.getSurname(), userEntity.getEmail());
    }

    /**
     * Obtiene una lista de usuarios de la base de datos
     *
     * @return Retorna un objeeto list con los usuarios de la base de datos
     */
    @Override
    public List<UserDto> getAllUser()
    {
        List<UserEntity> listUser = (List<UserEntity>) this.dao.findByNamedQuery("user.find");
        return !listUser.isEmpty() ? listUser.stream()
                .map(entity -> new UserDto(entity.getId(), entity.getName(), entity.getSurname(), entity.getEmail()))
                .collect(Collectors.toList()) : null;
    }

    /**
     * Agrega un ususario
     *
     * @param userDto reprecenta el objeto que encapsula los nuevos datos
     */
    @Override
    public void addUserDto(UserDto userDto)
    {
        this.dao.save(new UserEntity(userDto.getName(), userDto.getSurname(), userDto.getEmail()));
    }

    /**
     * Actualiza un objeto de la base de datos
     *
     * @param userDto reprecenta el objeto que encapsula los nuevos datos
     */
    @Override
    public void updateUserDto(UserDto userDto)
    {
        UserEntity user = this.dao.get(UserEntity.class, userDto.getId());
        if (user != null)
            this.dao.update(new UserEntity(userDto.getName(), userDto.getSurname(), userDto.getEmail()));
    }

    /**
     * Elimina un objeto de la base de datos
     *
     * @param id Identificador que reprecenta un objeto de la base de datos
     */
    @Override
    public void removeUserDto(Long id)
    {
        UserEntity user = this.dao.get(UserEntity.class, id);
        if (user != null)
            this.dao.delete(user);

    }
}

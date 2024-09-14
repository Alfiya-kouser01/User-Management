package com.codedecode.userinfo.mapper;
import com.codedecode.userinfo.DTO.UserDTO;
import com.codedecode.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOTOUser(UserDTO userDTO);
    UserDTO mapUserTOUserDTO(User user);


}

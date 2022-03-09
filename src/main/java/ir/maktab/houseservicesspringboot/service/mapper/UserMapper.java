package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.UserDto;
import ir.maktab.houseservicesspringboot.model.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class UserMapper {

    private User user;

    public User toUser(UserDto userDto){
        user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto toUserDto(User user){
        return UserDto.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .userStatus(user.getUserStatus())
                .registrationDate(user.getRegistrationDate())
                .role(user.getRole())
                .build();
    }
}

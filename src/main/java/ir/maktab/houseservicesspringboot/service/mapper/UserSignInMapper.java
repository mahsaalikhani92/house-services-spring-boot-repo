package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.UserSignInDto;
import ir.maktab.houseservicesspringboot.model.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class UserSignInMapper {
    private User user;

    public User toUser(UserSignInDto userSignInDto){
        user = new User();
        user.setEmail(userSignInDto.getEmail());
        user.setPassword(userSignInDto.getPassword());
        return user;
    }
}

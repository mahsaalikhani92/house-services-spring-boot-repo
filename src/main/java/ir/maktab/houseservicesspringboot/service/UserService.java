package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.UserDto;
import ir.maktab.houseservicesspringboot.model.dto.UserFilterDto;
import ir.maktab.houseservicesspringboot.model.dto.UserSignInDto;
import ir.maktab.houseservicesspringboot.model.entity.User;

import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface UserService {

    List<UserDto> getUsersByFilter(UserFilterDto userFilterDto);

    User signIn(UserSignInDto userSignInDto);
}

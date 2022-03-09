package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.dao.UserDao;
import ir.maktab.houseservicesspringboot.dao.UserSpecifications;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.model.dto.UserDto;
import ir.maktab.houseservicesspringboot.model.dto.UserFilterDto;
import ir.maktab.houseservicesspringboot.model.dto.UserSignInDto;
import ir.maktab.houseservicesspringboot.model.entity.User;
import ir.maktab.houseservicesspringboot.service.mapper.UserMapper;
import ir.maktab.houseservicesspringboot.service.mapper.UserSignInMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Mahsa Alikhani m-58
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserDao userDao;
    private final UserMapper userMapper;
    private final UserSignInMapper userSignInMapper;

    @Override
    public List<UserDto> getUsersByFilter(UserFilterDto userFilterDto){
        Pageable pageable = PageRequest.of(userFilterDto.getPageNumber(), userFilterDto.getPageSize());
        Specification<User> specification = UserSpecifications.filterUsers(userFilterDto);
        return userDao
                .findAll(specification, pageable)
                .stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public User signIn(UserSignInDto userSignInDto) {
        User user = userSignInMapper.toUser(userSignInDto);
        Optional<User> foundUser = userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(foundUser.isEmpty())
            throw new NotFoundException("User not found!");
        return foundUser.get();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> foundUser = userDao.findByEmail(email);
        if(foundUser.isEmpty())
            throw new UsernameNotFoundException("User not found!");
        return org.springframework.security.core.userdetails.User
                .withUsername(foundUser.get().getEmail())
                .password(foundUser.get().getPassword())
                .roles(String.valueOf(foundUser.get().getRole()))
                .build();
    }
}

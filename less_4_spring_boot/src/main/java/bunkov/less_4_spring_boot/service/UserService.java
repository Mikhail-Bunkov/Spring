package bunkov.less_4_spring_boot.service;

import org.springframework.data.domain.Page;
import bunkov.less_4_spring_boot.controller.UserDto;
import bunkov.less_4_spring_boot.controller.UserListParams;
import bunkov.less_4_spring_boot.persist.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();

    Page<UserDto> findWithFilter(UserListParams userListParams);

    Optional<UserDto> findById(Long id);

    void save(UserDto user);

    void deleteById(Long id);
}
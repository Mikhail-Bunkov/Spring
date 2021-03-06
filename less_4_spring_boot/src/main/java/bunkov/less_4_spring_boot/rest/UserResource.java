package bunkov.less_4_spring_boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import bunkov.less_4_spring_boot.controller.NotFoundException;
import bunkov.less_4_spring_boot.controller.UserDto;
import bunkov.less_4_spring_boot.controller.UserListParams;
import bunkov.less_4_spring_boot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/filter", produces = "application/json")
    public Page<UserDto> findWithFilter(UserListParams userListParams) {
        return userService.findWithFilter(userListParams);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public UserDto findById(@PathVariable("id") Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @PostMapping(produces = "application/json")
    public UserDto create(@RequestBody UserDto user) {
        if (user.getId() != null) {
            throw new BadRequestException("User Id should be null");
        }
        userService.save(user);
        return user;
    }

    @PutMapping(produces = "application/json")
    public void update(@RequestBody UserDto user) {
        if (user.getId() == null) {
            throw new BadRequestException("User Id shouldn't be null");
        }
        userService.save(user);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}
package com.leave.controller;


import com.leave.dto.UserDto;
import com.leave.entity.User;
import com.leave.exception.ResourceNotFoundException;
import com.leave.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.leave.exception.ApiError.fieldError;
import static com.leave.utils.ResponseBuilder.error;
import static com.leave.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@Api(tags = "User Data")
@RequestMapping(
        "/api/user"
)
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    @ApiOperation(value = "save user", response = UserDto.class)
    public ResponseEntity<JSONObject> save(@Valid @RequestBody UserDto dto,
                                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }

        User user = userService.save(dto);
        return ok(success(UserDto.from(user)).getJson());
    }

    @PutMapping("/update")
    @ApiOperation(value = "save user", response = UserDto.class)
    public ResponseEntity<JSONObject> update(@Valid @RequestBody UserDto dto,
                                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }

        User user = userService.findById(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        UserDto userDto = UserDto.from(user);
        User updatedUser = userService.save(userDto);
        return ok(success(UserDto.from(updatedUser)).getJson());
    }

    @PutMapping("/all-users")
    @ApiOperation(value = "save user", response = UserDto.class)
    public ResponseEntity<JSONObject> findAll() {
        List<User> users = userService.findAll();
        List<UserDto> dtos = users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
        return ok(success(dtos).getJson());
    }
}

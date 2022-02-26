package com.leave.dto;

import com.leave.entity.User;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String username;

    public static UserDto from(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        return dto;
    }
}

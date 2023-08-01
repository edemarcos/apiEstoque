package com.projeto.estoque.DTO;

import com.projeto.estoque.models.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private String name;
    private String email;

    public UserDTO convert(User user) {
        BeanUtils.copyProperties(user, this, "id", "password", "admin");
        return this;
    }

    public List<UserDTO> convertList(List<User> userList){
        UserDTO userDTO = new UserDTO();
        List<UserDTO> userDTOList = new ArrayList<>();
        userList.forEach(user -> {
            userDTOList.add(userDTO.convert(user));
        });
        return userDTOList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

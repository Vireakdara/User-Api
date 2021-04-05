package com.example.demo.rest.restcontroller;

import com.example.demo.repository.Dto.UserDto;
import com.example.demo.rest.request.UserRequestModel;
import com.example.demo.rest.response.BaseApiResponse;
import com.example.demo.service.Imp.UserServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {
    private UserServiceImp userService;

    @Autowired
    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<BaseApiResponse<UserRequestModel>> insert(@RequestBody UserRequestModel user) {

        BaseApiResponse<UserRequestModel> response = new BaseApiResponse<>();

        // Validate ->

        ModelMapper modelMapper = new ModelMapper();

        UserDto userDto = modelMapper.map(user, UserDto.class);

//        userDto.setUser_id(464);

        UserDto result = userService.insert(userDto);

        UserRequestModel result2 = modelMapper.map(result, UserRequestModel.class);

        response.setMessage("You have add article successfully");
        response.setData(result2);
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<BaseApiResponse<List<UserRequestModel>>> select() {

        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<List<UserRequestModel>> response = new BaseApiResponse<>();

        List<UserDto> userDtoList = userService.select();
        List<UserRequestModel> users = new ArrayList<>();

        for (UserDto userDto : userDtoList){
            users.add(mapper.map(userDto, UserRequestModel.class));
        }

        response.setMessage("You have found all users successfully");
        response.setData(users);
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }
}

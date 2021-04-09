package com.example.demo.rest.restcontroller;

import com.example.demo.repository.Dto.UserTableDto;
import com.example.demo.rest.request.UserTableRequestModel;
import com.example.demo.rest.response.BaseApiResponse;
import com.example.demo.service.Imp.UserTableServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserTableRestController {
    private UserTableServiceImp userService;

    @Autowired
    public void setUserService(UserTableServiceImp userService) {
        this.userService = userService;
    }

    @PostMapping("/tableusers")
    public ResponseEntity<BaseApiResponse<UserTableRequestModel>> insert(@RequestBody UserTableRequestModel user) {

        BaseApiResponse<UserTableRequestModel> response = new BaseApiResponse<>();

        // Validate ->

        ModelMapper modelMapper = new ModelMapper();

        UserTableDto userTableDto = modelMapper.map(user, UserTableDto.class);

//        userDto.setUser_id(464);

        UserTableDto result = userService.insert(userTableDto);

        UserTableRequestModel result2 = modelMapper.map(result, UserTableRequestModel.class);

        response.setMessage("You have add article successfully");
        response.setData(result2);
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/tableusers")
    public ResponseEntity<BaseApiResponse<List<UserTableRequestModel>>> select() {

        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<List<UserTableRequestModel>> response = new BaseApiResponse<>();

        List<UserTableDto> userTableDtoList = userService.select();
        List<UserTableRequestModel> users = new ArrayList<>();

        for (UserTableDto userTableDto : userTableDtoList){
            users.add(mapper.map(userTableDto, UserTableRequestModel.class));
        }

        response.setMessage("You have found all users successfully");
        response.setData(users);
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }
}

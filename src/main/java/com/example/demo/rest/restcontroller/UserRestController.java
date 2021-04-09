package com.example.demo.rest.restcontroller;

import com.example.demo.repository.Dto.UserDto;
import com.example.demo.rest.request.UserRequestModel;
import com.example.demo.rest.response.BaseApiResponse;
import com.example.demo.rest.response.Messages;
import com.example.demo.rest.response.UserRest;
import com.example.demo.rest.utils.ApiUtils;
import com.example.demo.rest.utils.DateTimeUtils;
import com.example.demo.service.Imp.UserServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private UserServiceImp userService;
    private ApiUtils apiUtils;
    private DateTimeUtils dateTimeUtils;

    @Autowired
    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }


    @Autowired
    public void setApiUtils(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }

    @Autowired
    public void setDateTimeUtils(DateTimeUtils dateTimeUtils) {
        this.dateTimeUtils = dateTimeUtils;
    }

    @PostMapping("/users")
    ResponseEntity<BaseApiResponse<UserRest>> insert(@RequestBody UserRequestModel user){

        BaseApiResponse<UserRest> response = new BaseApiResponse<>();

        UserDto userDto = apiUtils.mapper().map(user, UserDto.class );

        userDto.setUserId("qwerqwer");

        UserDto insertedUser = userService.insert(userDto);

        UserRest userRest = apiUtils.mapper().map(insertedUser, UserRest.class);

        response.setSuccess(true);
        response.setMessage(Messages.Success.INSERT_SUCCESS.getMessage());
        response.setData(userRest);
        response.setStatus(HttpStatus.OK);
        response.setTime(dateTimeUtils.getCurrentTime());

        return ResponseEntity.ok(response);

    }
}

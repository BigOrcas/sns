package com.bigwhale.sns.controller;

import com.bigwhale.sns.controlloer.request.UserJoinRequest;
import com.bigwhale.sns.controlloer.request.UserLoginRequest;
import com.bigwhale.sns.model.User;
import com.bigwhale.sns.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
// 테스트를 위해 실제 객체와 비슷한 객체를 만드는 것을 모킹이라 하고, 테스트하려는 객체가 복잡한 의존성을 가지고 있을때, 모킹한 객체를 이용하면 의존성을 단절시킬 수 있어 쉽게 테스트 가능하다.
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserService userService;


    @Test
    public void 회원가입() throws Exception{
        String userName ="userName";
        String password = "password";

        // TODO : mocking
        when(userService.join(userName,password)).thenReturn(mock(User.class));

        mockMvc.perform(post("/api/v1/users/join")
                .contentType(MediaType.APPLICATION_JSON)
                // TODO : add request body
                .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName,password)))
                ).andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void 회원가입_이미_회원가입된_userName으로_가입했을_경우_에러반환() throws Exception{
        String userName ="userName";
        String password = "password";

        // TODO : mocking
        when(userService.join(userName,password)).thenThrow(new RuntimeException());

        mockMvc.perform(post("/api/v1/users/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        // TODO : add request body
                        .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName,password)))
                ).andDo(print())
                .andExpect(status().isConflict());

    }
    @Test
    public void 로그인() throws Exception{
        String userName ="userName";
        String password = "password";

        // TODO : mocking
        when(userService.login(userName,password)).thenReturn("test_token");

        mockMvc.perform(post("/api/v1/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        // TODO : add request body
                        .content(objectMapper.writeValueAsBytes(new UserLoginRequest(userName,password)))
                ).andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void 로그인시_회원가입이_안된_userName을_입력한경우_에러반환() throws Exception{
        String userName ="userName";
        String password = "password";

        // TODO : mocking
        when(userService.login(userName,password)).thenReturn("test_token");

        mockMvc.perform(post("/api/v1/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        // TODO : add request body
                        .content(objectMapper.writeValueAsBytes(new UserLoginRequest(userName,password)))
                ).andDo(print())
                .andExpect(status().isNotFound());

    }
    @Test
    public void 로그인시_틀린_password을_입력한경우_에러반환() throws Exception{
        String userName ="userName";
        String password = "password";

        // TODO : mocking
        when(userService.login(userName,password)).thenReturn("test_token");

        mockMvc.perform(post("/api/v1/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        // TODO : add request body
                        .content(objectMapper.writeValueAsBytes(new UserLoginRequest(userName,password)))
                ).andDo(print())
                .andExpect(status().isUnauthorized());

    }

}

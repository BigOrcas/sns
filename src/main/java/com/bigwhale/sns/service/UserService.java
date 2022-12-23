package com.bigwhale.sns.service;

import com.bigwhale.sns.model.User;
import com.bigwhale.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserEntityRepository userEntityRepository;

    // TODO : implement
    public User join(String userName,String password){
        // 회원가입하려는 userName으로 회원가입된 user가 있는지
        userEntityRepository.findByUserName(userName);

        // 회원가입 진행 = user를 등록

        return new User();
    }
    public String login(){
        return "";
    }
}

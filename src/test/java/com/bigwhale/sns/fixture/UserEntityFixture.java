package com.bigwhale.sns.fixture;

import com.bigwhale.sns.model.entity.UserEntity;

public class UserEntityFixture {
    // test용 userEntity
    public static UserEntity get(String userName,String password){
        UserEntity result = new UserEntity();
        result.setId(1);
        result.setUserName(userName);
        result.setPassword(password);

        return  result;
    }

}

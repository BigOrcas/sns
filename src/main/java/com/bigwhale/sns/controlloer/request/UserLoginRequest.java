package com.bigwhale.sns.controlloer.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginRequest {
    String userName ="userName";
    String password = "password";
}

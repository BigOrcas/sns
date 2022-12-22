package com.bigwhale.sns.controlloer.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinRequest {
    String userName ="userName";
    String password = "password";
}

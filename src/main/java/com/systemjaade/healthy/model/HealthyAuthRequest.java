package com.systemjaade.healthy.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HealthyAuthRequest {
    private String username;
    private String password;
}

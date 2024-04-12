package entity;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User{
    private String userID;
    private String username;
    private String password;
}

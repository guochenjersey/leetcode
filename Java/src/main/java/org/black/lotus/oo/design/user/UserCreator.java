package org.black.lotus.oo.design.user;

import lombok.Data;

public class UserCreator {

}


@Data
class User {
    private long userId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String zipcode;
    private String streetName;
    private String city;
    private String state;
}

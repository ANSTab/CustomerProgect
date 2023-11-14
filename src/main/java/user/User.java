package user;

import tools.PropertyReadHelper;

public class User {

    public static String getProfileName() {
        return new PropertyReadHelper().readFromPropertyFile("profileName");
    }

    public static String getEmail() {
        return new PropertyReadHelper().readFromPropertyFile("email");
    }

    public static String getPassword() {
        return new PropertyReadHelper().readFromPropertyFile("password");
    }
}

package constant;

import core.properties.PropertiesReader;

public class UsersServiceHost extends BaseHost {
    public static final String CREATE_USER = String.format("%s/v2/user/createWithArray", getHost());
    public static final String UPDATE_USER = String.format("%s/v2/user/{username}", getHost());
    public static final String GET_USER = String.format("%s/v2/user/{username}", getHost());
}

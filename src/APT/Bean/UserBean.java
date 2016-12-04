package APT.Bean;

import APT.Seriable;

/**
 * Created by bwelco on 2016/12/2.
 */
public class UserBean {

    @Seriable
    String name;

    @Seriable
    String age;

    // 不注解
    String length;
}

package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.entity.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}
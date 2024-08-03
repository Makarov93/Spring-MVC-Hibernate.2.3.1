package web.dao;

import web.model.User;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
}

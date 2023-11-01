package web.dao;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

//    void createUser(User user);
//
//    void updateUser(User user);
//
//    User readUser(long id);
//
//    User deleteUser(long id);
}

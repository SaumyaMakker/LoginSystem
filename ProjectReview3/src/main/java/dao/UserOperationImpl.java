package dao;

import model.User;

public interface UserOperationImpl {
    Integer addUser(User user);
    Integer loginUser(String username,String password);
}

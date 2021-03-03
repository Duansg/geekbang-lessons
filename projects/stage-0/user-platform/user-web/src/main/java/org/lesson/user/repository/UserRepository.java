package org.lesson.user.repository;

import org.lesson.user.domain.User;

import java.util.Collection;

public interface UserRepository {

    boolean save(User user);

    boolean deleteById(Long userId);

    boolean update(User user);

    User getById(Long userId);

    User getByNameAndPassword(String userName, String password);

    Collection<User> getAll();

}

package cn.yufenghui.lession.user.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lesson.user.db.DBConnectionManager;
import org.lesson.user.domain.User;
import org.lesson.user.repository.DatabaseUserRepository;
import org.lesson.user.repository.UserRepository;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Collection;


public class UserRepositoryTest {

    private String jdbcURL = "jdbc:derby:/db/user-platform;create=true";

    private DBConnectionManager dbConnectionManager = new DBConnectionManager("jdbc", jdbcURL);

    private UserRepository userRepository = new DatabaseUserRepository(dbConnectionManager);

    public static final String DROP_USERS_TABLE_DDL_SQL = "DROP TABLE users";

    public static final String CREATE_USERS_TABLE_DDL_SQL = "CREATE TABLE users(" +
            "id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
            "name VARCHAR(16) NOT NULL, " +
            "password VARCHAR(64) NOT NULL, " +
            "email VARCHAR(64) NOT NULL, " +
            "phoneNumber VARCHAR(64) NOT NULL" +
            ")";

    public static final String INSERT_USER_DML_SQL = "INSERT INTO users(name,password,email,phoneNumber) VALUES " +
            "('A','******','a@gmail.com','1') , " +
            "('B','******','b@gmail.com','2') , " +
            "('C','******','c@gmail.com','3') , " +
            "('D','******','d@gmail.com','4') , " +
            "('E','******','e@gmail.com','5')";

    @Before
    public void setup() throws Exception {
        Connection connection = dbConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        try {
            statement.execute(DROP_USERS_TABLE_DDL_SQL);
        } catch (Exception e) {

        }
        statement.execute(CREATE_USERS_TABLE_DDL_SQL);
        statement.executeUpdate(INSERT_USER_DML_SQL);
    }

    @After
    public void destroy() throws Exception {
        Connection connection = dbConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        try {
            statement.execute(DROP_USERS_TABLE_DDL_SQL);
        } catch (Exception e) {

        }
    }

    @Test
    public void getAllTest() throws Exception {

        Collection<User> userList = userRepository.getAll();
        System.out.println(userList);

        dbConnectionManager.releaseConnection();
    }

    @Test
    public void getByNameAndPasswordTest() throws Exception {

        User user = userRepository.getByNameAndPassword("B", "******");
        System.out.println(user);
    }

}

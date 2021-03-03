package org.lesson.user.web.controller;

import cn.yufenghui.lession.web.mvc.controller.RestController;
import org.lesson.user.db.DBConnectionManager;
import org.lesson.user.repository.DatabaseUserRepository;
import org.lesson.user.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/hello")
public class HelloWorldController2 implements RestController {

    private String jdbcURL = "jdbc:derby:/db/user-platform;create=true";
    private DBConnectionManager dbConnectionManager = new DBConnectionManager("jdbc", jdbcURL);
    private UserRepository userRepository = new DatabaseUserRepository(dbConnectionManager);


    @GET
    @Path("/world2")
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return userRepository.getByNameAndPassword("A", "******");
    }

}

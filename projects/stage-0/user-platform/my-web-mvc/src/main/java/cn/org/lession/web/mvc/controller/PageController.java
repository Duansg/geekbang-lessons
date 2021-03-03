package cn.org.lession.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface PageController extends Controller {

    /**
     * 执行
     *
     * @param request
     * @param response
     * @return 视图路径
     * @throws Throwable
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable;

}

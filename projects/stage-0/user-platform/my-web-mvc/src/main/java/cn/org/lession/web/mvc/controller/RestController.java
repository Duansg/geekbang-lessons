package cn.org.lession.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface RestController extends Controller {

    /**
     * 执行
     *
     * @param request
     * @param response
     * @return 返回JSON数据
     * @throws Throwable
     */
    Object execute(HttpServletRequest request, HttpServletResponse response) throws Throwable;

}

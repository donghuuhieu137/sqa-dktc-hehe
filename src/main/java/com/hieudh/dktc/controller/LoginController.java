package com.hieudh.dktc.controller;

import com.hieudh.dktc.entity.User;
import com.hieudh.dktc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(
            ModelMap model,
            HttpSession session,
            HttpServletRequest request
    ){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            long userID = userService.login(username, password);
            if (userID == -1) {
                model.put("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng");
                return "login";
            } else {
            	User user = userService.getUserByName(username);
                session.setAttribute("id", userID);
                return "redirect:homepage";
            }
        } catch (Exception e){
            model.put("errorMessage", "Đã xảy ra lỗi vui lòng thử lại sau");
        }
        
        return "login";
    }

}

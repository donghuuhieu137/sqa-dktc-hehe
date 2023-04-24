package com.hieudh.dktc.controller;

import com.hieudh.dktc.dto.RegisterDTO;
import com.hieudh.dktc.entity.User;
import com.hieudh.dktc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository injectedBean) {
		this.userRepository = injectedBean;
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap model){
        return "register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String showWelcomePage(
            ModelMap model,
            HttpServletRequest request
    ){
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setUsername(request.getParameter("username"));
        registerDTO.setPassword(request.getParameter("password"));
        registerDTO.setHoVaTen(request.getParameter("full_name"));
        registerDTO.setPhone(request.getParameter("phone_number"));
        registerDTO.setKhoa(Integer.parseInt(request.getParameter("khoa")));
        registerDTO.setMaSinhVien(request.getParameter("ma_sinh_vien"));
        registerDTO.setEmail(request.getParameter("email"));

        User user = new User();
        if(validInfo(registerDTO, model, request)){
            user.setUsername(registerDTO.getUsername());
            user.setPassword(registerDTO.getPassword());
            user.setHoVaTen(registerDTO.getHoVaTen());
            user.setKhoa(registerDTO.getKhoa());
            user.setPhone(registerDTO.getPhone());
            user.setEmail(registerDTO.getEmail());
            user.setMaSinhVien(registerDTO.getMaSinhVien());

            try {
                userRepository.save(user);
                return "redirect:login";
            } catch (Exception e){
                e.printStackTrace();
                return "register";
            }
        } else {
            return "register";
        }
    }

    Boolean validInfo(RegisterDTO registerDTO, ModelMap model, HttpServletRequest request){
        if(!registerDTO.getUsername().isEmpty()){
            if(registerDTO.getUsername().length() < 6){
                model.put("errorMessage", "Tên đăng nhập phải chứa từ 6 kí tự");
                return false;
            }
        } else {
            model.put("errorMessage", "Tên đăng nhập không được để trống");
            return false;
        }

        if(!registerDTO.getPassword().isEmpty()){
            if(registerDTO.getPassword().length() < 6){
                model.put("errorMessage", "Mật khẩu phải chứa từ 6 kí tự");
                return false;
            } else {
                if (!registerDTO.getPassword().equals(request.getParameter("confirm_password"))) {
                    model.put("errorMessage", "Mật khẩu không khớp");
                    return false;
                }
            }
        } else {
            model.put("errorMessage", "Vui lòng nhập mật khẩu");
            return false;
        }

        if(registerDTO.getHoVaTen().isEmpty()){
            model.put("errorMessage", "Vui lòng nhập Họ và tên");
            return false;
        }

        if(registerDTO.getPhone().isEmpty()){
            model.put("errorMessage", "Vui lòng nhập số điện thoại");
            return false;
        }

        if(registerDTO.getEmail().isEmpty()){
            model.put("errorMessage", "Vui lòng nhập thư điện tử");
            return false;
        }
        return true;
    }
}

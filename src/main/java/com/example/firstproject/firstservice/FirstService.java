package com.example.firstproject.firstservice;


import java.util.List;
import java.util.Map;

import com.example.firstproject.firstcontroller.Login;
import com.example.firstproject.firstcontroller.Register;
import com.example.firstproject.firstdao.UserPojo;

public interface FirstService {

	public String registerService(Register register) ;

	public UserPojo loginUserService(Login login);

	public List<Map<String, Object>> testService();

}

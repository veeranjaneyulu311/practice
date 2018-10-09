package com.example.firstproject.firstdao;

import java.util.List;
import java.util.Map;

import com.example.firstproject.firstcontroller.Login;
import com.example.firstproject.firstcontroller.Register;

public interface FirstDao {

       public	String registerDao(Register register);

	   public UserPojo loginDao(Login login);

	public List<Map<String, Object>> testDao();

}

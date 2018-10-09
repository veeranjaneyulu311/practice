package com.example.firstproject.firstservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstproject.firstcontroller.Login;
import com.example.firstproject.firstcontroller.Register;
import com.example.firstproject.firstdao.FirstDao;
import com.example.firstproject.firstdao.UserPojo;

@Service
public class FirstServiceImpl implements FirstService {
	@Autowired
	FirstDao firstDao;

	@Override
	public String registerService(Register register) {
		
		return firstDao.registerDao(register);
	}

	@Override
	public UserPojo loginUserService(Login login) {
		return firstDao.loginDao(login);
	}

	@Override
	public List<Map<String, Object>> testService() {
		
		return firstDao.testDao();
	}

}

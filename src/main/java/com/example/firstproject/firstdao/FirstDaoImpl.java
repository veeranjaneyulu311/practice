package com.example.firstproject.firstdao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.firstproject.firstcontroller.Login;
import com.example.firstproject.firstcontroller.Register;

@Repository
public class FirstDaoImpl implements FirstDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameter;

	@Override
	public String registerDao(Register register) {
		String registerDao="INSERT INTO REGISTER VALUES(:userName,:email,:mobileNo,:password)";
		
		Map<String, Object> map=new HashMap<>();
		map.put("userName", register.getUserName());
		map.put("email", register.getEmail());
		map.put("mobileNo", register.getMobileNo());
		map.put("password", register.getPassword());

		return namedParameter.update(registerDao, map)==0?"ENTER VALID DETAILS":"REGISTERED SUCCESSFULLY";
			
	}

	@Override
	public UserPojo loginDao(Login login) {
		String loginDao="SELECT USERNAME,EMAIL,MOBILENO,PASSWORD FROM REGISTER WHERE USERNAME=:userName and PASSWORD=:password";
		
		SqlParameterSource paramSource=new MapSqlParameterSource("userName", login.getUserName()).addValue("password", login.getPassword());
		List<Map<String,Object>> lst =namedParameter.queryForList(loginDao, paramSource);

		Map<String, Object> map=lst.get(0);
		UserPojo user=new UserPojo();
		user.setUserName((String) map.get("userName"));
		user.setEmail((String) map.get("email"));
		user.setMobileNo( map.get("mobileNo"));
		user.setPassword((String) map.get("password"));
		
		return user;
   	}

	@Override
	public List<Map<String, Object>> testDao() {
		
		String query="SELECT * FROM LAB.LAB_ANALYSIS_REQUEST_TRANS  LIMIT 10";
		
			return namedParameter.queryForList(query, (Map)null);
		
		
	}
}

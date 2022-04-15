package com.test.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.model.TestDTO;

public interface TestMapper {

	public void insertMember(TestDTO dto); 
	
	// 리턴타입 : 쿼리문실행 레코드수와 데이터 타입에 따라  
	// 매개변수 : 쿼리문 실행시 외부에서 던져줄 데이터에 따라, 쿼리문에 #{} 필요하면 매개변수도 필요 
	public int memberCount(); 
	
	public int maxAge(); 
	
	public List<TestDTO> selectAll(); 
	
	public TestDTO selectOne(String id); 
	
	public Timestamp getReg(String id); 
	
	//public void updateMember(TestDTO dto);
	//public void updateMember(HashMap map);
	public void updateMember(@Param("id") String id, @Param("pw") String pw, @Param("age") int age);
	
	public int selectIf();
	public int selectIf(Integer age);
	
	public int selectIf2(TestDTO dto);
	
	public List<TestDTO> selectIn(ArrayList list); 
	
	public void insertSk(TestDTO dto);
	
	//public List<TestDTO> selectLike(String keyword);
	public List<TestDTO> selectLike(HashMap map);
	
	
}

package com.test.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.mapper.TestMapper;
import com.test.model.TestDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/day06/")
public class TestController6 {

	@Autowired
	private TestMapper testMapper; 
	
	
	// form 화면 요청 
	@GetMapping("form")
	public void form() {
		System.out.println("form 요청");
		
	}
	
	// form에서 넘어온 데이터 처리 요청 
	@PostMapping("pro")
	public void pro(TestDTO dto) {
		System.out.println("pro 요청!!");
		
		// DB 저장 
		testMapper.insertMember(dto);
		
	}
	
	@GetMapping("test")
	public void test() {
		//int count = testMapper.memberCount(); 
		//System.out.println("count : " + count);
		
		//int maxage = testMapper.maxAge(); 
		//System.out.println("maxage : " + maxage);
		
		//List<TestDTO> list = testMapper.selectAll(); 
		//System.out.println(list);
		//list.forEach(dto -> System.out.println(dto));
		
		//TestDTO dto = testMapper.selectOne("spring03"); 
		//System.out.println(dto);
		
		//Timestamp reg = testMapper.getReg("spring02");
		//System.out.println(reg);
		
		//testMapper.updateMember("spring01", "5555", 50);
		
		// **** 동적쿼리 ****
		//int count = testMapper.selectIf(10); 
		//int count = testMapper.selectIf(); 
		//System.out.println(count);
		// id 중복 여부확인 
		//TestDTO dto = new TestDTO(); 
		//dto.setId("spring01");
		// id,pw 일치하는지 확인 (로그인체크) 
		//dto.setPw("5555");
		//int count = testMapper.selectIf2(dto); 
		//System.out.println("count : " + count);
		/*
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		List<TestDTO> resultList = testMapper.selectIn(list); 
		System.out.println(resultList);
		resultList.forEach(dto -> System.out.println(dto));
		
		
		//selectKey 
		TestDTO dto = new TestDTO(); 
		dto.setId("spring10");
		dto.setPw("0101");
		testMapper.insertSk(dto);
		
		System.out.println("dto: " + dto);
		*/
		
		/* id에 s라는 문자가 포함된 정보 모두 추출 
		List<TestDTO> list = testMapper.selectLike("s"); 
		System.out.println(list);
		list.forEach(dto -> System.out.println(dto));
		*/
		
		// 컬럼명(검색기준) 과 키워드 두개를 보내서 일치하는것 찾기 
		HashMap map = new HashMap();
		map.put("column", "age");  // select 박스로 사용자가 선택한 검색 기준 
		map.put("keyword", "10");  // 검색 키워드 작성한것 
		List<TestDTO> list = testMapper.selectLike(map); 
		System.out.println(list);
		list.forEach(dto -> System.out.println(dto));
		
		
		
	}
	
	
	
	
	
	
	
	
	/*
	// localhost:8080/day06/pro?id=java&pw=1234&age=10
	//@RequestMapping(value="pro", params="id=java") // id파라미터는 java값으로 와야 요청 성공 
	//@RequestMapping(value="pro", params={"id=java","pw=1234"}) // 파라미터의 유효성 검사 가능 
	//@RequestMapping(value="pro", params={"id=java","pw"}) // pw 파라미터가 넘어오면 ok 값은 상관안함
	//@RequestMapping(value="pro", params={"id=java","pw", "!age"}) // age라는 이름의 파라미터는 넘어오면 안된다
	@RequestMapping("pro")
						// id 파라미터가 넘어오지 않을 경우 default 값 지정 가능 
	//public String pro(@RequestParam(value="id", defaultValue="hello") String id, 
	public String pro(@RequestParam(value="id", required=true) String id,  // id값 필수
			@RequestParam(value="pw", required=true) String pw) {
		
		System.out.println(id);
		System.out.println(pw);
		
		return "day06/pro"; 
	}
	*/
	
	
	
	
	
	
}

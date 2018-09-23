package com.lanhu.work;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lanhu.work.utils.HttpUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={WorkApplication.class})//启动整个springboot工程
public class HttpUtilsTest {
	
	@Autowired
	private HttpUtils httpUtils;
	
	@Test
	public void test() {
		
		/*String url = "http://101.132.195.94/api/v1/category/listpage";
		String httpEntity = "ddfd";
		System.out.println("===============" +httpUtils.httpGet(url, httpEntity));*/
		
	}

}

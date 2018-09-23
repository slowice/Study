package com.lanhu.work;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.lanhu.work.service.OSSHelperService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={WorkApplication.class})//启动整个springboot工程
public class OSSHelperServiceTest {
	
	@Autowired
	private OSSHelperService ossHelperService;
	
	@Test
	public void testUploadFile2OSSByUrl() {
		
		String url = "https://goss.veer.com/creative/vcg/veer/800water/veer-133521686.jpg";
		String folderName="favicon";
		
		System.out.println(ossHelperService.uploadFile2OSSByUrl(url, folderName));
		
		
		
	}

}

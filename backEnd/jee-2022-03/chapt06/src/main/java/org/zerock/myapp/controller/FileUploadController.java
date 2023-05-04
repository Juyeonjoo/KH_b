package org.zerock.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
//@NoArgsConstructor

@RequestMapping("/fileUpload")

@Controller("fileUploadController")
public class FileUploadController {

	@GetMapping("/page")
	public void uploadPage() {
		log.trace("uploadPage() invoked");
		
	}//uploadPage
	
	@PostMapping("/doit")  //action URL	
	public void processMultipart(@RequestParam("files") List<MultipartFile> files, String uploader) {
		log.trace("processMultipart:{}, {} invoked", files, uploader);
		
		files.forEach(f -> {
			log.info("1. f.getName()",f.getName());
			log.info("2. f.getOriginalFilename()", f.getOriginalFilename());
			log.info("3. f.getContentType();",f.getContentType());
			log.info("4. f.getSize()",f.getSize());
			log.info("==================================");
			
			
			if(!"".equals(f.getOriginalFilename())) {//첨부된 파일이 있는지 확인하기
				log.info("File exists.");
				
				try {
					f.transferTo(new File("C:/temp/upload/"+f.getOriginalFilename())); //파일 객체 이용
//					f.transferTo(null) //path객체 
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				/*
				try {
					byte[] bytes = f.getBytes();			//1. 1st method. 바이트열로 파일데이터를 바꿔놓는다.(작은)
//					InputStream is = f.getInputStream(); 	//2. 2nd method. 큰 파일
					
					//cleanup 밑에서 위로 닫아준다.
					@Cleanup FileOutputStream fos = new FileOutputStream("C:/temp/upload"+ f.getOriginalFilename());//어디다가쓸 것이냐
					@Cleanup BufferedOutputStream bos = new BufferedOutputStream(fos);
					
					bos.write(bytes);
					bos.flush();
					
				} catch(IOException e) {
					
					e.printStackTrace();
				}//try-catch
			*/
				
			}//if
		});
	}//processMultipart
	
	
}//end class

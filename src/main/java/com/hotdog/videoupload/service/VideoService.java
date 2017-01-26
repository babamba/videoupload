package com.hotdog.videoupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hotdog.videoupload.repository.VideoDao;
import com.hotdog.videoupload.vo.VideoVo;

@Service
public class VideoService {
	
	private static final String SAVE_PATH = "/upload";
	private static final String URL = "/gallery/assets/";

	@Autowired
	private VideoDao videoDao;
	
	public VideoVo getVideo2(){
		return videoDao.getVideo();
		
	}
	
	public List<VideoVo> getVideo(){
		return videoDao.get();
	}
	
	public String restore(MultipartFile multipartFile){
		String url="";

		try{
			
		if(multipartFile.isEmpty()==true){
			return url;
		}
		
		String originalFileName = multipartFile.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf('.')+1, originalFileName.length());
		String saveFileName = generateSaveFileName(extName);
		Long fileSize = multipartFile.getSize();
		
		InetAddress local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();
		
		VideoVo videoVo = new VideoVo();
		videoVo.setVideo_name(saveFileName);
		videoVo.setVideo_path("http://"+ip+":8088/videoupload/gallery/assets/"+saveFileName);
		
		System.out.println(videoVo);
		
		videoDao.insert(videoVo);
		
		wirteFile(multipartFile,saveFileName);
		
		url = URL + saveFileName;
		
		}catch(IOException e){
		//	throw new UploadFileException("write file");
		//  log 남기기
			throw new RuntimeException("upload file");
		}
		return url;
	}
	
	private void wirteFile(MultipartFile multipartFile, String saveFileName)throws IOException{
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(fileData);
		fos.close();
	}
	
	private String generateSaveFileName(String extName){
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH)+1;
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("."+extName);
		
		return fileName;
	}

}

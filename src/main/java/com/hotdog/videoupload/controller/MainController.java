package com.hotdog.videoupload.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.dto.JSONResult;
import com.hotdog.videoupload.service.VideoService;
import com.hotdog.videoupload.vo.VideoVo;

@Controller
public class MainController {
	
		@Autowired
		private VideoService videoService;
		
		@RequestMapping("/re")
		public String form3(@RequestParam(value="name") String name, Model model) {
			model.addAttribute("name", name);
			return "form3";
		}
		@RequestMapping("/motor")
		public String form2() {
			return "form2";
		}
		
		@RequestMapping("")
		public String form() {
			return "form";
		}
		
		@RequestMapping("/upload")
		public String upload(@RequestParam(value="file1") MultipartFile file1, Model model){
						
			String url1 = videoService.restore(file1);
			
			List<VideoVo> list = videoService.getVideo();

			model.addAttribute("list", list);
			
			return "result";
		}
		
		
		@ResponseBody
		@RequestMapping("/api/getvideo")
		public JSONResult getVideo(){
			
			List<VideoVo> list = videoService.getVideo();
			
			return JSONResult.success(list);
		}
		
		@ResponseBody
		@RequestMapping("/api/getvideo2")
		public JSONResult getVideo2(){
			VideoVo vo = videoService.getVideo2();			
			return JSONResult.success(vo);
		}
		
		
}

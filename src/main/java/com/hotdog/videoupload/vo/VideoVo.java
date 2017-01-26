package com.hotdog.videoupload.vo;

public class VideoVo {
	private Long no;
	private String video_name;
	private String video_path;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getVideo_path() {
		return video_path;
	}
	public void setVideo_path(String video_path) {
		this.video_path = video_path;
	}
	@Override
	public String toString() {
		return "VideoVo [no=" + no + ", video_name=" + video_name + ", video_path=" + video_path + "]";
	}
	
}

package com.hotdog.videoupload.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotdog.videoupload.vo.VideoVo;

@Repository
public class VideoDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public void insert(VideoVo vo){
		sqlSession.insert("video.insertVideo", vo);
	}
	
	public List<VideoVo> get(){
		return sqlSession.selectList("video.getVideo");
	}
	
	public VideoVo getVideo(){
		return sqlSession.selectOne("video.getOneVideo");
	}
}

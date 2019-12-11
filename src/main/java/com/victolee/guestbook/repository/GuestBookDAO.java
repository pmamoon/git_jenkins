package com.victolee.guestbook.repository;


import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.victolee.guestbook.exception.GuestbookExcpetion;
import com.victolee.guestbook.vo.GuestBookVO;

@Repository
public class GuestBookDAO {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<GuestBookVO> getList() throws GuestbookExcpetion{
		List<GuestBookVO> list = sqlSession.selectList("guestbook.getList");
		return list;
	}
	
	public String getPwd(Integer no) throws GuestbookExcpetion {
		String pwd = sqlSession.selectOne("guestbook.getOriginPwd", no);
		return pwd;
	}
	
	public String getInputPwd(String pwd) throws GuestbookExcpetion{
		String parsePwd = sqlSession.selectOne("guestbook.getInputPwd", pwd);
		return parsePwd;
	}
	
	public boolean insert(GuestBookVO vo ) throws GuestbookExcpetion{
		int count = sqlSession.insert("guestbook.insert", vo);
		return count == 1;
	}
	
	public boolean delete(Integer no) throws GuestbookExcpetion{
		int count = sqlSession.delete("guestbook.delete", no);
		return count == 1;
	}

}
package com.victolee.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victolee.guestbook.repository.GuestBookDAO;
import com.victolee.guestbook.vo.GuestBookVO;

@Service
public class GuestbookService {
	@Autowired
	private GuestBookDAO guestBookDAO;
	
	
	public List<GuestBookVO> getList(){
		return guestBookDAO.getList();
	}
	
	
	public boolean insert(GuestBookVO vo ) {
		return guestBookDAO.insert(vo);
	}
	
	
	public boolean delete(GuestBookVO vo) {
		String originPwd = guestBookDAO.getPwd(vo.getNo());
		String inputPwd = guestBookDAO.getInputPwd(vo.getPwd());
		
		if(!originPwd.equals(inputPwd) ) {
			return false;
		}
		
		return guestBookDAO.delete(vo.getNo());
	}
}


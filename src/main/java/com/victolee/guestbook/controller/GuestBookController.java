package com.victolee.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.victolee.guestbook.service.GuestbookService;
import com.victolee.guestbook.vo.GuestBookVO;

@Controller
@RequestMapping("/main")
public class GuestBookController {
	@Autowired
	private GuestbookService guestBookService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String list(Model model) {
		List<GuestBookVO> list = guestBookService.getList();
		model.addAttribute("list", list);
		return "index";
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String insert(GuestBookVO vo) {
		guestBookService.insert(vo);
		return "redirect:/main/";
	}
	
	
	@RequestMapping(value="/deleteform", method=RequestMethod.GET)
	public String delete(@RequestParam Integer no, Model model) {
		model.addAttribute("no",no);
		return "deleteform";
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestBookVO vo) {
		guestBookService.delete(vo);
		return "redirect:/main/";
	}
}

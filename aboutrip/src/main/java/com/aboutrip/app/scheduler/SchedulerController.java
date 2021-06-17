package com.aboutrip.app.scheduler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aboutrip.app.common.AboutUtil;
import com.aboutrip.app.member.SessionInfo;

@Controller("scheduler.schedulerController")
@RequestMapping("/scheduler/*")
public class SchedulerController {

	@Autowired
	private AboutUtil aboutUtil;
	
	@Autowired
	private SchedulerService service;
	
	@RequestMapping(value = "mycalendar", method=RequestMethod.GET)
	public ModelAndView scheduler() throws Exception {
		ModelAndView mav = new ModelAndView(".scheduler.myCalendar");
		return mav;
	}
	
	@PostMapping("insert")
	@ResponseBody
	public Map<String, Object> insertSubmit(Scheduler dto, HttpSession session){
		SessionInfo info = (SessionInfo)session.getAttribute("member");
		int y=0,m=0,d=0;
		String state="true";
		try {
			dto.setUser_num(info.getUserNum());
			y = Integer.parseInt(dto.getCheck_out().substring(0,4));
			m = Integer.parseInt(dto.getCheck_out().substring(5,7));
			d = Integer.parseInt(dto.getCheck_out().substring(8))+1;
			dto.setCheck_out(y+"-"+m+"-"+d);
			service.insertSchedule(dto);
		} catch (Exception e) {
			e.printStackTrace();
			state="false";
		}
		Map<String, Object> model = new HashMap<>();
		model.put("state", state);
		return model;
	}
	
	@RequestMapping(value = "month")
	@ResponseBody
	public Map<String, Object> month(@RequestParam String start, @RequestParam String end, HttpSession session ) throws Exception{
		SessionInfo info = (SessionInfo)session.getAttribute("member");
		Map<String,Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("user_num", info.getUserNum());
		
		List<Scheduler> list = service.listMonth(map);
		for(Scheduler dto:list) {
	    	dto.setStart(dto.getCheck_in());
	    	dto.setEnd(dto.getCheck_out());
	    	dto.setTitle(dto.getSubject());
	    	if( dto.getStart().substring(0,4).compareTo(start.substring(0,4)) != 0 ) {
	    		dto.setStart(start.substring(0,4)+dto.getStart().substring(5));
	    		System.out.println("::::"+dto.getStart());
	    	}	   
		}
		Map<String, Object> model = new HashMap<>();
		
		model.put("list", list);
		return model;
	}
	
	@PostMapping("update")
	@ResponseBody
	public Map<String, Object> updateSubmit(@RequestParam String subject, @RequestParam String color,
			@RequestParam String check_in, @RequestParam String check_out, @RequestParam int num,
			@RequestParam String memo,
			HttpSession session) {
		SessionInfo info=(SessionInfo)session.getAttribute("member");
		Map<String, Object> map = new HashMap<String, Object>();
		String state="true";
		try {
			map.put("subject", subject);
			map.put("check_in", check_in);
			map.put("check_out", check_out);
			map.put("user_num",info.getUserNum());
			map.put("color", color);
			map.put("num", num);
			map.put("memo", memo);
			service.updateScheduler(map);
		} catch (Exception e) {
			state="false";
		}
		
		Map<String, Object> model=new HashMap<>();
		model.put("state", state);
		return model;
	}
	@PostMapping("delete")
	@ResponseBody
	public Map<String, Object> delete(
			@RequestParam int num,
			HttpSession session
			) {
		SessionInfo info=(SessionInfo)session.getAttribute("member");

		String state = "true";
		try {
			Map<String, Object> map=new HashMap<>();
			map.put("user_num", info.getUserNum());
			map.put("num", num);
			service.deleteSchedule(map);
		}catch (Exception e) {
			state = "false";
		}
		
		Map<String, Object> model = new HashMap<>();
		model.put("state", state);
		
		return model;
	}
	
	@RequestMapping(value = "mate", method=RequestMethod.GET)
	public ModelAndView mate() throws Exception {
		ModelAndView mav = new ModelAndView(".scheduler.mate");
		return mav;
	}
	
	@PostMapping("insertMate")
	@ResponseBody
	public String insertMate(Mate dto, HttpSession session){
		SessionInfo info = (SessionInfo)session.getAttribute("member");
		dto.setUser_num(info.getUserNum());
		try {
			service.insertMate(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/scheduler/mate/";
	}
	
	@RequestMapping(value = "matelist")
	@ResponseBody
	public Map<String, Object> matelist(
		    @RequestParam(value="page", defaultValue="1") int current_page,HttpSession session) throws Exception{
		int row =5;
		int dataCount = service.MateCount();
		int total_page = aboutUtil.pageCount(row, dataCount);
		if(current_page>total_page) current_page=total_page;
		
		Map<String, Object> map = new HashMap<>();
		int offset = (current_page-1)* row;
		if(offset<0)offset = 0;
		map.put("offset", offset);
		map.put("rows", row);
		int listNum=0;
		List<Mate> list = service.listMate(map);
		for(Mate dto :list) {
			dto.setContent(dto.getContent().replace("\n", "<br>"));
			listNum++;
		}
		String paging = aboutUtil.pagingMethod(current_page, total_page, "listPage");
		
		Map<String, Object> model = new HashMap<>();
		model.put("listNum", listNum);
		model.put("dataCount", dataCount);
		model.put("total_page", total_page);
		model.put("page", current_page);
		model.put("paging", paging);
		model.put("list", list);
		return model;
	}
}

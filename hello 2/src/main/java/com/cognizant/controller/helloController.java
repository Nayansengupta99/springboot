package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;

@Controller
public class helloController {

	@Autowired
	private StudentService studentService;
	@RequestMapping(value="/log",method=RequestMethod.GET)
	
	
	public String displ() {
	return "login";
}
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("display");

		List<Student> list = studentService.findAll();

		mv.addObject("list", list);

		return mv;

	}

	@RequestMapping(value="insert", method=RequestMethod.GET)
	public ModelAndView insertPage()
	{
		 ModelAndView mv = new ModelAndView("insert");
		 mv.addObject("insert", new Student());
		
		 return mv;
		
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public ModelAndView insert( @ModelAttribute("student") Student s)
	{     
		
		ModelAndView mv = new ModelAndView("insert");
		Student su=new Student(s.getId(),s.getName(),s.getCourse());
		studentService.create(su);
		mv.addObject("msg", "Record Inserted");
		
		return mv;
	}
	
	
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView updatePage(@RequestParam(value="id",required = false) String id)
	{
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("id",id);
		
		return mv;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("student") Student s)
	{
		ModelAndView mv = new ModelAndView("update");
		Student su=new Student(s.getId(),s.getName(),s.getCourse());
		studentService.update(su);
		mv.addObject("msg", "Record Updated");
		
		return mv;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public ModelAndView deletePage(@RequestParam(value="id",required=false) Integer id)
	{
		ModelAndView mv = new ModelAndView("delete");
			
		Integer intobject = new Integer(id);
		int res = studentService.delete(intobject.intValue());
		if (res==1) {
			mv.addObject("msg", "Record Deleted");
		} else {
			mv.addObject("msg", "Record Not Deleted");
		}
		
		return findAll();
		
	}
	
	
	
	
	
}

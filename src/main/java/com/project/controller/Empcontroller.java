package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.project.Sessiohelper;
import com.project.entity.Employee;
import com.project.service.EmpService;

import jakarta.servlet.http.HttpSession;

 
@Controller
public class Empcontroller {
	
	@Autowired
	private Sessiohelper sessiohelper;
	
	@Autowired
	private EmpService empservice;

	@GetMapping("/home")
	public String home(Model m) {
		
  List<Employee> emp=empservice.getAllEmp();
  m.addAttribute("emp",emp);
		return"index";
	}
	
	@GetMapping("/addemp")
	public String AddEmpForm() {
		return"add_emp";
	}
	
	@PostMapping("/register")
	public String empregister(@ModelAttribute Employee e,HttpSession session) {
		System.out.println(e);
		empservice.addemp(e);
		
		  session.setAttribute("msg","employee added succsesfully");
		 		return"redirect:/home";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
    Employee e=empservice.getEmpById(id);
    m.addAttribute("emp",e);
		return"edit";
	}
	
	@PostMapping("update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session) {
		empservice.addemp(e);
		session.setAttribute("msg","the value is updated");
    		return"redirect:/home";
	}
	@GetMapping("/delete/{id}")
	public String delteEmp(@PathVariable int id,HttpSession session) {
		empservice.deleteEmp(id);
		session.setAttribute("msg","the value is deleted");

  		return"redirect:/home";
	}
}

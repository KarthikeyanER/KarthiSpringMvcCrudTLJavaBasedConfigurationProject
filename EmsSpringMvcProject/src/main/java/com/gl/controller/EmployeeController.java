package com.gl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.dao.EmployeeDao;
import com.gl.model.Employee;
import com.gl.service.EmployeeService;
@Controller
@RequestMapping("/")
public class EmployeeController {
	@Autowired
	EmployeeService eService;
	
	@RequestMapping("/employee")
public String empPage(Model model) {
		model.addAttribute("empList", eService.findall());
	return "employee";
}
	@RequestMapping("/addRecord")
	public String addPage(Model model) {
		model.addAttribute("emp",new Employee());
		
		return "addRecord";
	}
//	@PostMapping("/saveRecord")
//	public String saveEmp(@ModelAttribute("emp") Employee e,Model m) {
//		
//		return "redirect:/employee";
//	}
	@PostMapping("/saveEmployee")
	public String empPageReturn(@ModelAttribute("emp") Employee e,Model m) {
		
			eService.save(e);
			m.addAttribute("empList", eService.findall());
		return "employee";
	}

	@PostMapping("/updateEmp")
	public String updateRecord(@RequestParam("id") int id,Model model) {
		model.addAttribute("updatedEmp", eService.getEmpById(id));
		return "updateRecord";
	}
	@PostMapping("/saveUpdateEmployee")
	public String saveUpdateEmployee(@ModelAttribute("updatedEmp") Employee e,Model m) {
		
			eService.update(e);
			
			
			return "redirect:/employee";
	}
	@PostMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int id,Model model) {
		Employee e=eService.getEmpById(id);
			eService.delete(e);
			
			return "redirect:/employee";
	}
	
	
	
	
}

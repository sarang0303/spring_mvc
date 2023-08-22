package spring_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc.dto.Employee;
import spring_mvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	ModelAndView modelAndView = new ModelAndView();

	@RequestMapping("signup")
	public ModelAndView signUpEmployee() {

		modelAndView.addObject("employee", new Employee());// overloded method
		modelAndView.setViewName("signup.jsp");
		return modelAndView;
	}

	@RequestMapping("save")
	public ModelAndView saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
		modelAndView.setViewName("home.jsp");
		return modelAndView;

	}

	@RequestMapping("login")
	public ModelAndView loginEmployee() {
		modelAndView.addObject("emp", new Employee());
		modelAndView.setViewName("login.jsp");
		return modelAndView;

	}

	@RequestMapping("loginemp")
	public ModelAndView login(@ModelAttribute Employee employee) {
		List<Employee> employees = employeeService.getAllEmployee();
		modelAndView.addObject("list", employees);

		Employee dbemployee = employeeService.loginEmployee(employee);
		if (dbemployee != null) {
			modelAndView.setViewName("successpage.jsp");
			return modelAndView;

		} else {
			return modelAndView;
		}
	}

	@RequestMapping("delete")
	public ModelAndView delteEmployee(@RequestParam int id) {
		Employee employee = employeeService.deleteEmployee(id);
		if (employee != null) {
			List<Employee> employees = employeeService.getAllEmployee();
			modelAndView.addObject("list", employees);
			modelAndView.setViewName("successpage.jsp");
			return modelAndView;
		} else {
			modelAndView.setViewName("home.jsp");
			return modelAndView;
		}

	}

	@RequestMapping("update")
	public ModelAndView update(@RequestParam int id) {
		Employee employee = employeeService.findEmployee(id);
		modelAndView.addObject(employee);
		modelAndView.setViewName("edit.jsp");
		return modelAndView;
	}

	@RequestMapping("edit")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		Employee employee2 = employeeService.updateEmployee(employee);
		if (employee2 != null) {
			List<Employee> employees = employeeService.getAllEmployee();
			modelAndView.addObject("list", employees);
			modelAndView.setViewName("successpage.jsp");
			return modelAndView;
		}
		modelAndView.setViewName("home.jsp");
		return modelAndView;

	}

}

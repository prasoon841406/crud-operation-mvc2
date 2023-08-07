package in.prasoon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.prasoon.binding.EmployeeBinding;
import in.prasoon.entity.EmployeeEntity;
import in.prasoon.repository.EmployeeRepository;

@Controller
public class MainController
{
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String welcomePage(Model model)
	{
		return "welcome";
	}
	@GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") String id, Model model) {
        // Fetch employee by ID from your data source (database or service)
		/* EmployeeEntity employee = */Optional<EmployeeEntity> findById = employeeRepository.findById(id);
        
		 if (!findById.isPresent()) {
		        // Handle employee not found case, redirect or display an error message
		        return "redirect:/showEmployee"; // Redirect to employee list page
		    }
		    
		    model.addAttribute("employee", findById.get());
		    return "addEmployee"; // Return the name of your edit employee Thymeleaf template
    }
	
	
	@GetMapping("/addEmployee")
	//@ResponseBody
	public String addEmployee(Model model)
	{
		 model.addAttribute("employee", new EmployeeEntity());
		return "addEmployee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployeeData(EmployeeBinding employee,Model model)
	{
		System.out.println(employee);
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		
		employeeRepository.save(entity);
		model.addAttribute("msg", "data saved");
		return "redirect:/showEmployee";
	}
	@GetMapping("/showEmployee")
	public String showEmployeeData(Model model)
	{
		
		List<EmployeeEntity> employeeList = employeeRepository.findAll();
		model.addAttribute("employees", employeeList);//to send data to ui
		return "showEmployee";
	}
	@GetMapping("/findById")
	public String findById(@RequestParam("empid") String empId,Model model)
	{
		
		Optional<EmployeeEntity> findById = employeeRepository.findById(empId);
		if (findById.isPresent()) {
            EmployeeEntity employee = findById.get();
            System.out.println("employee: "+employee);
            model.addAttribute("employees", employee);
        } else {
            model.addAttribute("employees", null);
        }

        return "findById";
	}
	@GetMapping("/updateByIdForm")
	public String updateByIdFrom(Model model)
	{
		 model.addAttribute("employee", new EmployeeEntity());
		return "updateByIdForm";
	}
	@PostMapping("/updateById")
	public String updateById(@RequestParam("empId") String empId, Model model)
	{
		Optional<EmployeeEntity> employee = employeeRepository.findById(empId);
		EmployeeEntity employeeEntity = employee.get();
		model.addAttribute("employee", employeeEntity);
		return "modifyForm";
	}
	@PostMapping("/saveUpdateEmployee")
	@ResponseBody
	public String saveUpdateEmployee(EmployeeBinding employee,Model model)
	{
		System.out.println(employee);
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		
		employeeRepository.save(entity);
		model.addAttribute("msg", "successfully updated");
		return "updateSuccess";
	}
}

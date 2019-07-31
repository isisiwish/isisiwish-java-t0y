package top.cfish.springmvc.controllers;


import top.cfish.springmvc.beans.AutoWired;
import top.cfish.springmvc.service.SalaryService;
import top.cfish.springmvc.web.mvc.Controller;
import top.cfish.springmvc.web.mvc.RequestMapping;
import top.cfish.springmvc.web.mvc.RequestParam;

@Controller
public class SalaryController
{
    @AutoWired
    private SalaryService salaryService;
    
    @RequestMapping("/get_salary.json")
    public Integer getSalary(@RequestParam("name") String name, @RequestParam("experience") String experience)
    {
        return salaryService.calSalary(Integer.parseInt(experience));
    }
}

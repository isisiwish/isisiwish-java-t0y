package top.cfish.springmvc.service;


import top.cfish.springmvc.beans.Bean;

@Bean
public class SalaryService
{
    public Integer calSalary(Integer experience)
    {
        return experience * 5000;
    }
}

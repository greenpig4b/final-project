package com.example.final_project.company;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CompanyController {
    private final CompanyService companyService;
    private final HttpSession session;



    @GetMapping("/company/test")
    public String image(){

        return "/admin/company/test";
    }
}

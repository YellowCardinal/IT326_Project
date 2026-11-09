package com.egg.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping(value = "/home", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> home() {
        return ResponseEntity.ok(new ClassPathResource("static/home.html"));
    }

    @GetMapping(value = "/student-login", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> studentLogin() {
        return ResponseEntity.ok(new ClassPathResource("static/student-login.html"));
    }

    @GetMapping(value = "/admin-login", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> adminLogin() {
        return ResponseEntity.ok(new ClassPathResource("static/admin-login.html"));
    }

    @GetMapping(value = "/student-home", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> studentHome() {
        return ResponseEntity.ok(new ClassPathResource("static/student-home.html"));
    }

    @GetMapping(value = "/admin-home", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> adminHome() {
        return ResponseEntity.ok(new ClassPathResource("static/admin-home.html"));
    }

    @GetMapping("/login")
    public String redirectLogin() {
        return "redirect:/student-login";
    }

    @GetMapping("/home.html")
    public String redirectHomeHtml() {
        return "redirect:/home";
    }

    @GetMapping("/login.html")
    public String redirectLoginHtml() {
        return "redirect:/student-login";
    }

    @GetMapping("/student-login.html")
    public String redirectStudentLoginHtml() {
        return "redirect:/student-login";
    }

    @GetMapping("/admin-login.html")
    public String redirectAdminLoginHtml() {
        return "redirect:/admin-login";
    }

    @GetMapping("/student-home.html")
    public String redirectStudentHomeHtml() {
        return "redirect:/student-home";
    }

    @GetMapping("/admin-home.html")
    public String redirectAdminHomeHtml() {
        return "redirect:/admin-home";
    }
}

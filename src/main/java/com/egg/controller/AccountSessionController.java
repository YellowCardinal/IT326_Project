package com.egg.controller;

import com.egg.model.Admin;
import com.egg.model.Student;
import com.egg.repository.AdminRepository;
import com.egg.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AccountSessionController {

    private static final String EMAIL_SESSION_KEY = "loggedInAccountEmail";
    private static final String ROLE_SESSION_KEY = "loggedInAccountRole";

    private final StudentRepository studentRepository;
    private final AdminRepository adminRepository;

    public AccountSessionController(
            StudentRepository studentRepository,
            AdminRepository adminRepository) {
        this.studentRepository = studentRepository;
        this.adminRepository = adminRepository;
    }

    @PostMapping("/api/student/login")
    public ResponseEntity<?> studentLogin(
            @RequestBody LoginRequest login,
            HttpServletRequest request) {
        Student student = studentRepository.findByEmail(login.username()).orElse(null);
        if (student == null
                || !Objects.equals(student.getPassword(), login.password())
                || Boolean.TRUE.equals(student.getIsBanned())) {
            return invalidLogin();
        }

        startSession(request, student.getEmail(), "STUDENT");
        return ResponseEntity.ok(new LoginResponse("Student login successful"));
    }

    @PostMapping("/api/admin/login")
    public ResponseEntity<?> adminLogin(
            @RequestBody LoginRequest login,
            HttpServletRequest request) {
        Admin admin = adminRepository.findByEmail(login.username()).orElse(null);
        if (admin == null || !Objects.equals(admin.getPassword(), login.password())) {
            return invalidLogin();
        }

        startSession(request, admin.getEmail(), "ADMIN");
        return ResponseEntity.ok(new LoginResponse("Admin login successful"));
    }

    @GetMapping("/api/me")
    public ResponseEntity<?> currentAccount(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return notLoggedIn();
        }

        Object emailValue = session.getAttribute(EMAIL_SESSION_KEY);
        Object roleValue = session.getAttribute(ROLE_SESSION_KEY);
        if (!(emailValue instanceof String email) || !(roleValue instanceof String role)) {
            return notLoggedIn();
        }

        if ("STUDENT".equals(role)) {
            return studentRepository.findByEmail(email)
                    .map(account -> ResponseEntity.ok((Object) new AccountProfile(
                            "STUDENT", account.getFirstName(), account.getLastName())))
                    .orElseGet(() -> expireSession(session));
        }

        if ("ADMIN".equals(role)) {
            return adminRepository.findByEmail(email)
                    .map(account -> ResponseEntity.ok((Object) new AccountProfile(
                            "ADMIN", account.getFirstName(), account.getLastName())))
                    .orElseGet(() -> expireSession(session));
        }

        return expireSession(session);
    }

    @PostMapping("/api/logout")
    public MessageResponse logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new MessageResponse("Logged out");
    }

    private void startSession(HttpServletRequest request, String email, String role) {
        HttpSession session = request.getSession(true);
        session.setAttribute(EMAIL_SESSION_KEY, email);
        session.setAttribute(ROLE_SESSION_KEY, role);
    }

    private ResponseEntity<MessageResponse> invalidLogin() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new MessageResponse("Invalid username or password"));
    }

    private ResponseEntity<MessageResponse> notLoggedIn() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new MessageResponse("Not logged in"));
    }

    private ResponseEntity<Object> expireSession(HttpSession session) {
        session.invalidate();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new MessageResponse("Account not found"));
    }

    public record LoginRequest(String username, String password) { }
    public record LoginResponse(String message) { }
    public record AccountProfile(String role, String firstName, String lastName) { }
    public record MessageResponse(String message) { }
}

package com.sanket.portfolio;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @GetMapping("/projects")
    public String projects(Model model) {
        List<Project> projects = List.of(
            new Project(
                "TabMelt",
                "Browser extension that summarizes idle tabs using Groq's LLaMA model.",
                List.of("Browser extension", "Groq", "LLaMA")),
            new Project(
                "YDFNet",
                "Multi-module AI-powered traffic management system, built as a team project at VIT Bhopal.",
                List.of("Team project", "AI"))
        );
        model.addAttribute("projects", projects);
        return "projects";
    }
}

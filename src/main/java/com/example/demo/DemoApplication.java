package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Controller
public class DemoApplication {

	private static final String FILE_PATH = "C:/Users/johni/Desktop/demo/demo/src/main/resources/text.txt";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String index(Model model) {
		try {
			Path path = Paths.get(FILE_PATH);
			System.out.println("Reading from file: " + path.toAbsolutePath());
			if (!Files.exists(path)) {
				Files.createFile(path);
				System.out.println("File created at: " + path.toAbsolutePath());
			}
			List<String> todos = Files.lines(path).collect(Collectors.toList());
			model.addAttribute("todos", todos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}

	@PostMapping("/addTodo")
	public String addTodo(@RequestParam String todo) {
		try {
			Path path = Paths.get(FILE_PATH);
			System.out.println("Trying to write to file: " + path.toAbsolutePath());
			if (!Files.exists(path)) {
				Files.createFile(path);
			}
			Files.write(path, (todo + "\n").getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@PostMapping("/editTodo")
	public String editTodo(@RequestParam int index, @RequestParam String newTodo) {
		try {
			Path path = Paths.get(FILE_PATH);
			List<String> todos = Files.lines(path).collect(Collectors.toList());
			if (index >= 0 && index < todos.size()) {
				todos.set(index, newTodo);
				Files.write(path, todos.stream().collect(Collectors.joining("\n")).getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@PostMapping("/deleteTodo")
	public String deleteTodo(@RequestParam int index) {
		try {
			Path path = Paths.get(FILE_PATH);
			List<String> todos = Files.lines(path).collect(Collectors.toList());
			if (index >= 0 && index < todos.size()) {
				todos.remove(index);
				Files.write(path, todos.stream().collect(Collectors.joining("\n")).getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}

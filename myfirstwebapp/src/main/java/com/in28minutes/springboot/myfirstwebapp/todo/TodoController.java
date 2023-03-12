package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model) {
        List<ToDo> todos = todoService.findByUserName("in28Minutes");
        model.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewToDoPage(ModelMap model) {
        String usename = (String) model.get("name");
        ToDo todo = new ToDo(0, usename, "", LocalDate.now().plusYears(4), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewToDoPage(ModelMap model, @ModelAttribute("todo") @Valid ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String usename = (String) model.get("name");
        todoService.addToDo(usename, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }



    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam String id) {
        todoService.deleteToDoById(Integer.parseInt(id));
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam String id, ModelMap model) {
        ToDo todo = todoService.findById(Integer.parseInt(id));
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateToDo(ModelMap model, @ModelAttribute("todo") @Valid ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String usename = (String) model.get("name");
        todo.setUsername(usename);

        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

}

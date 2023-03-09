package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<ToDo> todos  =new ArrayList();
    static {
        todos.add(new ToDo(1, "in28Minutes", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(2, "in28Minutes", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new ToDo(3, "in28Minutes", "Learn Full STack Development", LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUserName(String user) {
        return todos;
    }
}
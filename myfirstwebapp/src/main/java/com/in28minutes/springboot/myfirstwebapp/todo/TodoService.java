package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static final List<ToDo> todos = new ArrayList();
    private static int todoCount = 0;

    static {
        todos.add(new ToDo(++todoCount, "in28Minutes", "Learn AWS Certification", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(++todoCount, "in28Minutes", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new ToDo(++todoCount, "in28Minutes", "Learn Full STack Development", LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUserName(String user) {
        return todos;
    }

    public void addToDo(String user, String description, LocalDate targetDate, boolean isDone) {
        ToDo todo = new ToDo(++todoCount, user, description, targetDate, isDone);
        todos.add(todo);
    }

    public void deleteToDoById(int id) {
        Predicate<? super ToDo> toDoPredicate
                = todo -> todo.getId() == id;
        todos.removeIf(toDoPredicate);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> toDoPredicate
                = todo -> todo.getId() == id;
        ToDo toDo = todos.stream().filter(toDoPredicate).findFirst().get();
        return toDo;
    }

    public void updateTodo(ToDo todo) {
        deleteToDoById(todo.getId());
        todos.add(todo);
    }
}
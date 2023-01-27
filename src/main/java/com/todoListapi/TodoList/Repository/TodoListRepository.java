package com.todoListapi.TodoList.Repository;

import com.todoListapi.TodoList.Model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}

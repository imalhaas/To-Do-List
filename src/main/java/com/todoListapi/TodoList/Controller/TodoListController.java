package com.todoListapi.TodoList.Controller;

import com.todoListapi.TodoList.Model.TodoList;
import com.todoListapi.TodoList.Repository.TodoListRepository;
import com.todoListapi.TodoList.Service.TodoListService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/toDo")
public class TodoListController {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private TodoListService todoListService;

    @GetMapping
    public List<TodoList> listar(){
        return todoListService.listar();
    }

    @GetMapping("/{id}")
    public TodoList buscarPeloId(@PathVariable Long id){
       return todoListService.buscarPeloId(id);
    }

    @PostMapping
    public ResponseEntity<TodoList> criar(@Valid @RequestBody TodoList todoList){
        TodoList todoListSalvo = todoListService.salvar(todoList);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoListSalvo);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable TodoList id){
        todoListService.remover(id);
    }

    @PutMapping("/{id}")
    public TodoList atualizar(@PathVariable Long id, @Valid @RequestBody TodoList todoList){
        return todoListService.atualizar(id, todoList);
    }



}

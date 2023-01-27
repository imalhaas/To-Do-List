package com.todoListapi.TodoList.Service;

import com.todoListapi.TodoList.Model.TodoList;
import com.todoListapi.TodoList.Repository.TodoListRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    public List<TodoList> listar(){
        return todoListRepository.findAll();
    }

    public TodoList buscarPeloId(Long id){
        return todoListRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public TodoList salvar(TodoList todoList){
        return todoListRepository.save(todoList);
    }

    public TodoList atualizar(Long id, TodoList todoList){

        TodoList todoListSalvo = todoListRepository.findById(id).
                orElseThrow(() -> new EmptyResultDataAccessException(1));
        BeanUtils.copyProperties(todoList, todoListSalvo, "id");

        return this.todoListRepository.save(todoListSalvo);
    }

    public void remover(@PathVariable TodoList id){
         todoListRepository.delete(id);
    }
}

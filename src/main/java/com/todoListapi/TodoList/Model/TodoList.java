package com.todoListapi.TodoList.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_todolist")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "done")
    private boolean done;

}

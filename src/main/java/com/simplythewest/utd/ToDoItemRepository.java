package com.simplythewest.utd;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long>{

    //custom functions
    List<ToDoItem> findAll(Sort priority);
}

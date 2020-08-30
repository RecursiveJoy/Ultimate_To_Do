package com.simplythewest.utd;

import java.time.ZonedDateTime;
import org.springframework.data.repository.CrudRepository;

public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long>{

    //custom functions
    ToDoItem findByPriority(int priority);

}

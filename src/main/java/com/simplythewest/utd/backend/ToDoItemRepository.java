package com.simplythewest.utd;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long>{

    //custom functions
    List<ToDoItem> findAll(Sort priority);

    //transactional annotation fixes following error.
    //https://stackoverflow.com/questions/32269192/spring-no-entitymanager-with-actual-transaction-available-for-current-thread
    @Transactional
    void deleteAllByCompletedStatus(boolean completedStatus);

}

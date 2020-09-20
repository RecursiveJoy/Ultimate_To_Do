package com.simplythewest.utd.priorityList.models;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long>{

    //custom functions
    List<ToDoItem> findAll(Sort newSort);

    //transactional annotation fixes following error.
    //https://stackoverflow.com/questions/32269192/spring-no-entitymanager-with-actual-transaction-available-for-current-thread
    @Transactional
    void deleteAllByCompletedStatus(boolean completedStatus);

    @Modifying
    @Query("UPDATE ToDoItem n SET n.description = ?1 WHERE n.id = ?2")
    void setDescriptionById(String description, Long idToSet);

}

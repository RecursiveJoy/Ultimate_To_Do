package com.simplythewest.utd;

import java.time.ZonedDateTime;
import org.springframework.data.repository.CrudRepository;

public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long>{

    //accessors
    public Long getID();

    public String getDescription();

    public boolean getCompletedStatus();

    public int getPriority();

    public ZonedDateTime getTimestamp();



    //mutators
    public void setDescription(String description);

    public void setCompletedStatusToOpposite();

    public void setCompletedStatus(boolean newStatus);

    public void setPriority(int priority);



    //helpers
    public String toString();

    public int compareTo(ToDoItem td);

    //core functions

}

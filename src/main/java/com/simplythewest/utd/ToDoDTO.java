package com.simplythewest.utd;

import java.io.Serializable;

public class ToDoDTO extends ToDoItem implements Serializable{

    private String description = "";
    private int priority = 0;
    private ToDoItem anItem;


    public void getDescription(String description)
    {
        this.description = description;
    }

    public void setPriority(String priority)
    {
        switch (priority) {
            case "High": this.priority = 1;
                break;
            case "Medium": this.priority = 2;
                break;
            default: this.priority = 3;
        }
    }

    public ToDoItem DTOtoToDoItem()
    {
        anItem = new ToDoItem(this.description, this.priority);
        return anItem;
    }


}

package com.simplythewest.utd.priorityList.models;

import com.simplythewest.utd.priorityList.models.ToDoItem;
import com.simplythewest.utd.priorityList.models.ToDoItemRepository;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.data.domain.Sort;
import java.util.List;

public class ListManager {

    ToDoItemRepository myToDoRepo;
    List<ToDoItem> tableList;
    Grid<ToDoItem> myGridLayout;

    public ListManager(ToDoItemRepository otherToDoRepo)
    {
        myToDoRepo = otherToDoRepo;
        List<ToDoItem> tableList = myToDoRepo.findAll(Sort.by("priority").ascending());
        myGridLayout = new Grid<ToDoItem>();
    }

    public Grid<ToDoItem> getGrid()
    {
        tableList = myToDoRepo.findAll(Sort.by("priority").ascending());

        if (tableList != null)
        {
            myGridLayout.setItems(tableList);
        }
        else
        {
            myGridLayout = new Grid<ToDoItem>();
        }

        return myGridLayout;
    }
}

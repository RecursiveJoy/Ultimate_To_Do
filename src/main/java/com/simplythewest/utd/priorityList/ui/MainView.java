package com.simplythewest.utd.priorityList.ui;

import com.simplythewest.utd.priorityList.models.ListManager;
import com.simplythewest.utd.priorityList.models.ToDoItem;
import com.simplythewest.utd.priorityList.models.ToDoItemRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.data.domain.Sort;

import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    private ToDoItemRepository myToDoRepo;
    private Grid<ToDoItem> myList;
    private MainMenu mainMenu;

    public MainView(ToDoItemRepository otherToDoRepo)
    {
        myToDoRepo = otherToDoRepo;
        mainMenu = new MainMenu(otherToDoRepo);
        myList = new Grid<ToDoItem>();

        List theList = otherToDoRepo.findAll(Sort.by("priority").ascending());

        if (!theList.isEmpty())
        {
            myList.setItems(theList);
        }
        add(myList);
        add(mainMenu);
    }

}

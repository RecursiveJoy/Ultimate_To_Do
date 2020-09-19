package com.simplythewest.utd.priorityList.ui;

import com.simplythewest.utd.priorityList.models.ListManager;
import com.simplythewest.utd.priorityList.models.ToDoItem;
import com.simplythewest.utd.priorityList.models.ToDoItemRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private ToDoItemRepository myToDoRepo;
    private MainMenu mainMenu;
    private ListManager listManager;

    public MainView(ToDoItemRepository otherToDoRepo)
    {
        myToDoRepo = otherToDoRepo;
        listManager = new ListManager(myToDoRepo);
        mainMenu = new MainMenu(myToDoRepo);

        add(listManager.getGrid());

        add(mainMenu);
    }

}

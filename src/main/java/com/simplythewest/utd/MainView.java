package com.simplythewest.utd;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private final VerticalLayout listLayout;
    private ToDoItemRepository myToDoRepo;
    private MainMenu mainMenu;

    public MainView(ToDoItemRepository otherToDoRepo)
    {
        myToDoRepo = otherToDoRepo;

        listLayout = new VerticalLayout();
        mainMenu = new MainMenu(myToDoRepo);
        add(mainMenu);
    }




}

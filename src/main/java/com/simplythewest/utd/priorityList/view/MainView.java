package com.simplythewest.utd.priorityList.view;

import com.simplythewest.utd.priorityList.model.ToDoItem;
import com.simplythewest.utd.priorityList.model.ToDoItemRepository;
import com.simplythewest.utd.priorityList.viewModel.MainViewViewModel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    @Autowired
    private MainViewViewModel myMVVM;
    private Grid<ToDoItem> myList;
    private MainMenu mainMenu;

    public MainView()
    {
        mainMenu = new MainMenu(myMVVM);
        myList = new Grid<>();

        myList.setItems(myMVVM.findAll());

        add(myList);
        add(mainMenu);
    }

}

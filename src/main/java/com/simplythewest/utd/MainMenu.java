package com.simplythewest.utd;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class MainMenu extends HorizontalLayout{

    private final ToDoItemRepository myToDoRepo;

    MainMenu(ToDoItemRepository otherToDoRepo)
    {
        myToDoRepo = otherToDoRepo;
        add(addButton());
        add(deleteButton());
        add(clearButton());
        add(editButton());
    }

    private Button addButton()
    {
        Button addButton = new Button("Add");

        addButton.addClickListener(
            clickEvent ->
                addButton.getUI().ifPresent(ui ->
                    ui.navigate("utd/AddMenu"))
        );

        return addButton;
    }

    public Button deleteButton()
    {
        Button deleteButton = new Button("Delete");

        deleteButton.addClickListener(
            clickEvent ->
                deleteButton.getUI().ifPresent(ui->
                    ui.navigate("utd/DeleteMenu"))
        );

        return deleteButton;
    }

    private Button clearButton()
    {
        Button clearButton = new Button("Clear");

        clearButton.addClickListener(
            clickEvent ->
                myToDoRepo.deleteAll());

        return clearButton;
    }

    public Button editButton()
    {
        Button editButton = new Button("Edit Items");

        editButton.addClickListener(
            clickEvent ->
                editButton.getUI().ifPresent(ui->
                    ui.navigate("utd/EditMenu"))
        );

        return editButton;
    }
}

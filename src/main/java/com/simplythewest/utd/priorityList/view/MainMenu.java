package com.simplythewest.utd.priorityList.view;

import com.simplythewest.utd.priorityList.viewModel.MainViewViewModel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class MainMenu extends HorizontalLayout{

    private final MainViewViewModel myMVVM;

    MainMenu(MainViewViewModel myMVVM)
    {
        this.myMVVM = myMVVM;
        add(addButton());
        add(deleteButton());
        add(clearButton());
        add(editButton());
    }


    public Button addButton()
    {
        Button addButton = new Button("Add");

        addButton.addClickListener(
            clickEvent ->
            {
                addButton.getUI().ifPresent(ui ->
                    ui.navigate("AddMenu"));
            }
        );

        return addButton;
    }

    public Button deleteButton()
    {
        Button deleteButton = new Button("Delete");

        deleteButton.addClickListener(
            clickEvent ->
                deleteButton.getUI().ifPresent(ui->
                    ui.navigate("DeleteMenu"))
        );

        return deleteButton;
    }

    public Button clearButton()
    {
        Button clearButton = new Button("Clear");

        clearButton.addClickListener(
            clickEvent ->
                myMVVM.clear()
            );

        return clearButton;
    }

    public Button editButton()
    {
        Button editButton = new Button("Edit Items");

        editButton.addClickListener(
            clickEvent ->
                editButton.getUI().ifPresent(ui->
                    ui.navigate("EditMenu"))
        );

        return editButton;
    }
}

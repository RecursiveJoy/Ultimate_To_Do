package com.simplythewest.utd.priorityList.ui;

import com.simplythewest.utd.priorityList.models.ListManager;
import com.simplythewest.utd.priorityList.models.ToDoDTO;
import com.simplythewest.utd.priorityList.models.ToDoItemRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;

@Route("AddMenu")
public class AddMenu extends VerticalLayout {

    private ToDoDTO toDoItem;
    private ToDoItemRepository myToDoRepo;
    private ListManager listManager;

    public AddMenu(ToDoItemRepository otherToDoRepo)
    {
        //initialize member variables
        toDoItem = new ToDoDTO();
        myToDoRepo = otherToDoRepo;
        listManager = new ListManager(myToDoRepo);


        //display the list
        add(listManager.getGrid());

        //add the fields and buttons
        add(addFields());
        add(MenuButtons());

    }

    private VerticalLayout addFields()
    {
        //display fields top to bottom
        VerticalLayout fieldsLayout = new VerticalLayout();
        fieldsLayout.add(descriptionField());
        fieldsLayout.add(priorityLabel());
        fieldsLayout.add(prioritySelection());

        return fieldsLayout;
    }

    private HorizontalLayout MenuButtons()
    {
        //display buttons side by side
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.add(submitButton());
        buttonsLayout.add(backButton());

        return buttonsLayout;
    }

    private TextField descriptionField()
    {
        TextField tf = new TextField("Enter description");
        tf.addValueChangeListener(event ->
        {
            toDoItem.setDescription((event.getValue()));
        });

        return tf;
    }

    private Div priorityLabel()
    {
        Div value = new Div();
        value.setText("Select a priority for the list item");
        return value;
    }

    private RadioButtonGroup<String> prioritySelection()
    {
        RadioButtonGroup<String> priorityValues = new RadioButtonGroup<String>();
        priorityValues.setItems("High", "Medium", "Low");


        priorityValues.addValueChangeListener(event ->
            toDoItem.setPriority(priorityValues.getValue()));

        return priorityValues;
    }


    private Button submitButton()
    {
        Button submitButton = new Button("Submit");
        submitButton.addClickListener(event ->
        {
            myToDoRepo.save(toDoItem.DTOtoToDoItem());
        });

        return submitButton;
    }

    private Button backButton()
    {
        Button backButton = new Button ("Finished");
        backButton.addClickListener(event->
            backButton.getUI().ifPresent(ui ->
                ui.navigate(""))
        );
        return backButton;
    }

}

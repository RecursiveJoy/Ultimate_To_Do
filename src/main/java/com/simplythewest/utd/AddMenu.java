package com.simplythewest.utd;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;

@Route("AddMenu")
public class AddMenu extends VerticalLayout {

    private ToDoDTO toDoItem;

    public AddMenu()
    {
        toDoItem = new ToDoDTO();
        add(descriptionField());
        add(priorityLabel());
        add(prioritySelection());
        add(submitButton());
        add(backButton());
    }

    private TextField descriptionField()
    {
        TextField tf = new TextField("Enter description");
        tf.addValueChangeListener(event ->
            toDoItem.setDescription((event.getValue())));
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
            toDoItem.DTOtoToDoItem());
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

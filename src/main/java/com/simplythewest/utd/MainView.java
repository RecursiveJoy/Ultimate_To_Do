package com.simplythewest.utd;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Route
public class MainView extends VerticalLayout {

    private final ToDoItemRepository toDoRepo1;
    final Grid<ToDoItem> priorityLayout;
    ToDoDTO myDTO;

    public MainView(ToDoItemRepository toDoRepo)
    {
        this.toDoRepo1 = toDoRepo;
        this.priorityLayout = new Grid<>(ToDoItem.class);
        add(priorityLayout);
        listToDoItems();
        add(AddButton());
    }

    private void listToDoItems()
    {
        List<ToDoItem> ordered =
            toDoRepo1.findAll(Sort.by(Sort.Direction.ASC, "priority"));
        priorityLayout.setItems(ordered);
    }

    private void getDescriptionFromInput()
    {
        TextField tf = new TextField("Enter description");
        tf.addValueChangeListener(event ->
            myDTO.getDescription((event.getValue())));
        add(tf);
    }

    private void getPriorityFromRadio() {
        RadioButtonGroup<String> priorityValues =
            new RadioButtonGroup<String>();
        priorityValues.setItems("High", "Medium", "Low");
        add(priorityValues);

        Div value = new Div();
        value.setText("Select a priority for the list item");
        priorityValues.addValueChangeListener(event ->
            myDTO.setPriority(priorityValues.getValue()));
    }


    private Button AddButton()
    {
        Button addButton = new Button("Add an item to the list");

        addButton.addClickListener(
            clickEvent -> addEvent());

        return addButton;
    }

    private void addEvent()
    {
        myDTO = new ToDoDTO();
        getPriorityFromRadio();
        getDescriptionFromInput();
        toDoRepo1.save(myDTO.DTOtoToDoItem());
        listToDoItems();
    }
}

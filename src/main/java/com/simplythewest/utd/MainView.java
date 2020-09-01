package com.simplythewest.utd;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.NumberField;
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
        toDoRepo1 = toDoRepo;
        myDTO = new ToDoDTO();
        toDoRepo.deleteAll();

        //create grid layout
        priorityLayout = new Grid<>(ToDoItem.class);
        add(priorityLayout);
        listToDoItems();
        getPriorityFromRadio();
        getDescriptionFromInput();
        add(addButton());
        add(clearButton());
        add(deleteField());
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
            myDTO.setDescription((event.getValue())));
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


    private Button addButton()
    {
        Button addButton = new Button("Add item to the list");

        addButton.addClickListener(
            clickEvent -> addEvent());

        return addButton;
    }

    private Button clearButton()
    {
        Button clearButton = new Button("Clear list");

        clearButton.addClickListener(
            clickEvent -> toDoRepo1.deleteAll());

        return clearButton;
    }

    private void addEvent()
    {
        toDoRepo1.save(myDTO.DTOtoToDoItem());
        listToDoItems();
    }

    private NumberField deleteField()
    {
        NumberField deleteField =
            new NumberField("Item ID to delete");

        deleteField.addValueChangeListener(event ->
            deleteEvent(deleteField.getValue()));

        return deleteField;
    }

    private void deleteEvent(double idToDelete)
    {
        toDoRepo1.deleteById(Double.valueOf(idToDelete).longValue());
        listToDoItems();
    }
}

package com.simplythewest.utd;

import com.vaadin.flow.component.button.*;
import com.vaadin.flow.component.grid.*;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.component.radiobutton.*;

import com.vaadin.flow.router.Route;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Route
public class MainView extends VerticalLayout {

    private final ToDoItemRepository toDoRepo1;
    private ToDoDTO myDTO;
    private ArrayList<ToDoItem> priorityArrayList;
    private Grid<ToDoItem> priorityGridList;

    public MainView(ToDoItemRepository toDoRepo)
    {
        //initialize private attributes
        toDoRepo1 = toDoRepo;
        myDTO = new ToDoDTO();
        priorityArrayList = new ArrayList<ToDoItem>();
        priorityGridList = new Grid<>(ToDoItem.class);

        //build the GUI
        buildGUI();
    }

    private void buildGUI()
    {
        //create the todo list item table and display it.
        add(priorityGridList);
        updatePriorityList();

        Button addButton = addButton();
        add(addButton);

        Button clearButton = clearButton();
        add(clearButton);

        NumberField deleteField = deleteField();
        add(deleteField);

    }


    //GRID functions
    private void updatePriorityList()
    {
        priorityGridList.getDataProvider().refreshAll();
        List<ToDoItem> ordered =
            toDoRepo1.findAll(Sort.by(Sort.Direction.ASC, "priority"));
        priorityGridList.setItems(ordered);
    }


    //ADD functions
    private Button addButton()
    {
        Button addButton = new Button("Add item to list");

        addButton.addClickListener(
            clickEvent -> addModeEvent());

        return addButton;
    }

    private void addModeEvent()
    {
        add(descriptionField());

        //create Priority Radio buttons
        RadioButtonGroup<String> priorityValues =
            new RadioButtonGroup<String>();
        priorityValues.setItems("High", "Medium", "Low");
        Div value = new Div();
        value.setText("Select a priority for the list item");
        add(value);
        priorityValues.addValueChangeListener(event ->
            myDTO.setPriority(priorityValues.getValue()));
        priorityValues.setVisible(true);
        add(priorityValues);
        add(submitButton());
    }

    private TextField descriptionField()
    {
        //create the description field for new tasks.
        //description field is visible initially
        TextField descriptionField = new TextField(
            "Add a task then press ENTER."
        );
        descriptionField.addValueChangeListener(event ->
            myDTO.setDescription(event.getValue()));
        descriptionField.setVisible(true);
        return descriptionField;
    }

    private void submit()
    {
        ToDoItem new_item = myDTO.DTOtoToDoItem();
        toDoRepo1.save(new_item);
        priorityArrayList.add(new_item);
        updatePriorityList();
    }

    private Button submitButton()
    {
        Button submitButton = new Button("Submit");

        submitButton.addClickListener(
            clickEvent -> submit());

        return submitButton;
    }

/**
    private void exitAdd()
    {

    }

    private Button exitAddButton()
    {
        Button exitAddButton = new Button("Exit Add Mode");

        exitAddButton.addClickListener(
            clickEvent -> exitAdd());

        return exitAddButton;

    }
**/

    //CLEAR methods
    private Button clearButton()
    {
        Button clearButton = new Button("Clear list");

        clearButton.addClickListener(
            clickEvent -> clearList());

        return clearButton;
    }

    private void clearList()
    {
        toDoRepo1.deleteAll();
        updatePriorityList();
    }

    private void clearCompleted()
    {
        toDoRepo1.deleteAllByCompletedStatus(true);
    }


    //DELETE METHODS
    private NumberField deleteField()
    {
        NumberField deleteField =
            new NumberField("Item ID to delete");

        deleteField.setVisible(true);

        deleteField.addValueChangeListener(event ->
            deleteEvent(deleteField.getValue()));

        return deleteField;
    }

    private void deleteEvent(double idToDelete)
    {
        if(!priorityArrayList.isEmpty()) {
            try {
                toDoRepo1.deleteById(Double.valueOf(idToDelete).longValue());
            } catch (EmptyResultDataAccessException a) {
                Div message = new Div();
                message.setText("The index you entered is not in the list.");
                add(message);
                updatePriorityList();
            } catch (NullPointerException b) {
                Div message = new Div();
                message.setText("Please enter an index and try again.");
                add(message);
                updatePriorityList();
            }
        }
        else {
            Div message = new Div();
            message.setText("The list is empty.");
            add(message);
        }
    }

    //UPDATE METHODS

    //COMPLETE ITEM METHODS

}

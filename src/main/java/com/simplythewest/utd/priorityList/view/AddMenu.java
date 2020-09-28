package com.simplythewest.utd.priorityList.view;

import com.simplythewest.utd.priorityList.model.ToDoDTO;
import com.simplythewest.utd.priorityList.model.ToDoItem;
import com.simplythewest.utd.priorityList.model.ToDoItemRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.data.domain.Sort;

import java.util.List;

@Route("AddMenu")
public class AddMenu extends VerticalLayout {

    private ToDoDTO toDoItem;
    private ToDoItemRepository myToDoRepo;
    private Grid<ToDoItem> myList;

    public AddMenu(ToDoItemRepository otherToDoRepo)
    {
        myToDoRepo = otherToDoRepo;
        toDoItem = new ToDoDTO();
        myList = new Grid<>();

        List<ToDoItem> theList = otherToDoRepo.findAll(Sort.by("priority").ascending());

        if (!theList.isEmpty())
        {
            myList.setItems(theList);
        }

        add(myList);
        add(addFields());
        add(menuButtons());
    }

    private VerticalLayout addFields()
    {
        VerticalLayout theAddFields = new VerticalLayout();

        theAddFields.add(descriptionField());
        theAddFields.add(priorityLabel());
        theAddFields.add(prioritySelection());

        return theAddFields;
    }

    private HorizontalLayout menuButtons()
    {
        HorizontalLayout theMenuButtons = new HorizontalLayout();
        theMenuButtons.add(submitButton());
        theMenuButtons.add(backButton());
        return theMenuButtons;
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
            List<ToDoItem> theList = myToDoRepo.findAll(Sort.by("priority").ascending());

            if (!theList.isEmpty())
            {
                myList.setItems(theList);
            }
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

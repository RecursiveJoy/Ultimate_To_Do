package com.simplythewest.utd;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("utd/EditMenu")
public class EditMenu {
    private ToDoDTO myToDoDTO;
    private ToDoItemRepository myToDoRepo;

    public EditMenu(ToDoItemRepository otherToDoRepo)
    {
        myToDoRepo = otherToDoRepo;
        myToDoDTO = new ToDoDTO();
    }

    private NumberField editField()
    {
        NumberField editField =
            new NumberField("Item ID to edit");

        editField.addValueChangeListener(event ->
            editEvent(editField.getValue()));

        return editField;
    }

    private TextField descriptionField()
    {
        TextField tf = new TextField("Enter updated description");
        tf.addValueChangeListener(event ->
            myToDoDTO.setDescription((event.getValue())));
        return tf;
    }

    private void editEvent(double idToUpdate)
    {
        myToDoRepo.setDescriptionById(myToDoDTO.getDescription(), Double.valueOf(idToUpdate).longValue());
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

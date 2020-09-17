package com.simplythewest.utd;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

@Route("DeleteMenu")
public class DeleteMenu extends VerticalLayout {

    private final ToDoItemRepository myToDoRepo;

    public DeleteMenu(ToDoItemRepository otherToDoRepo) {
        myToDoRepo = otherToDoRepo;

        add(deleteField());
        add(backButton());
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
        myToDoRepo.deleteById(Double.valueOf(idToDelete).longValue());
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

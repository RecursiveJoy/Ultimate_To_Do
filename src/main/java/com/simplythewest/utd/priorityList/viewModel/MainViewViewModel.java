package com.simplythewest.utd.priorityList.viewModel;

import com.simplythewest.utd.priorityList.model.ToDoItem;
import com.simplythewest.utd.priorityList.model.ToDoItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MainViewViewModel {

    private final ToDoItemRepository myToDoRepo;

    public MainViewViewModel(ToDoItemRepository otherToDoRepo)
    {
        myToDoRepo = otherToDoRepo;
    }

    @Transactional
    public List<ToDoItem> findAll()
    {
        return myToDoRepo.findAll(Sort.by( Sort.Direction.ASC, "priority"));
    }

    public void clear()
    {
        myToDoRepo.deleteAllByCompletedStatus(false);
        myToDoRepo.deleteAllByCompletedStatus(true);
    }

}

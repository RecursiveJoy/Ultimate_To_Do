package com.simplythewest.utd;

import com.simplythewest.utd.priorityList.models.ToDoItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import com.simplythewest.utd.priorityList.models.ToDoItem;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest

class ToDoItemRepositoryTest {

    private ToDoItemRepository todorepo1;

    @Test
    void createThenSave(ToDoItemRepository newRepo)
    {
        todorepo1 = newRepo;
        todorepo1.save(new ToDoItem("first", 0));
        todorepo1.save(new ToDoItem("second", 1));
        todorepo1.save(new ToDoItem("third", 2));
        todorepo1.save(new ToDoItem("fourth", 3));
        List<ToDoItem> ordered =
            todorepo1.findAll(Sort.by(Sort.Direction.DESC, "priority"));
        assertThat(ordered.get(2)).isNotNull();
    }

}

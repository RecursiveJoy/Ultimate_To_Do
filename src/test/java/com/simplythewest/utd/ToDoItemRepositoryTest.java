package com.simplythewest.utd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import com.simplythewest.utd.ToDoItem;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest

class ToDoItemRepositoryTest {

    @Autowired
    ToDoItemRepository todorepo1;

    @Test
    void createThenSave()
    {
        todorepo1.save(new ToDoItem("first", 0));
        todorepo1.save(new ToDoItem("second", 1));
        todorepo1.save(new ToDoItem("third", 2));
        todorepo1.save(new ToDoItem("fourth", 3));
        List<ToDoItem> ordered =
            todorepo1.findAll(Sort.by(Sort.Direction.DESC, "priority"));
        assertThat(ordered.get(2)).isNotNull();
    }

}

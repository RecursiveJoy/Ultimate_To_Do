package com.simplythewest.utd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.simplythewest.utd.ToDoItem;
import com.simplythewest.utd.ToDoItemRepository;
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
        ToDoItem third_item = todorepo1.findByPriority(2);
        assertThat(third_item).isNotNull();
    }

}

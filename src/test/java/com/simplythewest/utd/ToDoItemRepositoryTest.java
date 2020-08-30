package com.simplythewest.utd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.simplythewest.utd.ToDoItem;
import com.simplythewest.utd.ToDoItemRepository;

@DataJpaTest
@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=validate"
})

class ToDoItemRepositoryTest {

    ToDoItemRepository todorepo1;

    @Test
    void createThenSave()
    {
        todorepo1.save(new ToDoItem("first", 0));
        todorepo1.save(new ToDoItem("second", 1));
        todorepo1.save(new ToDoItem("third", 2));
        todorepo1.save(new ToDoItem("fourth", 4));
        ToDoItem third_item = ToDoItemRepository.findByPriority("2");
        assertThat(third_item).isNotNull();
    }

}

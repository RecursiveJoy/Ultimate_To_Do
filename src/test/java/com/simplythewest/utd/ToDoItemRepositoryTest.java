package com.simplythewest.utd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=validate"
})

class ToDoItemRepositoryTest {

    @Test
    void createThenSave()
    {
        ToDoItemRepository.save(new ToDoItem("A description", 3));
    }

}

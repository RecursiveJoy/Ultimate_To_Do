package com.simplythewest.utd.model;

import com.simplythewest.utd.priorityList.model.ToDoItem;
import com.simplythewest.utd.priorityList.model.ToDoItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase( replace = AutoConfigureTestDatabase.Replace.NONE )
@DataJpaTest
class ToDoItemRepositoryTest {

    @Autowired
    private ToDoItemRepository todoRep;

    @Test
    void createThenSave() {
        todoRep.save( new ToDoItem( "first", 0 ) );
        todoRep.save( new ToDoItem( "second", 1 ) );
        todoRep.save( new ToDoItem( "third", 2 ) );
        todoRep.save( new ToDoItem( "fourth", 3 ) );
        List<ToDoItem> ordered =
            todoRep.findAll( Sort.by( Sort.Direction.DESC, "priority" ) );
        assertThat( ordered.get( 2 ) ).isNotNull();
    }

}

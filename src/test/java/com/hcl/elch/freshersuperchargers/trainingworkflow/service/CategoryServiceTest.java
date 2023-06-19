package com.hcl.elch.freshersuperchargers.trainingworkflow.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import com.hcl.elch.freshersuperchargers.trainingworkflow.entity.Category;
import com.hcl.elch.freshersuperchargers.trainingworkflow.entity.Task;
import com.hcl.elch.freshersuperchargers.trainingworkflow.repo.CategoryRepo;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryServiceTest {

	@InjectMocks
	private CategoryService service;

	@Mock
	private CategoryRepo repo;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void test() throws Exception {
		long userId = 111L;
		long id=1L;
		Category category = Category.builder()
				.userId(111L)
				.category("group1")
				.build();
		Task task =new Task();
		task.setId(1);
		when(repo.findById(111L)).thenReturn(Optional.of(category));
		Category found = service.get(userId,id);

		assertEquals(userId, found.getUserId());

	}

}

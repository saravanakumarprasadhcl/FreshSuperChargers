package com.hcl.elch.freshersuperchargers.trainingworkflow.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.hcl.elch.freshersuperchargers.trainingworkflow.entity.Category;
import com.hcl.elch.freshersuperchargers.trainingworkflow.entity.Task;
import com.hcl.elch.freshersuperchargers.trainingworkflow.exceptions.DroolsEngineException;
import com.hcl.elch.freshersuperchargers.trainingworkflow.repo.TaskRepo;


class TaskServiceTest {

	@Mock
	private TaskRepo taskRepo;

	@Mock
	private KieContainer kieContainer;

	@InjectMocks
	private TaskServiceImpl taskService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetStatusPositive() throws DroolsEngineException {

		Task task = Task.builder().id(2).taskId(5).userId(111).Status("Completed").task("JAVA")
				.duedate(LocalDate.of(2023, 6, 4)).approver("Sandipan").build();

		Category category = new Category(111L, "group1");

		// Mocking
		KieSession kieSession = mock(KieSession.class);
		when(kieContainer.newKieSession()).thenReturn(kieSession);
		when(taskRepo.findById(111L)).thenReturn(Optional.of(task));

		//expected output
		String expectedStatus = "Completed";

		// calling test method
		Task actualTask = taskService.getStatus(task, category);

		String actualStatus = actualTask.getStatus();

		assertEquals(expectedStatus, actualStatus);
	}
	
	@Test
	public void testGetStatusNegetive() throws DroolsEngineException {

		Task task = Task.builder().id(2).taskId(4).userId(111).Status("Completed").task("JAVA")
				.duedate(LocalDate.of(2023, 6, 4)).approver("Sandipan").build();

		Category category = new Category(111L, "group2");

		// Mocking
		KieSession kieSession = mock(KieSession.class);
		when(kieContainer.newKieSession()).thenReturn(kieSession);
		when(taskRepo.findById(111L)).thenReturn(Optional.of(task));

		//expected output
		String expectedStatus = "Completed";

		// calling test method
		Task actualTask = taskService.getStatus(task, category);
		Task t1 = new Task();
		String actualStatus = actualTask.getStatus();
		verify(kieContainer).newKieSession();
		verify(kieSession).setGlobal("t1", t1);
		verify(kieSession).insert(task);
		verify(kieSession).insert(category);
		verify(kieSession).fireAllRules();
		verify(kieSession).dispose();
		assertNotEquals(expectedStatus, actualStatus);
	}

	@Test
	void testSave_TaskNotCompleted() {

		Task task = Task.builder().taskId(1).userId(111).Status("InProgress").task("Java")
				.duedate(LocalDate.of(2023, 6, 4)).build();

		taskService.save(task);

		verify(taskRepo).save(task);
	}

	@Test
	void testSave_TaskCompleted() {

		Task task = Task.builder().taskId(2).userId(112).Status("Completed").task("DB")
				.duedate(LocalDate.of(2023, 6, 4)).build();

		taskService.save(task);

		verifyNoInteractions(taskRepo);
	}

	@Test
	void testSetComplete() {
		Task task = Task.builder().id(2).taskId(1).userId(111).Status("Completed").task("Java")
				.duedate(LocalDate.of(2023, 6, 4)).approver("Sandipan").build();

		// Mock behavior of TaskRepo
		List<Task> tasks = new ArrayList<>();
		Task existingTask = Task.builder().id(1).taskId(1).userId(111).Status("InProgress").task("Java")
				.duedate(LocalDate.of(2023, 6, 4)).approver("Sandipan").build();

		tasks.add(existingTask);

		when(taskRepo.getByuserId(111L)).thenReturn(tasks);
		when(taskRepo.findById(1L)).thenReturn(Optional.of(existingTask));

		long id = 1;
		long userId = 111;
		String approver = "Sandipan";
		taskService.setComplete(task);

		verify(taskRepo).getByuserId(111L);
		verify(taskRepo).findById(1L);
		verify(taskRepo).save(existingTask);

		assertEquals(approver, existingTask.getApprover());
	}

}

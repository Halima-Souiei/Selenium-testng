package com.todods.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.todos.pages.TodosPage;
import com.todos.utils.Setup;

public class AddTodoTest extends Setup {

	public AddTodoTest() throws IOException {
		super();

	}

	TodosPage todoPage;

	@Test
	public void iCanAddTodo() throws IOException, InterruptedException {
		todoPage = new TodosPage();
		boolean checkFieldTodo = todoPage.isElementDisplayed(TodosPage.inputField);
		Assert.assertTrue(checkFieldTodo);
		todoPage.fillTodo(prop.getProperty("todo1"));

		Thread.sleep(3000);
		String textTodo = todoPage.checkElementContain(TodosPage.todoText);
		Assert.assertEquals(textTodo, prop.getProperty("todo1"));

		Thread.sleep(3000);
		boolean checkbox = todoPage.isElementSelected(TodosPage.checkbox);
		Assert.assertFalse(checkbox);

	}

}

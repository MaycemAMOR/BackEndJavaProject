package com.joury.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter = 0;
	static {
		todos.add(new Todo(++idCounter, "Amor", "Learn to dance", new Date(), false));
		todos.add(new Todo(++idCounter, "Amor", "Became an Expert at Angular", new Date(), false));
		todos.add(new Todo(++idCounter, "Amor", "learn about Microservices", new Date(), false));
		todos.add(new Todo(++idCounter, "Amor", "Visit USA", new Date(), false));
		todos.add(new Todo(++idCounter, "Amor", "Visit Marroco", new Date(), false));

	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null)
			return null;
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo save(Todo todo) {
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

}

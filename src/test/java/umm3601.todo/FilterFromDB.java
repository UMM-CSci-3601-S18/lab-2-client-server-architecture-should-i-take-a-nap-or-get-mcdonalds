package umm3601.todo;

import org.junit.Test;
import umm3601.user.Database;
import umm3601.user.Todo;
import umm3601.user.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterFromDB {
  @Test
  public void filterAllTodosByOwner() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());


    Todo[] barryTodos = db.filterTodosByOwner(allTodos, "Barry");
    assertEquals("Incorrect number of Barry todos", 51, barryTodos.length);

    Todo[] workmanTodos = db.filterTodosByOwner(allTodos,"Workman" );
    assertEquals("Incorrect number of todos with owner Workman", 49, workmanTodos.length);
  }

  @Test
  public void filterAllTodosByID() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());


    Todo[] id1Todos = db.filterTodosByID(allTodos, "5889598502be34bcf1e1a333");
    assertEquals("Incorrect number of todos", 1, id1Todos.length);

    Todo[] id2Todos = db.filterTodosByID(allTodos,"5889598506de07f32859e0bf" );
    assertEquals("Incorrect number of todos", 1, id2Todos.length);
  }

  @Test
  public void filterAllTodosByStatus() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());


    Todo[] status1Todos = db.filterTodosByStatus(allTodos, true);
    assertEquals("Incorrect number of todos", 143, status1Todos.length);

    Todo[] status2Todos = db.filterTodosByStatus(allTodos,false );
    assertEquals("Incorrect number of todos", 157, status2Todos.length);
  }

  @Test
  public void filterAllTodosByBody() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());


    Todo[] body1Todos = db.filterTodosByBody(allTodos, "eu");
    assertEquals("Incorrect number of todos", 140, body1Todos.length);

    Todo[] body2Todos = db.filterTodosByBody(allTodos,"Ullamco irure laborum" );
    assertEquals("Incorrect number of todos", 1, body2Todos.length);
  }

  @Test
  public void filterAllTodosByCategory() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());


    Todo[] category1Todos = db.filterTodosByCategory(allTodos, "homework");
    assertEquals("Incorrect number of todos", 79, category1Todos.length);

    Todo[] category2Todos = db.filterTodosByCategory(allTodos,"video games" );
    assertEquals("Incorrect number of todos", 71, category2Todos.length);
  }

  @Test
  public void orderAllTodos() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo tester1 = new Todo("588959850158d603e15705d5",
      "Fry",
      true,
      "Fugiat dolor proident fugiat eu occaecat duis magna occaecat fugiat et. Id aliquip laborum ullamco consectetur voluptate officia id ad adipisicing nulla nulla.",
      "video games");
    Todo tester2 = new Todo("5889598502be34bcf1e1a333",
      "Barry",
      false,
      "Consectetur aute enim ullamco fugiat est. Eu dolore fugiat mollit sit ut laborum labore est.",
      "homework");
    Todo tester4 = new Todo("58895985ffd38481b57cac97",
      "Roberta",
      false,
      "Ad sint incididunt officia veniam incididunt. Voluptate exercitation eu aliqua laboris occaecat deserunt cupidatat velit nisi sunt mollit sint amet.",
      "software design");
    Todo tester5 = new Todo("588959856b2259d62afcebf4",
      "Roberta",
      false,
      "Adipisicing ea eu adipisicing esse ullamco. Qui sunt velit qui ut amet veniam eiusmod occaecat reprehenderit exercitation est occaecat.",
      "groceries");

    Todo[] order1Todos = db.orderTodosByCategory(allTodos, "_id");
    assertEquals("Incorrect todos", tester1._id, order1Todos[0]._id);

    Todo[] order2Todos = db.orderTodosByCategory(allTodos,"owner" );
    assertEquals("Incorrect todos", tester2._id, order2Todos[0]._id);

    //The top result is the same as the previous assertion
    Todo[] order3Todos = db.orderTodosByCategory(allTodos,"status" );
    assertEquals("Incorrect todos", tester2._id, order3Todos[0]._id);

    Todo[] order4Todos = db.orderTodosByCategory(allTodos,"body" );
    assertEquals("Incorrect todos", tester4._id, order4Todos[0]._id);

    Todo[] order5Todos = db.orderTodosByCategory(allTodos,"category" );
    assertEquals("Incorrect todos", tester5._id, order5Todos[0]._id);
  }

  @Test
  public void LimitAllTodosByCategory() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());


    Todo[] limit1Todos = db.filterTodosByLimit(allTodos, 7);
    assertEquals("Incorrect number of todos", 7, limit1Todos.length);

    Todo[] limit2Todos = db.filterTodosByLimit(allTodos, 12);
    assertEquals("Incorrect number of todos", 12, limit2Todos.length);
  }

}

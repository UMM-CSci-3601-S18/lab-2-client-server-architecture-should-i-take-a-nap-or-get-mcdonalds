package umm3601.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import java.io.IOException;

import static umm3601.Util.*;

public class todoController {
  private final Gson gson;
  private Database database;

  public todoController(Database database) {
    gson = new Gson();
    this.database = database;
  }

  public JsonObject getTodos(Request req, Response res) {
    res.type("application/json");
    Todo[] todos = database.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("todos", gson.toJsonTree(todos));
  }
}

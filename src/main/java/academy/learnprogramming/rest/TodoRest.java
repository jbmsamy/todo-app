/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import academy.learnprogramming.service.TodoService;
import academy.learnprogramming.entity.Todo;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;
import javax.ws.rs.QueryParam;
/**
 *
 * @author Jayabaskar Munusamy
 */
@Path("todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoRest {
    
    private static Logger log = Logger.getLogger(TodoRest.class.toString());
    
    @Inject
    private TodoService todoService;
    
    @POST
    @Path("new")
    public Response create(Todo todo) {
        return Response.ok( todoService.create(todo)).build();
    }
    
    @Path("/{id}")
    @GET
    public Response getTodo(@PathParam("id") Long id) {
        return Response.ok(todoService.findById(id)).build();
    }
    
    @Path("/update")
    @PUT
    public Response update(Todo todo) {
        todoService.update(todo);
        return Response.ok().build();
    }
    
    @Path("/delete")
    @DELETE
    @POST
    public Response delete(Todo todo) {
        todoService.delete(todo);
        return Response.ok().build();
    }
    @Path("/list")
    @GET
    public Response todoList() {
        List<Todo> todoList = todoService.list();
        return Response.ok(todoList).build();
    }
    
    public Response markAsComplete(@QueryParam("id") Long id) {
        Todo todo = this.todoService.findById(id);
        todo.setCompletionDate(LocalDate.now());
        todo.setCompleted(true);
        todo = this.todoService.update(todo);
        return Response.ok(todo).build();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import academy.learnprogramming.entity.Todo;
import java.util.List;
import java.util.logging.Logger;
/**
 *
 * @author Jayabaskar Munusamy
 */
@Transactional
public class TodoService {
    
    private static final Logger log = Logger.getLogger(TodoService.class.toString());
    
    @PersistenceContext
    private EntityManager entityManager;
       
    public Todo create(Todo todo) {
        entityManager.persist(todo);
        return todo;
    }
    
    public Todo update(Todo todo)    {
        Todo updatedtodo = null;
        try {
            updatedtodo = this.entityManager.merge(todo);             
        }catch(Throwable t) {
            log.info(t.getMessage());
        }
        return updatedtodo;
    }

    public Todo findById(Long id) {
        return entityManager.find(Todo.class, id);
    }
    
    public List<Todo> list() {
        List<Todo> todoList = entityManager
                                .createQuery("select t from Todo t",Todo.class)
                                .getResultList();
        return todoList;
    }
    
    public void delete(Todo todo) {
         entityManager.remove(todo);
    }
}
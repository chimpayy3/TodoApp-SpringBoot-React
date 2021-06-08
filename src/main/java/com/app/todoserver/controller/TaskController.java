package com.app.todoserver.controller;

import com.app.todoserver.models.Task;
import com.app.todoserver.models.Lists;
import com.app.todoserver.repository.ListRepository;
import com.app.todoserver.repository.TaskRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
@CrossOrigin()
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ListRepository listRepository;

    @RequestMapping(value = "listed", method = RequestMethod.GET)
    public List<Task> getTasks(){
        return this.taskRepository.findAll();
    }

    @RequestMapping(value = "listedTask", method = RequestMethod.GET)
    public List<Lists> getLists(){
        return this.listRepository.findAll();
    }

    @PostMapping("/task")
    public Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PutMapping("/task")
    public Task updateTask(@RequestBody Task taskDetails){
        Task task = taskRepository.findById(taskDetails.getId()).orElseThrow();
        task.setName(taskDetails.getName());
        task.setDescription(taskDetails.getDescription());
        task.setList(taskDetails.getList());
        Task updateTask = taskRepository.save(task);
        return updateTask;
    }

    @DeleteMapping("/task")
    public Map<String,Boolean> deleteTask(@RequestBody Task taskDelted){
        Task task = taskRepository.findById(taskDelted.getId()).orElseThrow();
        taskRepository.delete(task);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

    @PutMapping("/listToTask")
    public Task taskAndList(@RequestBody ObjectNode json){
        Task task = taskRepository.findById(json.get("id").asInt()).orElseThrow();
        Lists lists = listRepository.findById(json.get("list_id").asInt()).orElseThrow();
        task.setList(lists);
        Task updateTask = taskRepository.save(task);
        return updateTask;
    }

    @PostMapping("/tasklists")
    public Lists createLists(@RequestBody Lists lists){
        return listRepository.save(lists);
    }

    @DeleteMapping("/lists")
    public Map<String,Boolean> deleteTask(@RequestBody Lists listsDelted){
        Lists lists = listRepository.findById(listsDelted.getId()).orElseThrow();
        listRepository.delete(lists);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

}

package com.customersupport.customersupport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerSupportController {

    @Autowired
    CustomerSupportService customerSupportService;

    @GetMapping("/tasks")
    public List<SupportTask> getAllSupportTasks() {

        return customerSupportService.getAllSupportTasks();
    }

    @GetMapping("/tasks/{customerId}")
    public ResponseEntity<List<SupportTask>> getAllSupportTasksForCustomer(@PathVariable int customerId) {

        List<SupportTask> customerTickets = customerSupportService.getAllSupportTasksCustomer(customerId);
        if (customerTickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<SupportTask>>(customerTickets, HttpStatus.ACCEPTED);
    }

    @PostMapping("/task")
    public SupportTask postTaskCustomer(@RequestBody SupportTask supportTask) {
        return customerSupportService.addSupportTask(supportTask);
    }

    @PutMapping("/task/{supportTaskId}")
    public SupportTask updateTaskCustomer(@PathVariable int supportTaskId, @RequestBody SupportTask supportTask) {
        SupportTask updatedSupportTask = customerSupportService.updateTaskForCustomer(supportTaskId, supportTask);
        return updatedSupportTask;
    }

    @DeleteMapping("/tasks/{customerId}")
    public ResponseEntity<List<SupportTask>> deleteTaskCustomer(@PathVariable int customerId) {
        List<SupportTask> deletedTasks = customerSupportService.deleteAllTasksCustomer(customerId);

        if (deletedTasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<SupportTask>>(deletedTasks, HttpStatus.OK);

    }

}

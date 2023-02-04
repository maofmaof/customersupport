package com.customersupport.customersupport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSupportService {

    @Autowired
    CustomerSupportRepository customerSupportRepository;

    public List<SupportTask> getAllSupportTasks() {
        return customerSupportRepository.findAll();
    }

    public SupportTask addSupportTask(SupportTask supportTask) {
        customerSupportRepository.save(supportTask);
        return supportTask;
    }

    public List<SupportTask> getAllSupportTasksCustomer(int customerId) {
        return customerSupportRepository.findByCustomerId(customerId);
    }

    public SupportTask updateTaskForCustomer(int supportTaskId, SupportTask supportTask) {

        SupportTask supportTaskFromDb = customerSupportRepository.findById(supportTaskId).get();

        supportTaskFromDb.setComment(supportTask.getComment());
        supportTaskFromDb.setPriority(supportTask.getPriority());
        supportTaskFromDb.setStatus(supportTask.getStatus());

        customerSupportRepository.save(supportTaskFromDb);
        return supportTaskFromDb;
    }

    public List<SupportTask> deleteAllTasksCustomer(int customerId) {
        
        List <SupportTask> allSupportTasksForCustomer = customerSupportRepository.findByCustomerId(customerId);
        customerSupportRepository.deleteAll(allSupportTasksForCustomer);
        return allSupportTasksForCustomer;
 
    }

}

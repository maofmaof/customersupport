package com.customersupport.customersupport;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name = "supporttasks")
@AllArgsConstructor
@Getter
@Setter
@Entity
public class SupportTask {

    SupportTask() {

    }

    @Id
    int supportTaskId;
    int customerId;
    String priority;
    String comment;
    String status;

}

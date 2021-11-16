/*
 * UCF COP3330 Fall 2021 Assignment 4 Solution
 * Copyright 2021 Kelli Howard
 */

package ucf.assignments.app;

import java.io.Serializable;
import java.time.LocalDate;


@SuppressWarnings("serial")
public class TodoItem implements Serializable
{
    private LocalDate dueDate;
    private LocalDate completionDate;
    private String description;
    private String taskName;

    public TodoItem(String textOne, String textTwo, LocalDate value) {
        this.taskName = textOne;
        this.description = textTwo;
        this.dueDate = value;
        this.completionDate = null;
    }

    public String getName() {
        return this.taskName;
    }

    public String getDescrip() {
        return this.description;
    }

    @Override
    public String toString()
    {
        String[] taskDate = null;

        if(dueDate != null)
        {
            taskDate = dueDate.toString().split("-");
        }

        return taskName + "   |   " + description + ((taskDate == null)?"": "   |   " + taskDate[0] + "/" + taskDate[1] + "/" + taskDate[2]);

    }
}

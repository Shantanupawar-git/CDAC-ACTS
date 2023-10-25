package taskValidationRules;

import java.time.LocalDate;

import core.Task;

public class Taskvalidation {
	public static Task validateAll(String taskName, String description, String taskDate) {
		Task t1;
		LocalDate validdate=LocalDate.parse(taskDate);
		return new Task(taskName,description,validdate);
	}
}

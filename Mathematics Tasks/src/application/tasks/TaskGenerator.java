package application.tasks;

import java.util.Random;

public class TaskGenerator {

	// Single Instance,Don't need anymore
	private static TaskGenerator generator;

	// generator of random numbers
	private static Random random = new Random();

	public static TaskGenerator getInstance() {

		if (generator == null) {
			generator = new TaskGenerator();
		}

		return generator;
	}

	public Task generateNewTask() {

		Task task = new Task();

		task.setOperation(random.nextInt(4));

		if (task.getOperationOfTask() == '+' || task.getOperationOfTask() == '-') {
			task.setX(random.nextInt(10000));
			task.setY(random.nextInt(10000));

		}
		if (task.getOperationOfTask() == '*') {
			task.setX(random.nextInt(30));
			task.setY(random.nextInt(30));

		}
		if (task.getOperationOfTask() == '/') {
			int firstNum, secondNum;

			do {
				firstNum = random.nextInt(1000);
				secondNum = random.nextInt(30);
				task.setX(firstNum);
				task.setY(secondNum);
			} while ((secondNum == 0) || ((firstNum % secondNum != 0) && secondNum > 1));

		}
		task.calculateResult();
		return task;
	}

	private TaskGenerator() {
	}
}

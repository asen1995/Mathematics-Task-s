package application.tasks;

public class Task {

	private int x, y, result;
	private static char operations[] = new char[] { '+', '-', '*', '/' };
	private char operationOfTask;
	private boolean rightAnswer;

	public final int getX() {
		return x;
	}

	public final void setX(int x) {
		this.x = x;
	}

	public final int getY() {
		return y;
	}

	public final void setY(int y) {
		this.y = y;
	}

	public final boolean isRightAnswer() {
		return rightAnswer;
	}

	public final void setRightAnswer(boolean rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public final String getResult() {

		return Integer.toString(result);
	}

	public final void setResult(int result) {
		this.result = result;
	}

	public final char getOperationOfTask() {
		return operationOfTask;
	}

	public final void calculateResult() {
		switch (operationOfTask) {
		case '+': {

			result = x + y;
			break;
		}

		case '-': {
			result = x - y;
			break;
		}
		case '*': {
			result = x * y;
			break;
		}

		case '/': {
			result = x / y;
			break;
		}

		default:

			break;
		}
	}

	public final void setOperation(int numberOfOperation) {

		switch (numberOfOperation) {
		case 0: {
			this.operationOfTask = operations[0];
			break;
		}

		case 1: {
			this.operationOfTask = operations[1];
			break;
		}
		case 2: {
			this.operationOfTask = operations[2];
			break;
		}

		case 3: {
			this.operationOfTask = operations[3];
			break;
		}

		default:

			this.operationOfTask = operations[0];
			result = x + y;
			break;
		}

	}

	public final String getTaskAsString() {

		switch (operationOfTask) {

		case '+': {
			return "" + x + " + " + y + " = ";

		}
		case '-': {
			return "" + x + " - " + y + " = ";

		}
		case '*': {
			return "" + x + " * " + y + " = ";

		}
		case '/': {
			return "" + x + " / " + y + " = ";

		}
		}
		return "";
	}

	

}

package application.tasks;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

	private Text taskContent, taskAnswer;

	private Task currentTask;
	private TaskGenerator generator = TaskGenerator.getInstance();
	private Button submit;
	private Button nextTask;
	private Button bygoneTasks;
	private TextField field;
	private static Font FONT_OF_ELEMENTS = new Font(40);

	private List<Task> tasks = new ArrayList<>();

	private Parent createContent() {
		taskContent = new Text();
		taskContent.setTranslateX(30);
		taskContent.setTranslateY(150);
		taskContent.setFont(FONT_OF_ELEMENTS);

		field = new TextField();
		field.setTranslateX(370);
		field.setTranslateY(90);
		field.setFont(FONT_OF_ELEMENTS);
		field.setMaxWidth(150);

		submit = new Button("Submit");
		submit.setTranslateX(220);
		submit.setTranslateY(200);
		submit.setPrefSize(200, 80);
		submit.setFont(FONT_OF_ELEMENTS);
		nextTask = new Button("next");

		nextTask.setTranslateX(10);
		nextTask.setTranslateY(200);
		nextTask.setPrefSize(200, 80);
		nextTask.setFont(FONT_OF_ELEMENTS);

		bygoneTasks = new Button("Show list of bygone task's");
		bygoneTasks.setTranslateX(10);
		bygoneTasks.setTranslateY(10);
		bygoneTasks.setPrefSize(300, 60);
		bygoneTasks.setFont(new Font(20));

		taskAnswer = new Text();
		taskAnswer.setText("answer");

		taskAnswer.setTranslateX(430);
		taskAnswer.setTranslateY(250);
		taskAnswer.setFont(FONT_OF_ELEMENTS);
		currentTask = generator.generateNewTask();

		taskContent.setText(currentTask.getTaskAsString());

		submit.setOnAction(event -> onClickSubmit());
		nextTask.setOnAction(event -> onClickNextTaskButton());
		bygoneTasks.setOnAction(event -> displayTaskList());

		Pane root = new Pane(taskContent, field, submit, nextTask, bygoneTasks, taskAnswer);

		root.setPrefSize(600, 300);

		return root;
	}

	private void displayTaskList() {

		TaskList taskList = new TaskList();
		taskList.display(tasks);

	}

	private void onClickNextTaskButton() {
		tasks.add(currentTask);
		currentTask = generator.generateNewTask();
		taskContent.setText(currentTask.getTaskAsString());
		field.setText("");
		taskAnswer.setText("Answer");
		nextTask.setDisable(true);

	}

	private void onClickSubmit() {

		nextTask.setDisable(false);
		taskAnswer.setText(currentTask.getResult());
		if (currentTask.getResult().equalsIgnoreCase(field.getText())) {

			currentTask.setRightAnswer(true);
		} else {

			currentTask.setRightAnswer(false);
		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(createContent());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Mathematics tasks");
		primaryStage.setResizable(false);

	}

	public static void main(String[] args) {
		launch(args);

	}
}

package application.tasks;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TaskList extends Stage {

	private Pane root;
	private byte counter;
	private int x = 10, y = 20;

	public void display(List<Task> tasks) {
		setTitle("List of last 20 tasks");

		Font font = new Font(20);

		Text text = new Text("list of last 20 tasks");
		text.setTranslateX(x);
		text.setTranslateY(y);
		text.setFont(font);
		root = new Pane();
		root.getChildren().add(text);

		tasks.forEach(el -> {
			Text t;
			counter++;
			if (counter >= 20) {

			} else {

				if (el.isRightAnswer()) {
					t = new Text(el.getTaskAsString() + el.getResult() + " Right!");
				} else {
					t = new Text(el.getTaskAsString() + el.getResult() + " Wrong!");

				}
				t.setTranslateX(x);
				y += 20;
				t.setTranslateY(y);
				t.setFont(new Font(19));
				root.getChildren().add(t);
			}
		});

		root.setPrefSize(300, 748);
		Scene scene = new Scene(root);
		setScene(scene);
		show();
	}
}

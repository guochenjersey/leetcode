package org.black.lotus.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;



public class StageApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane(5, 5);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                double size = 300;
                Rectangle rect = new Rectangle(size, size, (i + j) % 2 == 0 ? Color.RED : Color.BLUE);
                root.getChildren().add(rect);
            }
        }
        Rectangle2D screenRect = Screen.getPrimary().getBounds();
        Scene scene = new Scene(root, screenRect.getWidth(), screenRect.getHeight());
        primaryStage.setTitle(root.getClass().getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

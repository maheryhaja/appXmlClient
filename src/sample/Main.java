package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.presentation.splash.SplashStage;
import sample.service.CommonInjector;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        CommonInjector.getInstance().initializeWithApp(this);

        Stage splash = new SplashStage();
        splash.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

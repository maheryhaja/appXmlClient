package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.donnee.server.ServerConfDto;
import sample.presentation.splash.SplashStage;
import sample.service.CommonInjector;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        CommonInjector.getInstance().initializeWithApp(this);

        Stage splash = new SplashStage();
        splash.show();
        ServerConfDto value = CommonInjector.getInstance().injectServerSA().readServerConf();
        if (value != null) {
            System.out.println(String.format("host:%s port:%s", value.getHost(), value.getPort()));
        } else {
            System.out.println("aucune valeur");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

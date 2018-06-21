package sample.service.applicatif.resources;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import sample.service.CommonInjector;

import java.io.IOException;

public class resourceSAImpl implements ResourceSA {


    private Application application;

    public resourceSAImpl() {
        application = CommonInjector.getInstance().injectApplication();
    }

    @Override
    public Parent loadView(String path) {
        try {
            return FXMLLoader.load(application.getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

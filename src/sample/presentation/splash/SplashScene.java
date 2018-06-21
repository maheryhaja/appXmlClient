package sample.presentation.splash;

import javafx.scene.Parent;
import sample.commun.path.VIEWPATH;
import sample.presentation.generic.BaseScene;

public class SplashScene extends BaseScene {


    public SplashScene(Parent root) {
        super(root);
    }


    @Override
    public void initializeView() {
        getStylesheets().addAll(getClass().getResource("splash.css").toExternalForm());
    }
}

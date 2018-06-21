package sample.presentation.splash;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import sample.commun.dimens.DIMENSION;
import sample.commun.path.VIEWPATH;
import sample.presentation.generic.BaseStage;


public class SplashStage extends BaseStage {

    @Override
    public void initializeView() {
        Parent root = resourceSA.loadView(VIEWPATH.Splash.SPLASHVIEW);
        setWidth(DIMENSION.Splash.SPLASH_WIDTH);
        setHeight(DIMENSION.Splash.SPLASH_HEIGHT);
        initStyle(StageStyle.UNDECORATED);
        setScene(new SplashScene(root));
    }
}

package sample.presentation.generic;

import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.service.CommonInjector;
import sample.service.applicatif.resources.ResourceSA;

public abstract class BaseScene extends Scene implements InitializableComponent{

    protected ResourceSA resourceSA;

    public BaseScene(Parent root) {
        super(root);
        resourceSA = CommonInjector.getInstance().injectResourceSA();
        initializeView();
    }

    public BaseScene(Parent root, double width, double height) {
        super(root, width, height);
        resourceSA = CommonInjector.getInstance().injectResourceSA();
        initializeView();
    }
}

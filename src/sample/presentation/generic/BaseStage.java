package sample.presentation.generic;

import javafx.stage.Stage;
import sample.service.CommonInjector;
import sample.service.applicatif.resources.ResourceSA;

public abstract class BaseStage extends Stage implements InitializableComponent{

    protected ResourceSA resourceSA;

    public BaseStage() {
        super();

        resourceSA = CommonInjector.getInstance().injectResourceSA();

        initializeView();

    }
}

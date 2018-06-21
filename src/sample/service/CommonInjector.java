package sample.service;


import javafx.application.Application;
import sample.service.applicatif.resources.ResourceSA;
import sample.service.applicatif.resources.resourceSAImpl;
import sample.service.applicatif.server.ServerSA;
import sample.service.applicatif.server.ServerSAImpl;

// responsable d'instancier tous les singletons
public class CommonInjector {

    private static CommonInjector commonInjectorInstance = new CommonInjector();

    private Application application = null;
    private ResourceSA resourceSA;
    private ServerSA serverSA;

    public static synchronized CommonInjector getInstance() {
        if (commonInjectorInstance == null) {
            commonInjectorInstance = new CommonInjector();
        }

        return commonInjectorInstance;
    }

    private CommonInjector() {

    }

    public void initializeWithApp(Application application) {
        this.application = application;
    }

    //injecter l'application
    public Application injectApplication() {
        return application;
    }

    public ResourceSA injectResourceSA() {
        if (resourceSA == null) {
            resourceSA = new resourceSAImpl();
        }
        return resourceSA;
    }

    public ServerSA injectServerSA() {
        if (serverSA == null) {
            serverSA = new ServerSAImpl();
        }
        return serverSA;
    }


}

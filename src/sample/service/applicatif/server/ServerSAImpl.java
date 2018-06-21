package sample.service.applicatif.server;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import sample.commun.conf.DEFAULTCONF;
import sample.donnee.server.ServerConfDto;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerSAImpl implements ServerSA {

    PublishSubject<ServerConfDto> publishSubject = PublishSubject.create();

    JAXBContext jaxbContext;
    Marshaller marshaller;
    Unmarshaller unmarshaller;

    public ServerSAImpl() {

        try {
            jaxbContext = JAXBContext.newInstance(ServerConfDto.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    @Override
    public ServerConfDto readServerConf() {

        //read Logic here
        if (!Files.exists(getServerConfPath())) {
            writeServerConf(getDefaultServerConf());
        }
        try {
            return (ServerConfDto) unmarshaller.unmarshal(Files.newBufferedReader(getServerConfPath()));
        } catch (JAXBException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void writeServerConf(ServerConfDto serverConfDto) {

        //write logic here
        //if write success

        try {

            marshaller.marshal(serverConfDto, Files.newOutputStream(getServerConfPath()));
            publishSubject.onNext(serverConfDto);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Observable<ServerConfDto> onServerConfUpdated() {
        return null;
    }

    private Path getServerConfPath() {
        return Paths.get(DEFAULTCONF.Server.DEFAULTPATH);
    }

    private ServerConfDto getDefaultServerConf() {
        ServerConfDto serverConfDto = new ServerConfDto();
        serverConfDto.setHost(DEFAULTCONF.Server.DEFAULTHOST);
        serverConfDto.setPort(DEFAULTCONF.Server.DEFAULTPORT);
        return serverConfDto;
    }

}

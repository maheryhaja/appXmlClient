package sample.service.applicatif.server;

import io.reactivex.Observable;
import sample.donnee.server.ServerConfDto;

import java.io.OutputStream;

public interface ServerSA {
    ServerConfDto readServerConf();
    void writeServerConf(ServerConfDto serverConfDto);

    Observable<ServerConfDto> onServerConfUpdated();
}

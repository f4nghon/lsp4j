package src.main;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageClient;

import java.io.InputStream;
import java.io.OutputStream;

public class ServerLauncher {
    public static void main(String[] args) {
        MainServer server = new MainServer();
        Launcher<LanguageClient> launcher = Launcher.createLauncher(
            server,
            LanguageClient.class,
            System.in,
            System.out
        );
        server.connect(launcher.getRemoteProxy());
        launcher.startListening().join();
    }
}

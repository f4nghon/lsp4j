package src.main;
import org.eclipse.lsp4j.services.*;

import src.MainTextDocumentService;

import org.eclipse.lsp4j.*;
import java.util.concurrent.CompletableFuture;
import java.util.List;

public class MainServer implements LanguageServer, LanguageClientAware {

    private int shutdown = 1;
    private LanguageClient client;
    private final MainTextDocumentService textDocumentService = new MainTextDocumentService();

    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
        ServerCapabilities capabilities = new ServerCapabilities();
        capabilities.setTextDocumentSync(TextDocumentSyncKind.Full);
        capabilities.setCompletionProvider(new CompletionOptions(true, List.of(" ")));

        return CompletableFuture.completedFuture(new InitializeResult(capabilities));
    }

    @Override
    public CompletableFuture<Object> shutdown() {
        this.shutdown = 0;
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public void exit() {
        System.exit(shutdown);
    }

    @Override
    public TextDocumentService getTextDocumentService() {
        return textDocumentService;
    }

    @Override
    public WorkspaceService getWorkspaceService() {
        return new WorkspaceService() {};
    }

    @Override
    public void connect(LanguageClient client) {
        this.client = client;
    }
}

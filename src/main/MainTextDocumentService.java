package demo.src.main;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.*;
import java.util.concurrent.CompletableFuture;
import java.util.List;

public class MainTextDocumentService implements TextDocumentService {

    @Override
    public CompletableFuture completion(CompletionParams position) {
        CompletionItem item1 = new CompletionItem("Hello");
        item1.setKind(CompletionItemKind.Keyword);

        CompletionItem item2 = new CompletionItem("World");
        item2.setKind(CompletionItemKind.Keyword);

        CompletionList completionList = new CompletionList();
        completionList.setItems(List.of(item1, item2));

        return CompletableFuture.completedFuture(completionList);
    }


    // Implement other methods as no-ops
    @Override public void didOpen(DidOpenTextDocumentParams params) {}
    @Override public void didChange(DidChangeTextDocumentParams params) {}
    @Override public void didClose(DidCloseTextDocumentParams params) {}
    @Override public void didSave(DidSaveTextDocumentParams params) {}
}

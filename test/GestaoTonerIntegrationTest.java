import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestaoTonerIntegrationTest {

    @TempDir
    Path diretorioTemporario;

    @Test
    void deveExportarPedidoParaArquivoCsv() throws Exception {
        GestaoTonerApp.Pedido pedido = new GestaoTonerApp.Pedido();

        pedido.chamado = "TESTE-INTEGRACAO-001";
        pedido.departamento = "IMPRESSORA DEMO";
        pedido.equipamento = "EQUIPAMENTO TESTE";
        pedido.contador = "1500";
        pedido.corToner = "TONER TESTE";
        pedido.solicitante = "USUARIO TESTE";
        pedido.status = GestaoTonerApp.Pedido.STATUS_AGUARDANDO;
        pedido.dataSolicitacao = "2026-09-24T19:30:00";

        Path arquivoCsv = diretorioTemporario.resolve("pedidos.csv");

        GestaoTonerApp.Storage storage = new GestaoTonerApp.Storage();
        storage.exportPedidosCsv(List.of(pedido), arquivoCsv);

        assertTrue(Files.exists(arquivoCsv));

        String conteudo = Files.readString(
                arquivoCsv,
                StandardCharsets.UTF_8
        );

        assertTrue(conteudo.contains("Chamado;Status"));
        assertTrue(conteudo.contains("TESTE-INTEGRACAO-001"));
        assertTrue(conteudo.contains("Aguardando Aprovação"));
        assertTrue(conteudo.contains("USUARIO TESTE"));
        assertTrue(conteudo.contains("24/09/2026 19:30"));
    }
}

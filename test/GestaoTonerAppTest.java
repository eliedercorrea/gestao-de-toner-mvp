import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestaoTonerAppTest {

    @Test
    void deveEscaparCaracteresHtml() {
        String resultado = GestaoTonerApp.htmlEscape("<b>A&B</b>");

        assertEquals("&lt;b&gt;A&amp;B&lt;/b&gt;", resultado);
    }

    @Test
    void deveConverterQuebraDeLinhaParaBr() {
        String resultado = GestaoTonerApp.nl2br("Linha 1\nLinha 2");

        assertEquals("Linha 1<br>Linha 2", resultado);
    }

    @Test
    void deveSepararEmailsERemoverDuplicados() {
        List<String> emails = GestaoTonerApp.splitEmails(
                "usuario1@exemplo.com; usuario2@exemplo.com usuario1@exemplo.com"
        );

        assertEquals(2, emails.size());
        assertEquals("usuario1@exemplo.com", emails.get(0));
        assertEquals("usuario2@exemplo.com", emails.get(1));
    }

    @Test
    void deveFormatarListaDeEmails() {
        String resultado = GestaoTonerApp.joinEmails(
                "usuario1@exemplo.com;usuario2@exemplo.com"
        );

        assertEquals(
                "usuario1@exemplo.com, usuario2@exemplo.com",
                resultado
        );
    }

    @Test
    void deveConverterNumeroOuUsarValorPadrao() {
        assertEquals(42, GestaoTonerApp.parseInt("42", 0));
        assertEquals(-1, GestaoTonerApp.parseInt("valor-invalido", -1));
    }

    @Test
    void deveFormatarDataHoraParaExibicao() {
        String resultado = GestaoTonerApp.formatDateTimeDisplay(
                "2026-09-24T19:30:00"
        );

        assertEquals("24/09/2026 19:30", resultado);
    }

    @Test
    void deveAbreviarTextoLongo() {
        assertEquals(
                "ABC...",
                GestaoTonerApp.shorten("ABCDEFGHIJ", 6)
        );
    }

    @Test
    void deveIncluirDadosDoPedidoNaPesquisa() {
        GestaoTonerApp.Pedido pedido = new GestaoTonerApp.Pedido();
        pedido.chamado = "DEMO-TESTE-001";
        pedido.solicitante = "USUARIO TESTE";
        pedido.status = GestaoTonerApp.Pedido.STATUS_AGUARDANDO;

        String texto = pedido.searchText();

        assertTrue(texto.contains("DEMO-TESTE-001"));
        assertTrue(texto.contains("USUARIO TESTE"));
        assertTrue(texto.contains("Aguardando Aprovação"));
    }

    @Test
    void deveGerarEmailComConteudoEscapado() {
        String html = GestaoTonerApp.buildSolicitacaoHtmlEmail(
                "TESTE-001",
                "IMPRESSORA <TESTE>",
                "1000",
                "USUARIO 1",
                "Linha 1\nLinha 2"
        );

        assertTrue(html.contains("TESTE-001"));
        assertTrue(html.contains("IMPRESSORA &lt;TESTE&gt;"));
        assertTrue(html.contains("Linha 1<br>Linha 2"));
        assertTrue(html.contains("Aguardando Aprova&#231;&#227;o"));
    }
}

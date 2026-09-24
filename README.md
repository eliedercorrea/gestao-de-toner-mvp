# Gestão de Toner — MVP Acadêmico

Aplicação desktop em Java Swing para registrar e acompanhar solicitações de toner. Esta pasta é uma **versão acadêmica e sanitizada** do sistema, preparada para ser publicada em um repositório GitHub público.

## Objetivo

Centralizar o registro de solicitações de toner, acompanhar o status dos pedidos e organizar informações relacionadas ao atendimento, reduzindo controles manuais e facilitando a consulta do histórico.

## Funcionalidades demonstradas

- cadastro e acompanhamento de solicitações;
- status **Aguardando Aprovação**, **A Caminho** e **Entregue**;
- pesquisa e filtros;
- seleção de impressora/modelo de toner;
- seleção de cores para impressoras coloridas;
- contador de impressão com dados demonstrativos;
- registro de nota fiscal, tipo de envio e código de rastreio;
- controle de estoque;
- exportação de pedidos em CSV e impressão da lista;
- configuração opcional de integração via Power Automate;
- envio opcional de anexos pelo fluxo configurado.

## Privacidade e segurança

Este repositório **não contém dados reais da operação**. Foram removidos ou substituídos:

- históricos de pedidos reais;
- endereços IP e identificadores de equipamentos internos;
- nomes de colaboradores usados na operação;
- endereços de e-mail corporativos;
- URLs reais de Power Automate, credenciais e configurações locais;
- logs, bancos de dados e binários da versão em produção.

Os arquivos gerados em `dados-academico/` e a configuração `dados-academico/email.properties` são ignorados pelo Git. Ao iniciar a aplicação pela primeira vez, ela cria somente registros fictícios para demonstração. A pasta possui nome diferente da usada pela versão de produção para evitar qualquer colisão acidental com os dados reais.

## Requisitos

- JDK 17 ou superior.

## Compilar

### Windows

Execute:

```bat
build.bat
```

### Linux/macOS

Execute:

```bash
./build.sh
```

O JAR será criado em `dist/GestaoToner-Academico.jar`.

## Executar

Após compilar:

```bash
java -jar dist/GestaoToner-Academico.jar
```

## Estrutura

```text
src/            código-fonte Java
dados-academico/ arquivos locais gerados em execução (não versionados)
config/         exemplo de configuração sem credenciais
docs/           exemplos e documentação complementar
assets/         ícones do projeto
manifest.txt    manifesto para geração do JAR
build.bat       compilação no Windows
build.sh        compilação no Linux/macOS
```

## Integração com Power Automate

A versão pública não possui URL, e-mail ou credencial pré-configurados. Além disso, enquanto `ACADEMIC_DEMO_MODE` estiver habilitado, os envios pelo Power Automate são **simulados** e nenhuma chamada de rede é realizada, mesmo que uma URL seja preenchida. O arquivo `config/email.properties.example` serve apenas como referência e utiliza valores fictícios.

## Observação acadêmica

A opção **Consulta Contador** utiliza valores simulados nesta versão para evitar qualquer tentativa de acesso à rede interna do ambiente onde a aplicação original é utilizada. A lógica principal da interface é mantida para fins de demonstração do MVP.

## Autor

Elieder — projeto acadêmico de software.

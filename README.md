
# API de Validação de Produtos - Lojinha

Este repositório contém testes de API Rest para o módulo de Produtos da aplicação Lojinha. Os testes foram implementados em Java utilizando a biblioteca RestAssured e JUnit.

## Tabela de Conteúdo

- [Introdução](#introdução)
- [Recursos](#recursos)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Como Usar](#como-usar)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Contato](#contato)

## Introdução

Este projeto tem como objetivo validar a funcionalidade do módulo de Produtos da aplicação Lojinha por meio de testes de API. Ele verifica se a API permite a inserção de produtos com valores fora dos limites especificados.

## Recursos

- Testes automatizados de API para o módulo de Produtos.
- Verificação de restrições de valor na criação de produtos.

## Pré-requisitos

- Java Development Kit (JDK) 8 ou superior instalado.
- Biblioteca RestAssured configurada no ambiente de desenvolvimento.
- Acesso à API da aplicação Lojinha.
- Token de autenticação de usuário administrador para a API.

## Instalação

1. Clone este repositório em sua máquina local:

```bash
git https://github.com/gustavoferrazdesousa/lojinhaAPIAutomacao
```

2. Abra o projeto em sua IDE favorita.

3. Certifique-se de que as dependências do projeto estejam instaladas.

## Como Usar

1. Configure o token de autenticação do usuário administrador no arquivo `ProdutoTest.java` no método `beforEach`.

2. Execute os testes do projeto. Você pode executar individualmente os testes definidos no arquivo `ProdutoTest.java`.

## Contribuição

Contribuições são bem-vindas! Se você deseja contribuir com melhorias, correções de bugs ou novos recursos, siga estas etapas:

1. Faça um fork deste repositório.

2. Crie uma nova branch com a sua contribuição:

```bash
git checkout -b feature/sua-contribuicao
```

3. Faça commit das suas alterações:

```bash
git commit -m 'Adiciona funcionalidade X'
```

4. Faça push para a branch criada:

```bash
git push origin feature/sua-contribuicao
```

5. Abra um pull request neste repositório.

## Licença

Este projeto está sob a licença [LojinhaAPI PTQS](LICENSE).

## Contato

Para dúvidas, sugestões ou informações adicionais, entre em contato com [Gustavo Ferraz](mailto:gustavoferrazdesousa@gmail.com).

```

Lembre-se de substituir `[Nome da Licença]`, `[seu-usuario]`, `[nome-do-repositorio]`, `[sua-contribuicao]`, `[seu-nome]` e `[seu-email@example.com]` com as informações corretas do seu projeto e preferências. Este é um ponto de partida para criar um README informativo e útil para o seu repositório no GitHub.# lojinhaAPIAutomacao

```

Este código é um teste de API Rest para o módulo de Produtos de uma aplicação. Ele utiliza a biblioteca RestAssured para enviar solicitações HTTP à API e verificar as respostas. Vou explicar o que cada parte do código faz:

1. Importações:
   O código importa várias classes e métodos relacionados ao RestAssured, JUnit e classes personalizadas de fábricas de dados (ProdutoDataFactory e UsuarioDataFactory) e classes de objetos (ComponentePojo, ProdutoPojo e UsuarioPojo).

2. Configuração:
   - `baseURI` é definido como o endereço da API da lojinha.
   - `basePath` é definido como o caminho base para todas as solicitações da API.

3. Antes de cada teste (`@BeforeEach`):
   - Um token de autenticação é obtido fazendo uma solicitação POST para "/v2/login" com os dados de um usuário administrador.
   - O token é armazenado em `this.token` para ser usado nas solicitações subsequentes.

4. Teste 1 (`testValidarLimitesZeradosProibidosValorProduto`):
   - Este teste verifica se a API impede a inserção de produtos com valor igual a 0.00.
   - Uma solicitação POST é enviada para "/v2/produtos" com um corpo que representa um produto com valor 0.00.
   - A resposta é verificada:
     - O corpo da resposta deve conter uma chave "error" com o valor "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00".
     - O código de status da resposta deve ser 422 (Unprocessable Entity).

5. Teste 2 (`testValidarLimitesMaiorQueSeteProibidosValorProduto`):
   - Este teste verifica se a API impede a inserção de produtos com valor maior do que 7.000,00.
   - Uma solicitação POST é enviada para "/v2/produtos" com um corpo que representa um produto com valor 7000.01.
   - A resposta é verificada de maneira semelhante ao Teste 1.

Esses testes garantem que a API Rest do módulo de Produtos esteja funcionando corretamente ao impedir a inserção de produtos com valores fora dos limites especificados (0.01 a 7.000,00) e que retorne as respostas esperadas em caso de falha. Eles também demonstram o uso do RestAssured para escrever testes de API em Java com JUnit.

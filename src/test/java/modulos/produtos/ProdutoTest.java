package modulos.produtos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


@DisplayName("Testes de API Rest do modulo de Produtos")
public class ProdutoTest {
    @Test
    @DisplayName("Validar os limites proibidos do valor do produto")
    public void testValidarLimitesProibidosValorProduto(){
        //Configurando os dados da API Rest da lojinha
        baseURI = "http://165.227.93.41";
        //port = 8080(nº da porta, caso seja necessário
        basePath = "/lojinha";

        //Obter o token do usuario admin
        String token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"usuarioLogin\": \"admin\",\n" +
                        "  \"usuarioSenha\": \"admin\"\n" +
                        "}")
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");

        System.out.println(token);

        //Tentar inserir produto com valor 0.00 e validar que a mensagem de erro foi apresentada
        // e ostatus code retornardo foi 422

    }
}

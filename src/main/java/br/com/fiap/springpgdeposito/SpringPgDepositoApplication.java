package br.com.fiap.springpgdeposito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringPgDepositoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPgDepositoApplication.class, args);
    }

    @GetMapping(value = "/")
    public String index() {
        return """
                <main style="width: 100%; padding-top: 90px;">
                    <h1 style="font-family: sans-serif;text-align: center;">Seja muito bem vindo a Holding Benezinho</h1>
                    <nav>
                        <ul>
                            <li><a href="/produtos">Produtos</a></li>
                        </ul>
                    </nav>
                </main>
                """;
    }

}

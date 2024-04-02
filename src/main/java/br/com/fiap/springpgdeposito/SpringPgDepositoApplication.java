package br.com.fiap.springpgdeposito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@SpringBootApplication
public class SpringPgDepositoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPgDepositoApplication.class, args);
    }

    @GetMapping(value = "/")
    public String index() {

        ArrayList<String> linkList = new ArrayList<>();

        return """
                <main style="width: 100%; padding-top: 90px;font-family: sans-serif;">
                    <h1 style="text-align: center;">Seja muito bem vindo a Holding Benezinho</h1>
                    <nav style="width: 90%;">
                        <ul style="list-style-type: none; display: flex; justify-content: space-between;">
                            <li>
                                <a
                                style="text-decoration: none; color: #000; padding: 10px 20px; transition: .3s; border-radius: 5px;"
                                onMouseOver="this.style.backgroundColor='black', this.style.color='white'"
                                onMouseOut="this.style.backgroundColor='white', this.style.color='black'"
                                href="/deposito">
                                    Depositos
                                </a>
                            </li>
                            <li>
                                <a
                                style="text-decoration: none; color: #000; padding: 10px 20px; transition: .3s; border-radius: 5px;"
                                onMouseOver="this.style.backgroundColor='black', this.style.color='white'"
                                onMouseOut="this.style.backgroundColor='white', this.style.color='black'"
                                href="/endereco">
                                    Endereços
                                </a>
                            </li>
                            <li>
                                <a
                                style="text-decoration: none; color: #000; padding: 10px 20px; transition: .3s; border-radius: 5px;"
                                onMouseOver="this.style.backgroundColor='black', this.style.color='white'"
                                onMouseOut="this.style.backgroundColor='white', this.style.color='black'"
                                href="/produto">
                                    Produtos
                                </a>
                            </li>
                        </ul>
                    </nav>
                </main>
                """;
    }

}

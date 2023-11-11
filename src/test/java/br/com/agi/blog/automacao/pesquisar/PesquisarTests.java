package br.com.agi.blog.automacao.pesquisar;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.className;

@DisplayName("Teste Automatizado da Funcionalidade Pesquisar")
public class PesquisarTests {
    @Test
    @DisplayName("Realizar busca por tópico")
    public void testRealizarBuscaPorTopico() {
        // Configura o driver do Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nlnor\\igor\\geckodriver.exe");
        WebDriver navegador = new FirefoxDriver();

        // Abre a página do blog do Agi
        navegador.get("https://blogdoagi.com.br/");

        // Realiza a busca por tópico
        WebElement searchOpen = navegador.findElement(By.id("search-open"));
        searchOpen.click();
        WebElement searchField = navegador.findElement(className("search-field"));
        searchField.sendKeys("finanças");
        WebElement searchSubmit = navegador.findElement(className("search-submit"));
        searchSubmit.click();

        // Valida os resultados da busca
        WebElement resultsList = navegador.findElement(className("archive-title"));
        int resultsCount = resultsList.findElements(By.xpath("//a[contains(text(),'Agibank é destaque em ranking que lista as 200 principais fintechs do mundo')]")).size();
        System.out.println("Foram encontrados " + resultsCount + " resultados para a busca por finanças.");

        // Fecha o navegador
        navegador.quit();
    }

}

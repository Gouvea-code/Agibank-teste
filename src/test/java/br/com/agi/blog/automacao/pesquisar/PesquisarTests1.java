package br.com.agi.blog.automacao.pesquisar;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.className;

@DisplayName("Teste Automatizado da Funcionalidade Pesquisar")
public class PesquisarTests1 {
    @Test
    @DisplayName("Realizar busca por Data")
    public void testRealizarBuscaPorData() {
        // Configura o driver do Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nlnor\\igor\\geckodriver.exe");
        WebDriver navegador = new FirefoxDriver();

        // Abre a página do blog do Agi
        navegador.get("https://blogdoagi.com.br/");

        // Realiza a busca por data
        WebElement searchOpen = navegador.findElement(By.id("search-open"));
        searchOpen.click();
        WebElement searchField = navegador.findElement(className("search-field"));
        searchField.sendKeys("2023-07-20");
        WebElement searchSubmit = navegador.findElement(className("search-submit"));
        searchSubmit.click();

        // Valida os resultados da busca
        WebElement resultsList = navegador.findElement(className("entry-title"));
        int resultsCount = resultsList.findElements(By.xpath("//h1[contains(text(),'Nenhum resultado')]")).size();
        System.out.println("Não foram encontrados " + resultsCount + " resultados para a busca por artigos publicados em 2023-07-20.");

        // Fecha o navegador
        navegador.quit();
    }

}

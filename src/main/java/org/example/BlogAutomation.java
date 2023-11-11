package com.agi.blog.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlogAutomation {

    public static void main(String[] args) throws InterruptedException {
        // Configura o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Abre a página do blog do Agi
        driver.get("https://blogdoagi.com.br/");

        // Realiza a busca por tópico
        WebElement searchField = driver.findElement(By.id("search-field"));
        searchField.sendKeys("finanças");
        driver.findElement(By.id("search-button")).click();

        // Valida os resultados da busca
        WebElement resultsList = driver.findElement(By.id("search-results"));
        int resultsCount = resultsList.findElements(By.className("post-item")).size();
        System.out.println("Foram encontrados " + resultsCount + " resultados para a busca por finanças.");

        // Realiza a busca por data
        searchField.clear();
        searchField.sendKeys("2023-07-20");
        driver.findElement(By.id("search-button")).click();

        // Valida os resultados da busca
        resultsList = driver.findElement(By.id("search-results"));
        resultsCount = resultsList.findElements(By.className("post-item")).size();
        System.out.println("Foram encontrados " + resultsCount + " resultados para a busca por artigos publicados em 2023-07-20.");

        // Fecha o navegador
        driver.quit();
    }
}
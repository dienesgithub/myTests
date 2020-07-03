package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MagaluTest {
	
	private WebDriver driver;
	private String titulo = "Magazine Luiza | Pra você é Magalu!";
	private String primeiroProduto = "Xbox One Controle Sem Fio Original Elite Series 2 - Microsoft";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Workspace\\magalu\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void acessarPortal() throws InterruptedException {
		driver.get("https://www.magazineluiza.com.br/");
		assertTrue("Titulo esperado: '" + titulo + "' diferente do obtido: '" + driver.getTitle() + "'", driver.getTitle().contentEquals(titulo));
		Thread.sleep(3000);
		
		
		WebElement buscaTexto = driver.findElement(By.xpath("//*[@id='inpHeaderSearch']"));
		buscaTexto.sendKeys("controle elite xbox one");
		Thread.sleep(3000);
		WebElement buscaBotao = driver.findElement(By.id("btnHeaderSearch"));
		Thread.sleep(1000);
		buscaBotao.click();
		Thread.sleep(3000);
		WebElement produto = driver.findElement(By.xpath("//*[@id='product_gd3cd9e785']/div[3]/h2"));
		assertTrue("O produto esperado: " + primeiroProduto + " é diferente do obtido: " + produto.getText(), produto.getText().contentEquals(primeiroProduto));
		produto.click();
		Thread.sleep(3000);
		WebElement addSacolaBotao = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div[1]/div[4]/div[2]/button"));
		addSacolaBotao.click();
		Thread.sleep(10000);
		WebElement continuarComprandoBotao = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[2]/div/div[4]/div[2]/div[1]/a"));
		continuarComprandoBotao.click();
		Thread.sleep(10000);
		WebElement qtdSacola = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/header/div/div[1]/div/div/div[2]/div[1]/a[1]/div/i"));
		assertTrue("Espera-se apenas 1 item na sacola", qtdSacola.getText().contentEquals("1"));
		Thread.sleep(90000);
	}

}

package methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Selanium123 {
	public static void main(String[] args) throws Throwable  {
		    WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
			driver.navigate().to("https://www.makemytrip.com/");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
			driver.findElement(By.xpath("//span[text()='Buses' and @class='headerIconTextAlignment chNavText darkGreyText']")).click();
			driver.findElement(By.xpath("//input[@id='fromCity']")).click();
			driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Trichy");
			driver.findElement(By.xpath("//span[text()='Tiruchirapalli (Trichy), Tamil Nadu']")).click();
			driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bangalore");
			driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka']")).click();
			driver.findElement(By.xpath("//div[@aria-label='Thu Jun 06 2024']")).click();
			driver.findElement(By.xpath("//button[@id='search_button']")).click();
			List<String> lq = new LinkedList<>();
			List<String> lx = new LinkedList<>();
			List<String> ly = new LinkedList<>();
			List<String> lz = new LinkedList<>();
			List<WebElement> buses= driver.findElements(By.xpath("//p[contains(@class,'makeFlex hrtlCenter appendBottom')]"));
			List<WebElement> deptime = driver.findElements(By.xpath("//span[contains(@class,'latoBlack blackText')]"));
			List<WebElement> arrtime = driver.findElements(By.xpath("//span[contains(@class,'latoRegular')]"));
			List<WebElement> farerate = driver.findElements(By.xpath("//span[@id='price']"));
			for (int i = 0; i < buses.size(); i++) {
				String bus = buses.get(i).getText();
				lq.add(bus)
	;
				String dept = deptime.get(i).getText();
				lx.add(dept);
				String arrival = arrtime.get(i).getText();
				ly.add(arrival);
				String rate = farerate.get(i).getText();
				lz.add(rate);
				System.out.println("BusesNames: "+bus+"DepartureTime: "+dept+"ArrivalTime: "+arrival+"Rate: "+rate);
				}
			File f = new File("C:\\Users\\balap\\OneDrive\\Documents\\Raj.xlsx");	
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet s = wb.createSheet("Sheet1");
			for(int i=0; i<lq.size(); i++) {
				Row r = s.getRow(i);
				if (r == null) {
					r = s.createRow(i);
				}
				Cell c = r.createCell(0);
				c.setCellValue(lq.get(i));
			}
			for(int i=0; i<lx.size(); i++) {
				Row r = s.getRow(i);
				if (r == null) {
					r = s.createRow(i);
				}
				Cell c = r.createCell(1);
				c.setCellValue(lx.get(i));
			}
			for(int i=0; i<ly.size(); i++) {
				Row r = s.getRow(i);
				if (r == null) {
					r = s.createRow(i);
				}
				Cell c = r.createCell(2);
				c.setCellValue(ly.get(i));
			}
			for(int i=0; i<lz.size(); i++) {
				Row r = s.getRow(i);
				if (r == null) {
					r = s.createRow(i);
				}
				Cell c = r.createCell(3);
				c.setCellValue(lz.get(i));
			}
			FileOutputStream f1 = new FileOutputStream(f);
			wb.write(f1);
			f1.close();
			driver.findElement(By.xpath("//div[@class=\"sc-jKJlTe fnCpOO\" or  @data-test-id=\"select-seats\"][last()]")).click();
			driver.findElement(By.xpath("(//span[@data-testid='seat_horizontal_sleeper_available' or @class='listingSprite commonSmallSeatIcon appendBottom4'])[10]")).click();
	        driver.findElement(By.xpath("//span[text()='Continue']")).click();
            //driver.findElement(By.xpath("//span[text()='Continue']")).click();
            driver.findElement(By.xpath("//input[@name=\"fname\"]")).sendKeys("ponmalar");
            driver.findElement(By.xpath("//input[@id=\"age\"]")).sendKeys("26");
            driver.findElement(By.xpath("//div[text()='Female']")).click();
            driver.findElement(By.xpath("//input[@value=\"Tamil Nadu\"]")).click();
            driver.findElement(By.xpath("//li[text()='Tamil Nadu']")).click();
            driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("pon78887@gmail.com");
            driver.findElement(By.xpath("//input[@autocomplete=\"tel\"]")).sendKeys("9876543210");
            driver.findElement(By.xpath("//p[@class=\"checkboxWithLblWpr__label\"]")).click();
            driver.findElement(By.xpath("//div[@class=\"paymentBtn whiteText latoBold font16 capText\"]")).click();
            
            
            
            
            
            
	}

}

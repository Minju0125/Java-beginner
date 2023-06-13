package teamProject01.sec01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate now = LocalDate.now();
		LocalDate result =now.plusDays(10);
		
		String sysdate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		System.out.println(sysdate);
	}

}

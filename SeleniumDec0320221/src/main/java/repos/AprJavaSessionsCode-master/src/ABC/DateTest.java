package ABC;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTest {

	public static void main(String[] args) {

		Instant instant = Instant.parse("2021-12-31T00:00:00.00Z");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
		.withZone(ZoneId.systemDefault());
		System.out.println(formatter.format(instant));//2022-12-31 08:00:00
		
		
	}

}

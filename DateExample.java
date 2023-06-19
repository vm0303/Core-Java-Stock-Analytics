import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateExample {
    public static void main(String[] args) throws ParseException {

        //Old way with java.util.Date
        Date date = new Date();
        System.out.println(date);
        System.out.println(" Epoch Time:"+date.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Singapore")));
        Date parsedDate = simpleDateFormat.parse("2023-01-09");
        System.out.println("Parsed Date is "+parsedDate);

        //Instance represents UTC - Latest method
        Instant nowInstance = Instant.now();
        Instant fiveMinutesAgo = nowInstance.minusSeconds(300);
        System.out.println(" Time now is "+nowInstance+ " and time five minutes ago is "+fiveMinutesAgo);

        //Get timezone information
        ZonedDateTime zonedDateTime = fiveMinutesAgo.atZone(ZoneId.systemDefault());
        System.out.println(" Instance date time with a timezone is "+zonedDateTime);

        // LocalDate - represents System Date and has no time or timezone components
        LocalDate today = LocalDate.now();
        LocalDate sameDayLastMonth = today.minusMonths(1);
        System.out.println("Current Date is :"+today+" and same day last month is "+sameDayLastMonth);

        //LocalDateTime - knows the date and time, but not timezones
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fiveMonthsAgo = now.minusMonths(5);
        System.out.println("Current time is "+now+" and time 5 months ago was "+fiveMonthsAgo);

        // ZonedDateTime - use this when dealing with multiple timezones
        ZonedDateTime currentDateTimeInIndia = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Kolkata"));
        System.out.println("Current time in another timezone is "+currentDateTimeInIndia);

        // ZonedDateTime - when a date/time needs to be the same in the another timezone
        // Ex: When a bill needs to be sent out on a particular day and time in all timezones
        ZonedDateTime sameDateTimeInIndia = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Kolkata"));
        System.out.println(" Date time expressed as the same date/time in another timezone: "+sameDateTimeInIndia);

        // Parsing String dates in Java i.e. converting a string "2023-03-05" to a Date object
        LocalDate parsedLocalDate = LocalDate.parse("2023-03-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Parsed Date: "+parsedLocalDate);
        System.out.println(" Verify its a date, Parsed Date - 5 months is "+parsedLocalDate.minusMonths(5));

    }
}

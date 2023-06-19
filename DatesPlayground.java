import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DatesPlayground
{
    public static void main(String[] args) throws ParseException {

        //Old way to get date and time.
        Date date = new Date();
        System.out.println("Date printed is " + date);

        System.out.println("Epoch time " + date.getTime());

        //If you get a string as a date, use the method below
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("-05:00")));
        Date parsedDate = simpleDateFormat.parse("2023-01-09");
        System.out.println("Parsed Date is "+parsedDate);

        //Instance represents UTC - Latest method
        Instant now = Instant.now();
        System.out.println("The UTC Instant Time is " + now);
        Instant fiveMinsAgo = now.minusSeconds(300);
        System.out.println("The UTC time 5 minutes ago was " + fiveMinsAgo );

        //Get timezone information of an Instant
        ZonedDateTime zonedDateFiveMinsTime = fiveMinsAgo.atZone(ZoneId.systemDefault());
        System.out.println("Instance date, time subtracted, and a timezone: "+zonedDateFiveMinsTime);
        ZonedDateTime zonedDateTimeNow = now.atZone(ZoneId.systemDefault());
        System.out.println("Instance date, the current time, and a timezone: "+zonedDateTimeNow);

        // LocalDate - represents System Date and has no time or timezone components
        LocalDate today = LocalDate.now();
        System.out.println("Current date is "+today+" and 3 years ago is "+today.minusMonths(36));

        //LocalDateTime - knows the date and time, but not timezones
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime threeMonthsAgo = nowTime.minusMonths(3);
        System.out.println("Current time is "+nowTime+" and time 3 months ago was "+ threeMonthsAgo);


        // Parsing String dates in Java i.e. converting a string "2023-05-05" to a Date object
        LocalDate parsedLocalDate = LocalDate.parse("2023-05-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Parsed Date: "+parsedLocalDate);
        System.out.println("Parsed Date 3 months ago is "+parsedLocalDate.minusMonths(3));


        // ZonedDateTime - use this when dealing with multiple timezones
        ZonedDateTime currentDateTimeInIndia = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Kolkata"));
        System.out.println("Current time in another timezone is "+currentDateTimeInIndia);

        // ZonedDateTime - when a date/time needs to be the same in the another timezone
        // Ex: When a bill needs to be sent out on a particular day and time in all timezones
        ZonedDateTime sameDateTimeInIndia = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Kolkata"));
        System.out.println("Date time expressed as the same date/time in another timezone: "+sameDateTimeInIndia);
    }

}

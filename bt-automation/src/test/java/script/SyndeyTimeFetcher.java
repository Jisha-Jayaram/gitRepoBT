package script;

 

import java.time.LocalDateTime;

import java.time.ZoneId;

import java.time.ZonedDateTime;

import java.time.format.DateTimeFormatter;

 

public class SyndeyTimeFetcher {

    public static void main(String[] args) {

        /*

        // Define the time zone for Sydney

        ZoneId sydneyZone = ZoneId.of("Australia/Sydney");

 

        // Get the current time in Sydney

        ZonedDateTime sydneyTime = ZonedDateTime.now(sydneyZone);

        System.out.println(sydneyTime);

        int hours=sydneyTime.getHour();

        int minute=sydneyTime.getMinute();

        System.out.println(hours);

        System.out.println(minute);


        // Define the date and time format

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

 

        // System.out.println(formatter);

 

        // Format and print the Sydney time

        String formattedTime = sydneyTime.format(formatter);

 

        System.out.println("Current time in Sydney: " + formattedTime);

    }

    */


    // Get the current time in Sydney

    LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Australia/Sydney"));

 

    // Add 1 hour to the current time

    LocalDateTime updatedDateTime = currentDateTime.plusHours(1);

//  updatedDateTime.getHour();

    System.out.println(updatedDateTime.getHour());

 

    // Format the updated time

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    String formattedDateTime = updatedDateTime.format(formatter);

 

    // Print the updated Sydney time

    System.out.println("Updated Sydney Time: " + formattedDateTime);

}

 

}

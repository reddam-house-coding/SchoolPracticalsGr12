/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.mysql.cj.result.LocalDateTimeValueFactory;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Cliftonb
 */
public class Test {
    
    
    
    public static void main(String[] args) {
        LocalDateTime t1 = LocalDateTime.now();
        LocalDateTime t3 = LocalDateTime.now().plusDays(5);
        LocalDateTime t2 = t1.plusHours(3);
        
        
        LocalDate t5 = LocalDate.now();
        LocalDate t6 = LocalDate.now();
        
        t1.getHour();
        t1.getMonth();
        t1.getYear();
        t1.getDayOfMonth();
        t1.getDayOfWeek();
        t1.getDayOfYear();
        
        
        
        
        System.out.println(t1.getDayOfWeek().compareTo(t3.getDayOfWeek()));
        
        System.out.println(t2.getDayOfWeek() == t1.getDayOfWeek());
        
        
        System.out.println(t2);
        System.out.println(String.valueOf(t2));
        Period p = Period.between(t1.toLocalDate(), t2.toLocalDate());
        p.getDays();
        p.getMonths();
        Duration d = Duration.between(t1, t2);
        d.getSeconds();
        d.toDays();
        d.toHours();
        
        

        
       System.out.println(d.toHours());
        System.out.println(d.toHoursPart());
        
//       System.out.println(t1.toLocalTime().compareTo(t2.toLocalTime()));;
//        System.out.println(t1.getDayOfWeek().equals(t3.getDayOfWeek()));

        t1.until(t2, ChronoUnit.HOURS);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD");

        LocalTime t = LocalTime.now();
        Date date1 = new Date();


        
    }
}

import javax.swing.*;
import java.util.Date;

public class Main {
    public static void main(String[] args)
    {
        Date d1 = new Date();
        int hour = (int) (d1.getTime()/(1000 * 60 * 60) % 24);
        int minute = (int) (d1.getTime()/(1000 * 60) % 60);
        int second = (int) (d1.getTime()/ 1000 % 60);
        minute += 30;
        if(minute >= 60) hour++;
        minute %= 60;
        hour = (hour + 3) % 24;

        ClockDisplay clock = new ClockDisplay(hour,minute,second);
        for (;;){
            clock.timeTick();
            System.out.println(clock.getTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

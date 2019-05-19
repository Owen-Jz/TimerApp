/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanagement1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;




/**
 *
 * @author ItzNotBrume
 */
public class TimeManagement1 {

    /**
     * @param Panel
     */

    public static boolean check = false;
    public static Timer timerss;
            public static int sec = 60;
            public static int min = 40;
    //Automatically starts to generate new time and updates regularly
    public static void RunningApp(){  
        String run = timemanagement1.MainPage.Timers2.getText();
    }
    
    //Function called when an alarm is called off
    public static void PromptMessage(String mssg) {
        TimerTask task = new TimerTask() {
            public void run() {
                ShowMessage obj = new ShowMessage();
                timemanagement1.ShowMessage.Message.setText(mssg);
                obj.setVisible(true);
            }
        };
        //Timer timer = new Timer("Timer");

        long delay = 10000;
        //timer.schedule(task, delay);
        }
  
    
    public static void startPeriodtimer(){
        timerss = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(sec == 0){ 
                    sec = 60;
                    min--;
                }
                if(min<0){
                    timemanagement1.TimeManagement1.playAlarmSound("C:\\Users\\USER\\Desktop\\TimeManagement1\\bellAlarm.wav");
                    min=0;sec=0;
                    timerss.stop();  
                }
                sec--;
                timemanagement1.MainPage.PeriodTimer1.setText(String.valueOf(min));
                timemanagement1.MainPage.PeriodTimer2.setText(String.valueOf(sec));
            }
        });
        timerss.start();
    }
    
    public static boolean contains(final int[] array, final int key) {
    for (final int i : array) {
        if (i == key) {
            return true;
        }
    }
    return false;
}
    
    //Main function to check if time limits have been reached
    public static void RingIntervals(int hour, int min, int sec){
                            //Loop to check for the next period
                    int[] nums = { 8, 9, 10, 11, 12, 1, 2, 3,4,5,6};
                    String soundPath = "C:\\Users\\USER\\Desktop\\TimeManagement1\\bellAlarm.wav";
                        //Alarm for when period is over
                        
                        if (min == 41 && contains(nums, hour) && sec == 0){
                            MainPage.button1.doClick();

                            
                        }
                        //Alarm for when period is over
                        if (min == 10 && contains(nums, hour) && sec == 0){
                            startPeriodtimer();
                            PromptMessage("Period Over, Next Class");
                            playAlarmSound(soundPath);
                            
                        }
                        //Alarm for when period is over
                        if (min == 0 && contains(nums, hour) && sec == 0){
                            startPeriodtimer();
                            PromptMessage("Period Over, Next Class");
                            playAlarmSound(soundPath);
                            
                        }
                    //Alarm for when break time is starting
                    if (hour == 11 && min == 20 && sec == 0){
                        PromptMessage("Break Time, 20 minutes remaining");
                        playAlarmSound(soundPath);
                        
                    }
                    //Alarm for when break time is ending
                    if (hour == 11 && min == 40){
                        PromptMessage("Break Time Over");
                        playAlarmSound(soundPath);
                    }
                  
    }

    

  
    
    
   //Function to get the current time from the system

    
    public static void GetCurrentTime(JLabel Panel){
        int TimeRun = 0;
            new Thread(){
            String prime;
            public void run(){
                //Loop to continuoisly run to ensure correct time
                while(TimeRun == 0){
                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AMPM = cal.get(Calendar.AM_PM);
                    if(AMPM == 1){
                        prime = "PM";
                    }else{
                        prime = "AM";
                    }
                    String time = String.valueOf(hour)+" : "+String.valueOf(min)+" :  "+String.valueOf(sec) +": "+ prime;
                    Panel.setText(time);
                    RingIntervals(hour, min, sec);
                }
            }
        }.start();
            
    }
    

        //Function called to update the current time
        public static void dates(JLabel obj){
            Date d = new Date();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
            String dateNow = (dateFormatter.format(d));
            obj.setText(dateNow);

    }
        
     
    //Function called to start playing sound when alarm is triggered
    public static void playAlarmSound(String filepath){
        InputStream music;
        try{
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e){
            System.out.println("Error occured");
        }
    }
    
    
    
    //Function called to save a particular entry to the database
    public static void DatabaseWork(String name, int minute, int Second){
        Connection con;
        ResultSet rs;
        Statement st;
        try{
             Class.forName("org.sqlite.JDBC");
             con = DriverManager.getConnection("jdbc:sqlite:TimerSettings.db3");
             st = con.createStatement();
             String query = "INSERT INTO TimerDetails(name, minutes, seconds) "+("VALUES ('"+name+"','"+minute+"','"+Second+"' )");
             System.out.println("\n \n \n Its Done");
             System.out.println(query);
             st.executeUpdate(query);
            System.out.println("Successfull");
         }catch(ClassNotFoundException | SQLException e){
             System.out.println("The error is : "+e);
         }

    };   

  
    

}

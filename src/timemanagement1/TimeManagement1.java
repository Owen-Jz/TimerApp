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
                ShowMessage obj = new ShowMessage();
                timemanagement1.ShowMessage.Message.setText(mssg);
                obj.setVisible(true);
            }
  
    
    public static void startPeriodtimer(){
        timerss = new Timer(1000, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                timemanagement1.MainPage.MainHead.setText("School Session Timer currently running");
                    if(sec == 0){ 
                    sec = 60;
                    min--;
                }
                if(min == 0){
                    min=0;sec=0;
                    timemanagement1.MainPage.PeriodTimer1.setText(String.valueOf(min));
                    timemanagement1.MainPage.PeriodTimer2.setText(String.valueOf(min));
                    timerss.stop();  
                }
                sec--;
                timemanagement1.MainPage.PeriodTimer1.setText(String.valueOf(min));
                timemanagement1.MainPage.PeriodTimer2.setText(String.valueOf(sec));
            }
        });
        timerss.start();
    }

    
    //Main function to check if time limits have been reached
    public static void RingIntervals(int hour, int min, int sec, int millisec){
                            //Loop to check for the next period
                    int[] nums = { 8, 9, 10, 11, 12, 1, 2, 3,4,5,6};
                    String soundPath = "C:\\Users\\USER\\Desktop\\TimeManagement1\\bellAlarm.wav";
                        //Alarm for when period is over
                        for(int i = 0; i < nums.length; i++){

                            if (min == 38 && hour == i && sec == 0 && millisec == 0 ){
                                startPeriodtimer();
                                playAlarmSound(soundPath);
                            }
                            //Alarm for when period is over
                            if (min == 50 && hour == i && sec == 0  && millisec == 0){
                                PromptMessage("Period Over, Next Class");
                                playAlarmSound(soundPath);
                            }
                            //Alarm for when period is over
                            if (min == 30 && hour == i && sec == 0  && millisec == 0){
                                startPeriodtimer();
                                PromptMessage("Period Over, Next Class");
                                playAlarmSound(soundPath);
                            }
                            
                            if (min == 30 && hour == i && sec == 0  && millisec == 0){
                                startPeriodtimer();
                                PromptMessage("Period Over, Next Class");
                                playAlarmSound(soundPath);
                            }
                            
                            if (min == 30 && hour == 11  && sec == 0  && millisec == 0){
                                continue;
                            }
                            
                            if (min == 40 && hour == 11  && sec == 0  && millisec == 0){
                                continue;
                            }
                            if (min == 40 && hour == 1  && sec == 0  && millisec == 0){
                                continue;
                            }
                            
                            if (min == 10 && hour == 2  && sec == 0  && millisec == 0){
                                continue;
                            }


                        //Alarm for when break time is starting
                        if (hour == 11 && min == 20 && sec == 0  && millisec == 0){
                            PromptMessage("Break Time, 20 minutes remaining");
                            playAlarmSound(soundPath);

                        }
                        //Alarm for when break time is ending
                        if (hour == 11 && min == 40 && sec == 0  && millisec == 0){
                            PromptMessage("Break Time Over");
                            playAlarmSound(soundPath);
                        }                        
                        
                        }
                  
    }

    

  
    
    
   //Function to get the current time from the system

    
        public static void RingIntervalsStarter(){
        int TimeRun = 0;
            new Thread(){
            String prime;
            public void run(){
                while(TimeRun == 0){
                    
                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int millisec = cal.get(Calendar.MILLISECOND);
                    RingIntervals(hour, min, sec, millisec);
                }
            }
        }.start();
            
    }
    
    
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
                    int millisec = cal.get(Calendar.MILLISECOND);
                    int AMPM = cal.get(Calendar.AM_PM);
                    if(AMPM == 1){
                        prime = "PM";
                    }else{
                        prime = "AM";
                    }
                    String time = String.valueOf(hour)+" : "+String.valueOf(min)+" :  "+String.valueOf(sec) +": "+ prime;
                    Panel.setText(time);
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
    
    
    public static void DatabaseDelete(String name){
        Connection con;
        ResultSet rs;
        Statement st;
        try{
             Class.forName("org.sqlite.JDBC");
             con = DriverManager.getConnection("jdbc:sqlite:TimerSettings.db3");
             st = con.createStatement();
             String query = ("DELETEFROM TIMERDETAILS WHERE name = "+name);
             st.executeQuery(query);
            System.out.println("Successfull");
         }catch(ClassNotFoundException | SQLException e){
             System.out.println("The error is : "+e);
         }

    };   

  

  
    

}

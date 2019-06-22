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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    //Automatically starts to generate new time and updates regularly
    public static void RunningApp(){  
        String run = timemanagement1.MainPage.Timers2.getText();
    }
    
    
    public static void startPeriodtimer(int min, int sec){
        timerss = new Timer(1000, new ActionListener(){
        int tmin = min;
        int tsec = sec;
            @Override
            public void actionPerformed(ActionEvent e) {
                timemanagement1.MainPage.MainHead.setText("School Session Timer currently running");
                    if(tsec == 0){ 
                    tsec = 60;
                    tmin--;
                }
                if(min == 0){
                    tmin=0;tsec=0;
                    timemanagement1.MainPage.PeriodTimer1.setText(String.valueOf(00));
                    timemanagement1.MainPage.PeriodTimer2.setText(String.valueOf(00));
                    timerss.stop();  
                }
                tsec--;
                timemanagement1.MainPage.PeriodTimer1.setText(String.valueOf(tmin));
                timemanagement1.MainPage.PeriodTimer2.setText(String.valueOf(tsec));
                timemanagement1.Minimized.PeriodTimer1.setText(String.valueOf(tmin));
                timemanagement1.Minimized.PeriodTimer2.setText(String.valueOf(tsec));

            }
        });
        timerss.stop();
        timemanagement1.MainPage.PeriodTimer1.setText("00");
        timemanagement1.MainPage.PeriodTimer2.setText("00");
        timerss.start();
    }

    
    //Main function to check if time limits have been reached
    public static void RingIntervals(int hour, int min, int sec, int millisec){
                     //Loop to check for the next period
                    String soundPath = "C:\\Users\\USER\\Desktop\\TimerApp\\src\\timemanagement1\\Music\\bellAlarm.wav";
                    //Alarm for when period is over
                    if (hour == 11 && min == 47 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 8 && min == 40 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 9 && min == 20 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 10 && min == 00 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 10 && min == 40 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 12 && min == 20 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 5 && min == 00 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 1 && min == 40 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 2 && min == 10 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 2 && min == 50 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }

                    
                    //Special cases
                    if (hour == 11 && min == 20 && sec == 0  && millisec == 0){
                        startPeriodtimer(20, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 11 && min == 40 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 1 && min == 40 && sec == 0  && millisec == 0){
                        startPeriodtimer(30, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 2 && min == 10 && sec == 0  && millisec == 0){
                        startPeriodtimer(40, 00);
                        playAlarmSound(soundPath);
                    }
                    if (hour == 3 && min == 30 && sec == 0  && millisec == 0){
                        playAlarmSound(soundPath);
                        JOptionPane.showMessageDialog(null,"Break time");
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

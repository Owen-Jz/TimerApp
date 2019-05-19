/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanagement1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import static timemanagement1.AddTimer.Minute;
import static timemanagement1.AddTimer.Second;
import static timemanagement1.AddTimer.wert;

/**
 *
 * @author ItzNotBrume
 */
public class ClockUltimate {
    public static void timer(JTextField timerName, JComboBox Second, JComboBox Minute){
        Timer timer;
        String name = timerName.getText();
        timemanagement1.MainPage.Timers2.setText(name);
        int sec = Integer.parseInt(Second.getSelectedItem().toString());
        int min = Integer.parseInt(Minute.getSelectedItem().toString());
        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int threadsec = sec;
                int threadmin = min;
                if(threadsec == 0){
                    threadsec = 60;
                    threadmin--;
                }
                if(min<0){
                    timemanagement1.TimeManagement1.playAlarmSound("C:\\Users\\USER\\Desktop\\TimeManagement1\\Plays.wav");
                    threadmin=0;threadsec=0;
                    //timer.stop();
                    
                }
                threadsec--;
                wert.setText(String.valueOf(min) + ":" +String.valueOf(sec));//timemanagement1.MainPage.Timers1.setText(String.valueOf(sec));
                timemanagement1.MainPage.MainMinute.setText(String.valueOf(min));
                timemanagement1.MainPage.MainSecond.setText(String.valueOf(sec));
            }
        });
        timer.start();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanagement1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author ItzNotBrume
 */


public class NextPeriodTimer {
 static int min;
 static int sec;
 static int periodMin = 40;
 public static int periodSec= 60;   
public static boolean checker = true;
static Timer timer;

    
    public static void StartTimer(){
      timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello world");
                
                                //Minute and seconds counter to make the timer

                if(periodSec == 0){ 
                    sec = 60;
                    min--;
                }
                if(periodMin<0){
                    //timemanagement1.MainPage.MainMinute.setText(String.valueOf(min));
                    System.out.println(min);
                    periodMin=40;periodSec=60;  
                }
                
                //timemanagement1.MainPage.PeriodTimer1.setText(String.valueOf(periodMin));
                //timemanagement1.MainPage.PeriodTimer2.setText(String.valueOf(periodSec));
                periodSec--; 
                System.out.println(periodMin+ ":"+periodSec);
            } 
        });
        timer.start();
        System.out.println("Hello app");
    }
    
    public static void main(String[] args) {
        StartTimer();
        System.out.println(min);
    }
 }

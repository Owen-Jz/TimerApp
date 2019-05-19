/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanagement1;

/**
 *
 * @author ItzNotBrume
 */

public class Counter{

    /**
     *
     

    int sec = Integer.parseInt(timemanagement1.AddTimer.Second.getSelectedItem().toString());
    int min= Integer.parseInt(timemanagement1.AddTimer.Minute.getSelectedItem().toString());
    int hour = Integer.parseInt(timemanagement1.AddTimer.Hour.getSelectedItem().toString());
    

    Timer time = new Timer();
    TimerTask task = new TimerTask(){
        public void run(){
                System.out.println(sec);
                timemanagement1.MainPage.Timers2.setText(String.valueOf(sec));
                if (sec != 0){
                    sec--;
                    if(min >0){
                        sec--;
                    }
                }
                if(sec == -1){
                    task.cancel();
                    timemanagement1.MainPage.Timers2.setText("Task Complete");
                }
        }
    };
    
    public void start(){
        time.schedule(task, 1000, 1000);
    }
   
   * */
    
    
    public static void main(String[] args){
        
    }
}


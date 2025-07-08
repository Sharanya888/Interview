package com.shaninfotech.InterviewApp.Interview;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
InterviewScheduler scheduler = new InterviewScheduler();
		
		scheduler.scheduleInterview(new Interview(1, "Sharanya",99,"11:11 AM"));
		scheduler.scheduleInterview(new Interview(2, "Smrithi",80,"11:30 AM"));
		scheduler.scheduleInterview(new Interview(3, "Nithin",60,"12:00 AM"));
		
		
		scheduler.walkInCandidate(new Interview(4, "Yathin", 77,"NOW"));
		
		System.out.println("\nFULL SCHEDULE");
		scheduler.displaySchedule();
		
		System.out.println("\nWALK-IN");
		scheduler.displayWalkIns();
		
		System.out.println("\nTOP PERFORMERS (Score > 70)");
		scheduler.displayTopScorers(70);
        
    }
}

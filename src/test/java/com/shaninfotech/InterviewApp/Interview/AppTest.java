package com.shaninfotech.InterviewApp.Interview;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class AppTest {
	
     InterviewScheduler scheduler;
	

    @BeforeEach
    void setup() {
    	 scheduler = new InterviewScheduler();
    	 scheduler.scheduleInterview(new Interview(1,"Sharanya",99,"11:11 AM"));
     	scheduler.scheduleInterview(new Interview(2, "Smrithi",80,"11:30 AM"));
 		scheduler.scheduleInterview(new Interview(3, "Nithin",60,"12:00 AM"));
 		
 		scheduler.walkInCandidate(new Interview(4, "Yathin", 77,"NOW"));
    }
    
    @Test
    public void shouldAnswerWithTrue() {
    	
		
		assertEquals("Sharanya", scheduler.scheduleQueue.peek().getCandidateName()); //FIFO Test
		assertEquals("Yathin", scheduler.walkInDeque.peekFirst().getCandidateName()); // Walk-In
		assertEquals("Sharanya", scheduler.topperformersQueue.peek().getCandidateName()); // Top
        
       
    }
    @Test
    void testSchedulerCoreFlow() {
    	List<String> expectedName = Arrays.asList("Sharanya","Smrithi","Yathin");
    	
    	List<String> topScorers = scheduler.topperformersQueue.stream()
    			.filter(i -> i.getScore() > 70)
    			.map(Interview::getCandidateName)
    			.sorted()
    			.toList();
    	
    	assertEquals(expectedName, topScorers);
    	
    }
     //this is used for cleaning the above  constructor after completing the work
    public void tearDown() {
    	scheduler=null;
    }
}
   

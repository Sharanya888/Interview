package com.shaninfotech.InterviewApp.Interview;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;




public class AppTest {
	InterviewScheduler scheduler = new InterviewScheduler();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
    	scheduler.scheduleInterview(new Interview(1,"Sharanya",99,"11:11 AM"));
    	scheduler.scheduleInterview(new Interview(2, "Smrithi",80,"11:30 AM"));
		scheduler.scheduleInterview(new Interview(3, "Nithin",60,"12:00 AM"));
		
		scheduler.walkInCandidate(new Interview(4, "Yathin", 77,"NOW"));
		
		assertEquals("Sharanya", scheduler.scheduleQueue.peek().getCandidateName()); //FIFO Test
		assertEquals("Yathin", scheduler.walkInDeque.peekFirst().getCandidateName()); // Walk-In
		assertEquals("Sharanya", scheduler.topperformersQueue.peek().getCandidateName()); // Top
        
       
    }
   // @Test
//  void testTopScorersAbove70() {
//  	List<String> expectedNames = Arrays.asList("Sharanya","Yathin","Subbu");
//  	
//  	List<String> topScorers = scheduler.topperformersQueue.stream()
//  			.filter(i -> i.getScore() > 70)
//  			.map(Interview::getCandidateName)
//  			.sorted()
//  			.toList();
//  	
//  	assertEquals(expectedNames, topScorers);
//  }
}

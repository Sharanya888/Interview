package com.shaninfotech.InterviewApp.Interview;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class InterviewScheduler {
	public Queue<Interview> scheduleQueue = new LinkedList<Interview>();
	public Deque<Interview> walkInDeque =  new ArrayDeque<Interview>();
	public PriorityQueue<Interview> topperformersQueue = new PriorityQueue<Interview>(
	(a,b) -> Integer.compare(b.getScore(), a.getScore())
			);
	
	public void scheduleInterview(Interview i) {
		scheduleQueue.offer(i);
		topperformersQueue.offer(i);
		
	}
	
	public void walkInCandidate(Interview i) {
		walkInDeque.addFirst(i); // urgent walk-in
		topperformersQueue.offer(i);
	}
	public void displaySchedule() {
		System.out.println("Schedule Interview (FIFO) :");
		scheduleQueue.forEach(System.out::println);
	}
	
	public void displayWalkIns() {
		System.out.println("Walk In  Candidates  (Deque) :");
		walkInDeque.forEach(System.out::println);
	}
	
	public void displayTopScorers(int threshold) {
		System.out.println("Shortlisted Candidates (score >"+ threshold+")");
		topperformersQueue.stream()
		.filter(i -> i.getScore() > threshold)
		.sorted(Comparator.comparing(Interview::getCandidateName))
		.forEach(System.out::println);
	}
	
	

}

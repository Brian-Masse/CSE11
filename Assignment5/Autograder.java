// Main Class File:    Assignment5
// File:               Ticket.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * The AutoGrader is the public interface to a course's ticket Queue
 * It does not implement its own logic, but rather exposes the logic of the
 * Queue Object
 * @author Brian Masse
 */
public class Autograder{
    // MARK: Vars
    private String course;
    private Queue queue;

    public Autograder() {
        this.course = null;
        this.queue = null;
    }

    public Autograder(String course, int queueCapacity) {
        this.course = course;
        this.queue = new Queue(queueCapacity);
    }

    // MARK: methods
    /**
     * adds the provided ticket to the end of the queue
     * returns if the queue is locked or is empty
     * uses the queue.enqueue method
     * @param Ticket: the ticket to add to the end of the queue
     */
    public void submitTicket(Ticket ticket) {
        this.queue.enqueue(ticket);
    }

    /**
     * retreives & removes the first ticket in the queue
     * always unlocks the queue
     * returns null if the queue is empty or null
     * uses the queue.dequeue method
     * @return String: the description of the retrieved ticket
     */
    public String resolveNextTicket() {
        Ticket retrievedTicket = queue.dequeue();
        if (retrievedTicket == null) { return null; }

        String details = this.getTicketDetails(retrievedTicket);
        return details;
    }

    /**
     * retreieves the first ticket in the queue without removing it
     * returns null if the queue is emtpy or null
     * uses the queue.peek() method
     * @return String: the description of the retrieved ticket
     */
    public String viewNextTicket() {
        Ticket retrievedTicket = queue.peek();
        if (retrievedTicket == null) { return null; }
        
        String details = this.getTicketDetails(retrievedTicket);
        return details;
    }

    /**
     * checks whether the queue is locked
     * @return boolean: whether the current queue is locked or not
     */
    public boolean isQueueLocked() {
        return queue.isLocked();
    }

    /**
     * returns the average wait time of all the tickets in the queue
     * returns 0 if there are no tickets
     * @return int: the average wait time for a ticket in the queue
     */
    public int getAvgWait(int[] currentTime) {
        int averageWait = queue.avgWait(currentTime);
        return averageWait;
    }


    // MARK: Provied Methods
    public String getTicketDetails(Ticket ticket) {
        return ("Student Name: " + ticket.getStudentName()+ "\n" +
                "Submitted at: " + ticket.getTimeStamp()[0] + ":" + 
                ticket.getTimeStamp()[1] + "\n" +
                "Location: " + ticket.getLocation() + "\n" +
                "Description: " + ticket.getDescription());
    }

    public void getAutograderDetails(int[] currentTime) {
        System.out.println("Welcome to " + this.course + " Autograder!" + "\n"+
                           "Tickets in the queue: " + queue.size());
        if (this.queue.isLocked()){
            System.out.println("Queue is locked!!");
            return;
        } else {
            System.out.println("Queue is open! Average wait for a new ticket is"
                               + " " + getAvgWait(currentTime) + " minutes.");
        }
    }

}
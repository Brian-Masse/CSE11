// Main Class File:    Assignment5
// File:               Ticket.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * The Queue class represents the current queue of student submitted help tickets
 * It is modleded after a FIFO stack
 * @author Brian Masse
 */
public class Queue {

    // MARK: Vars
    private int capacity;
    private int size; 
    private Ticket[] ticketQueue; 
    private boolean isLocked;

    private static final String EMPTY_Q_ERROR = "queue is empty";
    private static final String LOCKED_Q_ERROR = "queue is locked!!";

    // MARK: Constsructors
    public Queue() {
        this.capacity = 0;
        this.size = 0;
        this.ticketQueue = null;
        this.isLocked = false;
    }

    public Queue(int capacity) {
        if (capacity <= 0) { new Queue(); }
        else {
            this.capacity = capacity;
            this.size = 0;
            this.ticketQueue = new Ticket[capacity];
            this.isLocked = false;
        }
    }

    // MARK: Methods
    /**
     * adds the provided ticket to the end of the queue and increments its size
     * returns if the queue is locked or is empty
     * @param Ticket: the ticket to add to the end of the queue
     */
    public void enqueue(Ticket ticket) {
        if (this.isLocked) {
            System.out.println( Queue.LOCKED_Q_ERROR );
            return;
        } else if (this.ticketQueue == null) {
            System.out.println( Queue.EMPTY_Q_ERROR );
            return;
        }

        this.ticketQueue[size] = ticket;
        this.size ++;
        if (this.size >= this.capacity) { this.isLocked = true; }
    }

    /**
     * retreives & removes the first ticket in the queue
     * then shifts all remaining tickets forward in the queue
     * always unlocks the queue
     * returns null if the queue is empty or null
     * @return Ticket: the Ticket at the front of the queue
     */
    public Ticket dequeue() {
        Ticket retreivedTicket = this.peek();
        if (retreivedTicket == null) { return null; }
        this.size --;
        
        for (int i=1; i<size+1; i++ ) {
            this.ticketQueue[ i - 1 ] = this.ticketQueue[i];
        }
         
        this.isLocked = false;
        return retreivedTicket;
    }

    /**
     * retreieves the first ticket in the queue without removing it
     * returns null if the queue is emtpy or null
     * @return Ticket: the ticket at the front of the queue
     */
    public Ticket peek() {
        if (this.ticketQueue == null || this.ticketQueue[0] == null) {
            System.out.println(EMPTY_Q_ERROR);
            return null;
        }

        Ticket retreivedTicket = ticketQueue[0];
        return retreivedTicket;
    }

    /**
     * gets the current size of the queue
     * represents how many non-empty tickets there are in the queue
     * size is automatically managed in the enqueue and dequeue methods
     * @return int: the number of non-empty tickets
     */
    public int size() {
        return this.size;
    }

    /**
     * returns the average wait time of all the tickets in the queue
     * returns 0 if there are no tickets
     * @return int: the average wait time for a ticket in the queue
     */
    public int avgWait(int[] currentTime) {
        if (this.size() == 0) { return 0; }
        double sum = 0;

        for( int i =0; i < this.size; i++ ) {
            Ticket ticket = this.ticketQueue[i];
            sum += ticket.totalWait(currentTime);
        }

        double average = sum / this.size;
        return (int) average;
    }

    /**
     * returns the isLocked variable
     * @return boolean: whether the current queue is locked or not
     */
    public boolean isLocked() {
        return isLocked;
    }
}
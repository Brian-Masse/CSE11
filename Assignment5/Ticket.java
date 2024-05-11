// Main Class File:    Assignment5
// File:               Ticket.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * The ticket class represents student submitted tickets
 * Containst the properties of a support ticket
 * @author Brian Masse
 */
public class Ticket {

    // MARK: Vars
    private static final int TIME_FORMAT = 3; 
    private static final int MIN_IN_HOUR = 60; //number of minutes in an hour

    private String studentName; 
    private int[] timeStamp;
    private String location;
    private String description;
    private boolean debugging;  

    // MARK: Constructors
    public Ticket() {      
        this.studentName = null;
        this.timeStamp = new int[] {0,0,0};
        this.location = null;
        this.description = null;
        this.debugging = false;
    }

    public Ticket(String studentName, 
                  int[] timeStamp,
                  String location,
                  String description, 
                  boolean debugging) {
        this.studentName = studentName;
        this.timeStamp = new int[Ticket.TIME_FORMAT];
        this.location = location;
        this.description = description;
        this.debugging = debugging;

        for (int i = 0; i < Ticket.TIME_FORMAT; i++) {
            this.timeStamp[i] = timeStamp[i];
        }
    }

    // MARK: Convenience Functions
    /**
     * gets the studentName
     * @return String: the studentName var
     */
    public String getStudentName() {  
        return studentName;
    }

    /**
     * returns a copy of the timeStamp
     * @return int[]: a reference to a copy of the timeStamp var
     */
    public int[] getTimeStamp() {  
        int[] newTimeStamp = new int[Ticket.TIME_FORMAT];
        for (int i = 0; i < Ticket.TIME_FORMAT; i++ ) {
            newTimeStamp[i] = this.timeStamp[i];
        }
        return newTimeStamp;
    }

    /**
     * returns the location
     * @return String: the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * returns the description
     * @return String: the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns whether the ticket is for debugging
     * @return boolean: the isDebugging variable
     */
    public boolean isDebugging() {
        return debugging;
    }

    /**
     * sets the studentName to a new value
     * @param String: the new studentName value
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * sets the timeStamp to a copy of the passed list
     * @param int[]: the new timeStamp to copy
     */
    public void setTimeStamp(int[] timeStamp) {
        for (int i = 0; i< Ticket.TIME_FORMAT; i++) {
            this.timeStamp[i] = timeStamp[i];
        }
    }

    /**
     * sets the location to a new value
     * @param String: the new location value
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * sets the description to a new value
     * @param String: the new description value
     */
    public void setDescripton(String description) {
        this.description = description;
    }

    /**
     * sets the isDebugging var to a new value
     * @param boolean: the new isDebugging value
     */
    public void setDebugging(boolean debugging) {
        this.debugging = debugging;
    }

    // MARK: Methods
    /**
     * returns the number of minutes a ticket has been in the queue,
     * based on the value of the current time
     * @param int[]: the currentTime, in 3 digit timeStamp
     * @return the number of minutes from the timeStamp and the current time
     */
    public int totalWait(int[] currentTime) {
        int currentHours = currentTime[0];
        int currentMinutes = currentTime[1];
        int currentTimeInMinutes = (currentHours * Ticket.MIN_IN_HOUR) + currentMinutes;

        int timeStampHours = this.timeStamp[0];
        int timeStampMinutes = this.timeStamp[1];
        int timeStampTimeInMinutes = ( timeStampHours * Ticket.MIN_IN_HOUR ) + timeStampMinutes;

        return currentTimeInMinutes - timeStampTimeInMinutes;
    }
}
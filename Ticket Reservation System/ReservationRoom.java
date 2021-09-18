import java.util.Date;
import java.util.List;
import java.util.Queue;

public class ReservationRoom {
    
}

enum PaymentStatus {
    COMPLETED , FAILED
}

enum QueueStatus {
    FULL , NON_OPERATIONAL , AVAILABLE
}

class ReservationHall {
    static Integer hallCapacity;
    Integer hallId;
    Address adress;
    List<BookingQueue> bookingQueues;
    Reception receptionist;
}

class Address {
    String place;
    String area;
    String pinCode;
}

abstract class Person {
    String name;
    String details;
}

class Reception extends Person{
    List<Guest> guestLogs;
    Queue<Guest> waitingLine;

    public void registerGuest(){
        Guest guest  = new Guest();
        guestLogs.add(guest);
    }

    public boolean isHallFull(ReservationHall hall){
        for(BookingQueue queue : hall.bookingQueues) {
            if(queue.status == QueueStatus.AVAILABLE){
                return false;
            } 
        }

        return true;
    }

    public void processWaitingLine() {
        if(isHallFull(new ReservationHall())) {
            waitingLine.add(new Guest());
        } else {
            // Check which BookingQueue has more space available 
            //Find booking queue with most available space
            BookingQueue bookingQueue = new BookingQueue();
            //Allot guest to the queue
            bookingQueue.allotToGuest(new Guest());
        }
    }


}


class BookingQueue {
    BookingAgent agent;
    Integer queueCapacity;
    Queue<Guest> guests;
    QueueStatus status;

    public void allotToGuest(Guest guest) {
        guests.add(guest);

    }

    public void forwardGuestToCounter(){
        agent.bookTicket(guests.peek());
        guests.poll();
    }

    public void changeQueueStatus(){
        if(guests.size() == queueCapacity){
            status = QueueStatus.FULL;
        } else {
            status = QueueStatus.AVAILABLE;
        }

    }
}

class BookingAgent {

    public Ticket bookTicket(Guest guest){
        // Book ticket based on form filled by the guest
        Form guestForm = guest.formDetails;
        return new Ticket();

    }

    public void acceptPayment(Guest guest){
        Ticket generatedTicket = bookTicket(guest);
        guest.makePayment(generatedTicket);

    }

}

class Ticket {
    Integer ticketId;
    List<Guest> passengers;
    ReservationDetails resDetails;
    PaymentStatus status;
}

class ReservationDetails {
    String from;
    String to;
    String paymentNumber;
    Date time_of_booking;
    Date date_of_journey;
    Double totalAmount;
}

class Guest extends Person {
    Form formDetails;
    public void makePayment(Ticket ticket){
        String paymentNum = ticket.resDetails.paymentNumber;
        //Make payment based on payment Number

    }
}

class Form {
    String fields;
}




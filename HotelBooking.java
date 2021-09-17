import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HotelBooking {

}

enum PaymentStatus {
    DONE , NOT_DONE
}


enum RoomStatus{
    OCCUPIED , NOT_OCCUPIED , NOT_AVAILABLE , RESERVED
}

enum RoomType{
    DELUX , AC_DELUX , NORMAL
}

enum BookingStatus {
    BOOKED , CANCELLED
}

class Hotel {
     Integer hotel_id;
     String name;
     Address address;
     List<Room> rooms;
}

class Address {
     String house;
     String locality;
     String pinCode;
}

class Room {
     Integer room_id;
     RoomStatus status;
     Double price;
     Integer capacity;
     RoomType roomType;
}


abstract class Person {
     String name;
     String phoneNumber;
     String userName;
     String password;
}

class User extends Person {
     List<Booking> bookings;

    public List<Hotel> searchHotel(String name , String area , String pinCode){
        //Search Hotels Logic

        return new ArrayList<Hotel>();
    }

    public Booking bookRoomsInAHotel(Hotel hotel , Room room) {
        //Booking Rooms in a hotel logic
        return new Booking();
    }

    public void cancelBooking(Booking booking){
        // Cancel Booking Logic
    }
}

class Booking {
     Integer bookingId;
     Integer userId;
     Integer hotelId;
     List<Room> bookedRooms;
     Integer amount;
     BookingStatus bookingStatus;
     PaymentStatus paymentStatus;
     Date timeOfBooking;

     public void notifyUser(User user){
         Notifications notifications = new Notifications();
         notifications.notify(user);

     }

}


class SuperAdmin extends Person {

     List<Hotel> hotels;

    public void addHotel(Hotel hotel){
             //Adding Hotels Logic

    }

    public void addRoomInHotel(Hotel hotel , Room room){
             //Adding rooms in a hotel Logic

    }

    public void editHotelDetails(Hotel hotel){
        //Edit HotelDetails Logic
    }

    public void editRoomDetails(Room room) {
           //Edit Room Details Logic
    }
}

class Notifications {

    public void notify(User userDetails){
        // Call Notification Api
    }

}




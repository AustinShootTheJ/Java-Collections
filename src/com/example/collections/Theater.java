package com.example.collections;

import java.util.*;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows -1);
        for(char row = 'A'; row <= lastRow; row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                double price = 12.00;

                if((row < 'D') && (seatNum >= 4) && (seatNum <=9)){
                    price = 14.00;
                }else if((row > 'F') || (seatNum <4 || seatNum >9)){
                    price = 7.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }


    // using a binary search our program checks the element in the middle of the list first
    // it then compares if the item is higher or lower and only searches that half of the list.
    // it cuts that half in half again and repeats the process thus reducing the number of checks necessary.
    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0 );
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if(foundSeat >=0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        // code replaced by binary search tree.
//        for(Seat seat : seats){
//            System.out.println(".");
//            if(seat.getSeatNumber().equals(seatNumber)){
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if(requestedSeat == null){
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//        return requestedSeat.reserve();
    }



    public Collection<Seat> getSeats(){
            return seats;
        }


    // we implement comparable to lay the ground work for binary search trees.
    // by using a search tree our program will be able to search for seats more efficiently
    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareTo(seat.getSeatNumber());
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }else{
                return false;
            }
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            }else{
                return false;
            }
        }

        public String getSeatNumber() {

            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }


}

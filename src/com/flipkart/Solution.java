package com.flipkart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        CabBooking cabBooking = new CabBooking();
        //System.out.println(args[0]);
        Scanner reader = new Scanner(System.in);
        while(reader.hasNextLine()) {
            cabBooking.Command(reader.nextLine());
        }
    }
}

class CabBooking {
    Map<String,List<Vehicle>> cityMap;
    Set<Vehicle> allVehicles = new HashSet<>();
    {
        command.add("add_city");
        command.add("add_vehicle");
        command.add("rent_vehicle");
        command.add("end_trip");
        command.add("print_status");
    }
    CabBooking() {
        cityMap = new HashMap<>();
    }
    public static final HashSet<String> command = new HashSet<>();
    public void Command(String command){
        String[] cmdArr = command.split(" ");
        if(cmdArr[0].equals("print_status")) {
            print_status(cmdArr);
            return;
        }

        switch (cmdArr[0]) {
            case "add_city":
                System.out.println(add_city(cmdArr));
                break;
            case "add_vehicle":
                System.out.println(add_vehicle(cmdArr));
                break;
            case "rent_vehicle":
                System.out.println (rent_vehicle(cmdArr));
                break;
            case "end_trip":
                System.out.println( end_trip(cmdArr));
                break;
             default:
                 System.out.println(Response.ERROR.name());
        }
    }

    private void print_status(String[] cmdArr) {
        if(Objects.equals(cmdArr[1], "city")) {
            print_status_city(cmdArr[2]);
        } else if (Objects.equals(cmdArr[1], "world")) {
            for (Map.Entry entry: cityMap.entrySet()) {
                print_status_city(entry.getKey().toString());
            }
        }
    }

    private void print_status_city(String city) {
        //if(cityMap.get(city)!= null) {
            List<Vehicle> idleVehicles = new ArrayList<>();
            List<Vehicle> onTripVehicles = new ArrayList<>();

            Map<String,Integer> result = new HashMap<>();
            result.put(Status.IDLE.name(), 0);
            result.put(Status.ON_TRIP.name(), 0);
            for (Vehicle v:cityMap.get(city)) {
                result.put(v.getStatus().name(), result.get(v.getStatus().name()) + 1);
            }
            for (Map.Entry entry: result.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        //} else {
           // System.out.println (Response.ERROR.name());
        //}
    }

    private String end_trip(String[] cmdArr) {
        Vehicle temp = allVehicles.stream()
                .filter(vehicle ->
                        vehicle.getStatus().equals(Status.ON_TRIP) && vehicle.getNumberPlate().equals(cmdArr[1]))
                .findAny().orElse(null);

        if(temp == null) {
            return Response.ERROR.name();
        } else {
            temp.setStatus(Status.IDLE);
            Trip trip = temp.getTripInfo();
            temp.setTripInfo(null);
            cityMap.get(trip.getFromCity()).removeIf(v -> v.getNumberPlate().equals(temp.numberPlate));
            cityMap.get(trip.getToCity()).add(temp);
            return Response.OK.name();
        }
    }

    private String rent_vehicle(String[] cmdArr) {
        List<Vehicle> fromVehicleList = cityMap.get(cmdArr[1]);
        if(fromVehicleList.isEmpty()) {
            return Response.ERROR.name();
        }

        Vehicle rentedVehicle = fromVehicleList.stream()
                .filter(vehicle -> vehicle.getStatus().equals(Status.IDLE))
                .findAny().orElse(null);
        if(rentedVehicle == null) {
            return Response.ERROR.name();
        }
        Trip trip = new Trip();
        trip.setFromCity(cmdArr[1]);
        trip.setToCity(cmdArr[2]);
        rentedVehicle.setStatus(Status.ON_TRIP);
        rentedVehicle.setTripInfo(trip);
        return Response.OK.name() + " " + rentedVehicle.getNumberPlate();
    }

    private String add_vehicle(String[] cmdArr) {
        return add_city(cmdArr);
    }

    private String add_city(String[] cmdArr) {
        List<Vehicle> vehicleList = new ArrayList<>();
        Vehicle temp;
        for (int i = 3; i < cmdArr.length; i++) {
            temp = new Vehicle(Status.IDLE,cmdArr[i]);
            allVehicles.add(temp);
            vehicleList.add(temp);
        }

        if(cityMap.containsKey(cmdArr[1])) {
               cityMap.get(cmdArr[1]).addAll(vehicleList);
       } else {
           cityMap.put(cmdArr[1], vehicleList);
       }
       return Response.OK.name();
    }
}
class Vehicle {
    Status status;
    String numberPlate;
    Trip tripInfo;

    public Vehicle(Status status, String numberPlate) {
        this.status = status;
        this.numberPlate = numberPlate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Trip getTripInfo() {
        return tripInfo;
    }

    public void setTripInfo(Trip tripInfo) {
        this.tripInfo = tripInfo;
    }
}
class Trip {
    String fromCity;
    String toCity;

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }
}

enum Status {
   IDLE,
   ON_TRIP
}

enum Response {
    ERROR,
    OK
}
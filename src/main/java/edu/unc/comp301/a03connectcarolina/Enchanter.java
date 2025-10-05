package edu.unc.comp301.a03connectcarolina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enchanter {
    private Map<String, String> cleEvents = new HashMap<>();

    public void initCalendar(){
        cleEvents.put("August 18", "Fall FDOC");
        cleEvents.put("September 05", "Honor Code Workshop");
        cleEvents.put("October 12", "Leadership Summit");
        cleEvents.put("November 03", "Community Service Night");
        cleEvents.put("December 01", "Study Skills Clinic");
        cleEvents.put("January 19", "Nani Bday");
        cleEvents.put("February 23", "Code Camp Python");

    }

    public Enchanter(){
        initCalendar();
    }

    public void validateScan(String name, List<String> scannedEvents) throws CLEAlreadyScannedException, CLEEventNotFoundException{
        if (!cleEvents.containsValue(name)){
            throw new CLEEventNotFoundException("CLE Event not found!");
        }
        else if(scannedEvents.contains(name)){
            throw new CLEAlreadyScannedException("CLE Event already scanned");

        }
    }

    public List<String> getCLECredits(String name, List<String> scannedEvents) throws CLEEventNotFoundException, CLEAlreadyScannedException{
        if (scannedEvents == null){
            return new ArrayList<>();
        }

        try{
            validateScan(name, scannedEvents);
            System.out.println("Thank you for attending!");
        }

        catch(CLEAlreadyScannedException | CLEEventNotFoundException error1){
            System.out.println("Error scanning event");
        }

        System.out.println("CLE credit processed for: " + name);
        return scannedEvents;

    }
}




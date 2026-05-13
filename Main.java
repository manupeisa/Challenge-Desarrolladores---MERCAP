import java.util.List;


class Bill{
    private double monthlyFee;  
    private List<PhoneCall> calls;


    public Bill(double monthlyFee , List<PhoneCall> calls){
        this.monthlyFee = monthlyFee;
        this.calls = calls;
    }

    public double calculateFee(){
        double total = monthlyFee;

        for( PhoneCall call : calls){
            total += call.calculateCost() ;
        }

        return total;
    }
}

abstract class PhoneCall {
    int durationTime; // duration time will be modeled in minutes so it's easier to calculate the fee 

    public abstract double calculateCost(); // i use polimorfism so i name it here and i define by cases in the calls 
    
}

class LocalCall extends PhoneCall {
    int startTime; // Because durationTime is model in minutes i use the same time unit.
    boolean isWeekend;
    
    @Override 
    public double calculateCost(){
        
        if (isWeekend){
            return durationTime * 0.10; 

        }
        int endTime = startTime + durationTime ;
        int peakStart = 480;
        int peakFinish = 1200;

        int overlapStart; //OverlapStart will be the higest number 
        if(startTime > peakStart) overlapStart = startTime;
        else overlapStart = peakStart;

        int overlapEnd; //OverlapStart will be the lowest number 
        if( endTime < peakFinish) overlapEnd = endTime;
        else overlapEnd = peakFinish; 

        int peakMinutes;
        if (overlapEnd > overlapStart) peakMinutes = overlapEnd - overlapStart;
        else peakMinutes = 0;

        int offPeakMinutes = durationTime - peakMinutes;
        return peakMinutes * 0.20 + offPeakMinutes * 0.10; 

    }
}
//Start = 420 && duration = 80 endtime = 500 -> 480 - 420 = 60 * 0.10 + 500 - 480 = 20 * 0.20

class InternationalCall extends PhoneCall {
    String country; 
    double ratePerMinute; // each contry has it's own rate 

    @Override 
    public double calculateCost(){
        return ratePerMinute * durationTime ;
    }
     
}

class NationalCall extends PhoneCall {
    String city;
    double ratePerMinute; // each city has it's own rate 

    @Override 
    public double calculateCost(){
        return ratePerMinute * durationTime; 
    }
    
}

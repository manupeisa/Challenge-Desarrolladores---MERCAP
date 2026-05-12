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
        if (!isWeekend && startTime >= 480 && startTime <= 1200 ){
            return durationTime * 0.20; 

        }
        else{
            return durationTime * 0.10;
        }
    }
}


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

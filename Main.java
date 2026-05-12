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
    int durationTime; // Dado que el teimpo de las llamadas se cobra por minuto durationTime = Minutos de llamada

    public abstract double calculateCost();
    
}

class LocalCall extends PhoneCall {
    int startTime; // Ya que durationTime esta en minutos esto tambien lo paso a minutos asi tenemos todo en la misma unidad de tiempo
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
    double ratePerMinute; 

    @Override 
    public double calculateCost(){
        return ratePerMinute * durationTime ;
    }
     
}

class NationalCall extends PhoneCall {
    String city;
    double ratePerMinute;

    @Override 
    public double calculateCost(){
        return ratePerMinute * durationTime; 
    }
    
}

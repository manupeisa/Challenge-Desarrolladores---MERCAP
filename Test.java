import java.util.List;

public class Test {
    public static void main(String[] args) {

        //Local Call At the weeak at peak hour 
        LocalCall localPeak = new LocalCall();
        localPeak.durationTime =10 ;
        localPeak.startTime = 480 ; // 8:00 hs 
        localPeak.isWeekend = false ;
        System.out.println("LocalCall in the week at peak hour (Expected: 2.0):  " + localPeak.calculateCost());

        //Local Call At the weeak off peak hour
        LocalCall localOffPeak = new LocalCall();
        localOffPeak.durationTime = 30 ;
        localOffPeak.startTime = 1290 ; // 21:30 hs  
        localOffPeak.isWeekend = false ;
        System.out.println("LocalCall in the week off peak hour (Expected: 3.0):  " + localOffPeak.calculateCost());

        //Local Call At the weekEnd 
        LocalCall localWeekend = new LocalCall();
        localWeekend.durationTime =125 ;
        localWeekend.startTime = 900 ; // 15:00 hs
        localWeekend.isWeekend = true ;
        System.out.println("LocalCall in the weekEnd  (Expected: 12.5):  " + localWeekend.calculateCost()); 

        //International Call
        InternationalCall international = new InternationalCall();
        international.durationTime = 48 ; 
        international.country = "USA" ;
        international.ratePerMinute = 0.70;
        System.out.println("International call to USA (Expected: 33,6):  " + international.calculateCost());

        //National Call 
        NationalCall national = new NationalCall();
        national.durationTime = 300 ;
        national.city = "Tucuman"; 
        national.ratePerMinute = 0.26;
        System.out.println("National call to Tucuman (Expected: 78 ):  "+ national.calculateCost());

        //Bill 
        Bill bill = new Bill(100, List.of(localPeak, localOffPeak, localWeekend, international, national));
        System.out.println("---MonthlyFee---");
        System.err.println("Total: (Expected: 229,1)" + bill.calculateFee());

    }
}

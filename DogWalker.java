package AP_CSA_2025_FRQ.QUESTION_1;

public class DogWalker {
    private int maxDogs;
    private DogWalkCompany company;

    public DogWalker(int max, DogWalkCompany comp) {
        maxDogs = max;
        company = comp;
    }

    public int walkDogs(int hour) {
        int availableDogs = company.numAvailableDogs(hour);

        boolean dogOverflow = (availableDogs > maxDogs) ? true : false;
        if (dogOverflow) {
            company.updateDogs(hour, maxDogs);
            return maxDogs;
        }

        company.updateDogs(hour, availableDogs);
        return availableDogs;
    }

    public int dogWalkShift(int startHour, int endHour) {
        int totalAmount = 0;
        for (int hour = startHour; hour <= endHour; hour++) {
            int basePay = 5;
            int walkedDogs = walkDogs(hour);
            boolean peakHours = (hour >= 9) && (hour <= 17);
            boolean isMaxDogsWalked = (walkedDogs == maxDogs);
            boolean fulfillEitherCondition = peakHours || isMaxDogsWalked;

            if (fulfillEitherCondition) {
                totalAmount += 3;
            }
            totalAmount += (walkedDogs * basePay);

            // TESTING SEGMENT ONLY! NOT NEEDED
            int bonusPay = walkedDogs * basePay + 3;
            int normalPay = walkedDogs * basePay;
            System.out.println("DOGS AVAILABLE WERE " + walkedDogs + ". AT HOUR " + hour + ", WE ARE PAID $" + (fulfillEitherCondition ? bonusPay : normalPay) );
        }
        return totalAmount;
    }


    public static void main(String[] args) {
        // MAX DOG WE CAN WALK IS 10
        // WE WILL WALK THEM AT HOUR 14, WHICH IS 1-14 DOGS INCLUSIVE
        DogWalkCompany DWC1 = new DogWalkCompany();
        DogWalker DW1 = new DogWalker(10, DWC1);
        DW1.walkDogs(14);
        System.out.println("\nTHE DOG WALKER CAN ONLY WALK " + DW1.maxDogs + " DOGS AT MAX!");
        System.out.println(DWC1.toString());
        int dogWalkPayout = DW1.dogWalkShift(6, 14);
        System.out.println("WE GOT PAID $" + dogWalkPayout + "\n");
    }

    
}

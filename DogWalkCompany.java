package AP_CSA_2025_FRQ.QUESTION_1;

public class DogWalkCompany {
    private int hour, numberDogsWalked, randVal;

    public int numAvailableDogs(int hour) {
        // HOUR WILL BE THE UPPER BOUND LOL, 1 - UPPERBOUND INCLUSIVE
        int rand = (int) (Math.random() * hour) + 1;
        randVal = rand;
        return rand;
    }

    public void updateDogs(int hour, int numberDogsWalked) {
        this.hour = hour;
        this.numberDogsWalked = numberDogsWalked;
    }

    public String toString() {
        return "AT HOUR " + hour + ", THE DOG WALKER WALKED " + numberDogsWalked + " DOGS! THE RANDOM DOG VALUE WAS: " + randVal; 
    }

}

package AP_CSA_2025_FRQ.QUESTION_3;

public class Match {
    private Competitor c1;
    private Competitor c2;

    public Match(Competitor c1, Competitor c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public String toString() {
        String comp1 = "C1: " + c1.getName() + "C1 RANK: " + c1.getRank() + "\n";
        String comp2 = "C2: " + c2.getName() + "C2 RANK: " + c2.getRank() + "\n\n";

        return comp1 + comp2;
    }


}

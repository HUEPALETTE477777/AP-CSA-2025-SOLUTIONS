package AP_CSA_2025_FRQ.QUESTION_3;

import java.util.ArrayList;

public class Round {
    private ArrayList<Competitor> competitorList;

    public Round(String[] names) {
        competitorList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Competitor c = new Competitor(names[i], i + 1);
            competitorList.add(c);
        }
    }

    public ArrayList<Match> buildMatches() {
        ArrayList<Match> list = new ArrayList<>();
        int left = (competitorList.size() % 2 == 0) ? 0 : 1;
        int right = (competitorList.size() - 1);

        while (left < right) {
            Competitor sex = competitorList.get(left);
            Competitor intercourse = competitorList.get(right);
            Match female = new Match(sex, intercourse);
            list.add(female);

            left++; 
            right--;
        }

        return list;
    }

    public static void main(String[] args) {
        // EVEN OR ODD
        String[] n1 = {"KEVIN CAI", "AUSTIN CHAU", "GARY PEARLSON", "STEVEN", "KYLE NGUYEN", ":TRUJILLO"};
        Round r1 = new Round(n1);
        ArrayList<Match> m1 = r1.buildMatches();

        for (Match m : m1) {
            System.out.print(m.toString());
        }
    }


}

package AP_CSA_2025_FRQ.QUESTION_2;

public class SignedText {
    private String fName, lName;

    public SignedText(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getSignature() {
        if (fName.isEmpty()) {
            return lName;
        }
        return fName.charAt(0) + "-" + lName;
    }

    public String addSignature(String input) {
        String signature = getSignature();
        if (!input.contains(signature)) {
            return input + signature;
        }

        if (input.endsWith(signature)) {
            return input;
        }

        if (input.startsWith(signature)) {
            String partial = input.substring(signature.length(), input.length());
            return partial + signature;
        }

        return "";
    }

    public static void main(String[] args) {
        SignedText st4 = new SignedText("", "FOX");
        String text = "Dear";
        String temp = st4.addSignature(text);
        System.out.println(temp); // EXPECTED: DEARFOX

        text = "Best wishesFOX";
        temp = st4.addSignature(text);
        System.out.println(temp); // EXPECTED: Best wishesFOX

        text = "FOXThanks";
        temp = st4.addSignature(text);
        System.out.println(temp); // EXPECTED ThanksFOX
    }

}

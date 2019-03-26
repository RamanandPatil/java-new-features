public class SwitchStatements {
    public static void main(String[] args) {
        switchStatement();
        switchWithLocalVars();
        switchAssignmemnt();
    }

    /**
     * As you can see in the following code, many break statements make it
     * unnecessarily verbose, and this visual noise often masks hard to debug
     * errors, where missing break statements mean that accidental
     * fall-through occurs.
     */
    public static void switchStatement() {
        System.out.println("\nSwitchStatements.switchStatement");
        switch (DAYS.getRandomDay()) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                break;
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
            default:
                System.out.println(0);

        }
    }

    /**
     *  Scope of a local variable is the entire switch block.
     */
    public static void switchWithLocalVars() {
        System.out.println("\nSwitchStatements.switchWithLocalVars");
        switch (DAYS.getRandomDay()) {
            case MONDAY:
            case TUESDAY:
                int temp = 2;
                break;
            case WEDNESDAY:
            case THURSDAY:
//                int temp = 3; // variable temp is already defined in th4e scope
                int temp2 = 4;     // Why can't I call this temp?
                break;
            default:
                int temp3 = 6;     // Why can't I call this temp?
        }
    }


    /**
     * Many existing switch statements are essentially simulations of switch
     * expressions, where each arm either assigns to a common target variable
     * or returns a value.
     * Expressing this as a statement is roundabout, repetitive, and
     * error-prone. The author meant to express that we should compute a value
     * of "numLetters" for each day. It should be possible to say that directly,
     * using a switch expression, which is both clearer and safer.
     * (Than the below code)
     */
    public static void switchAssignmemnt() {
        System.out.println("\nSwitchStatements.switchAssignmemnt");
        int numLetters; // May be we want to return or save this info
        var day = DAYS.getRandomDay();
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("Wat: " + day);
        }
    }
}

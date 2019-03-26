public class SwitchExpressions {
    public static void main(String[] args) {
        switchExpression();
        switchWithLocalVars();
        switchAssignmemnt();
        switchAssignmemntWithBreak();
    }

    /**
     * Here we use "case L ->" to signify that only the code to the right of
     * the label is to be executed if the label is matched. For example, the
     * previous code can now be written as below.
     * This example also uses multiple case labels, where it supports
     * multiple comma-separated labels in a single switch label.
     * If a label is matched, then only the expression or statement to the
     * right of an arrow label is executed; there is no fall through.
     */
    public static void switchExpression() {
        System.out.println("\nSwitchExpressions.switchExpression");
        var day = DAYS.getRandomDay();
        switch (day) {
            case MONDAY,FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7)
                ;
            case THURSDAY,SATURDAY -> System.out.println(8);
            case WEDNESDAY -> System.out.println(9)
                ;
            default                     ->System.out.println(0);

        }
    }


    /**
     * The code to the right of a "case L ->" switch label is restricted to be
     * an expression, a block, or (for convenience) a throw statement. This has
     * the pleasing consequence that should an arm introduce a local variable,
     * it must be contained in a block and thus not in scope for any of the
     * other arms in the switch block. This eliminates another annoyance with
     * "traditional" switch blocks where the scope of a local variable is the
     * entire switch block.
     */
    public static void switchWithLocalVars() {
        System.out.println("\nSwitchExpressions.switchWithLocalVars");
        switch (DAYS.getRandomDay()) {
            case MONDAY,TUESDAY -> {
                int temp = 2;
            }
            case WEDNESDAY,THURSDAY -> {
                int temp = 3;
            }
            default                     ->{
                int temp = 6;
            }
        }
    }


    /**
     *
     */
    public static void switchAssignmemnt() {
        System.out.println("\nSwitchExpressions.switchAssignmemnts");
        int numLetters = switch (DAYS.getRandomDay()) {
            case MONDAY,FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7
                ;
            case THURSDAY,SATURDAY -> 8;
            case WEDNESDAY -> 9
                ;
        } ;
    }

    /**
     * Alternatively:
     * A switch expression can, like a switch statement, also use a
     * "traditional" switch block with "case L:" switch labels (implying
     * fall-through semantics). In this case values would be yielded using the
     * break with value statement.
     * This is useful when you have multiline case block.
     * You can even mix and use the break statement only for the cases where you
     * have block with multiple expressions.
     */
    public static void switchAssignmemntWithBreak() {
        System.out.println("\nSwitchExpressions.switchAssignmemntWithBreak");
        var numLetters = switch (DAYS.getRandomDay()) {
            case MONDAY,FRIDAY, SUNDAY -> {
                break 6;
            }
            case TUESDAY -> {
                break 7;
            }
            case THURSDAY,SATURDAY -> 8; // You can mix like this.
            case WEDNESDAY -> {
                break 9;
            }
//            case WEDNESDAY -> break 9; // Cannot write like this, since it is
                                        // an expression not a statement.
        } ;
    }
}

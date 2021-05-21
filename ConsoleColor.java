public class ConsoleColor {
    private String codes;
    private String value;

    // Styles
    public static final ConsoleColor NO_EFFECT = new ConsoleColor(0);
    public static final ConsoleColor BOLD      = new ConsoleColor(1);
    public static final ConsoleColor ITALIC    = new ConsoleColor(3);
    public static final ConsoleColor UNDERLINE = new ConsoleColor(4);
    public static final ConsoleColor NEGATIVE  = new ConsoleColor(7);
    // Foreground
    public static final ConsoleColor FG_BLACK  = new ConsoleColor(30);
    public static final ConsoleColor FG_RED    = new ConsoleColor(31);
    public static final ConsoleColor FG_GREEN  = new ConsoleColor(32);
    public static final ConsoleColor FG_YELLOW = new ConsoleColor(33);
    public static final ConsoleColor FG_BLUE   = new ConsoleColor(34);
    public static final ConsoleColor FG_PURPLE = new ConsoleColor(35);
    public static final ConsoleColor FG_CYAN   = new ConsoleColor(36);
    public static final ConsoleColor FG_WHITE  = new ConsoleColor(37);
    // Background
    public static final ConsoleColor BG_BLACK  = new ConsoleColor(40);
    public static final ConsoleColor BG_RED    = new ConsoleColor(41);
    public static final ConsoleColor BG_GREEN  = new ConsoleColor(42);
    public static final ConsoleColor BG_YELLOW = new ConsoleColor(43);
    public static final ConsoleColor BG_BLUE   = new ConsoleColor(44);
    public static final ConsoleColor BG_PURPLE = new ConsoleColor(45);
    public static final ConsoleColor BG_CYAN   = new ConsoleColor(46);
    public static final ConsoleColor BG_WHITE  = new ConsoleColor(47);


    public ConsoleColor(ConsoleColor... colors){
        this.codes = "";
        for (int i = 0; i < colors.length; i++) {
            if (i != colors.length - 1) {
                this.codes += colors[i].codes + ";";
            } else {
                this.codes += colors[i].codes;
            }
        }
        this.value = "\u001B[" + this.codes + "m";
    }

    public ConsoleColor(int... codes){
        this.codes = "";
        for (int i = 0; i < codes.length; i++) {
            if (i != codes.length - 1) {
                this.codes += Integer.toString(codes[i]) + ";";
            } else {
                this.codes += Integer.toString(codes[i]);
            }
        }
        this.value = "\u001B[" + this.codes + "m";
    }

    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return this.value;
    }

    public static void prettyPrint(Object... args) {
        /*
            Prints pretty.
            
            Example:
                prettyPrint(ConsoleColor.BG_RED, "sample1")
            is the same as:
                System.out.println(ConsoleColor.BG_RED + "sample1" + ConsoleColor.NO_EFFECT)
        */
        for (Object object : args) {
            System.out.print(object);
        }
        System.out.println(ConsoleColor.NO_EFFECT);
    }

}

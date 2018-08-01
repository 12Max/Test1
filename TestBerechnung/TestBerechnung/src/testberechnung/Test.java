package testberechnung;

/**
 *
 * @author Kim
 */
public class Test {

    public static void main(String[] args) throws Exception {

        checkTest2();
    }
    
    private static void checkTest2(){
        // Einige Tests für den Algorithmus
        String[] tests = new String[]{ 
            "1+1",
            "2+4*5",
            "(2+4)*5",
            "e",
            "(((5)))",
            "1 +-+-+ .25",
            "min( 1, 3 )",
            "sqrt 9/3",
            "sqrt (9/3)",
            "sqrt16" };
 
        Parser parser = new Parser();
 
        for( String test : tests )
            System.out.printf( "\"%s\" wird zu \"%f\"\n", test, parser.parse( test ) );
   }
    
    private static void checkTest1() {
        // Einige Tests für den Algorithmus
        String[] tests = new String[]{
            "1+1",
            "2+4*5",
            "(2+4)*5",
            "e",
            "(((5)))",
            "1 +-+-+ .25",
            "min( 1, 3 )",
            "sqrt 9/3",
            "sqrt (9/3)",
            "sqrt16"};

        Parser parser = new Parser();

        for (String test : tests) {
            System.out.printf("\"%s\" wird zu \"%f\"\n", test, parser.parse(test));
        }
    }
}

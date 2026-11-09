package ed3s6_p2e1;


public class ED3S6_P2E1 {
    public ED3S6_P2E1(int n, int x, int y){
        
        System.out.println(" TEOREMA DEL BINOMIO: (x+y)^" + n + "  con x=" + x + ", y=" + y);
       

        System.out.println("\nPASO 1: Formula general");
        System.out.println("(x+y)^n = suma desde k=0 hasta n de  C(n,k) * x^(n-k) * y^k");
        System.out.println("donde C(n,k) = n! / ( k! * (n-k)! )");

        System.out.println("\nPASO 2: Sustituimos n = " + n);
        System.out.println("(x+y)^" + n + " = suma desde k=0 hasta " + n + " de  C(" + n + ",k) * x^(" + n + "-k) * y^k");

        System.out.println("\nPASO 3: Calculo de cada termino (k = 0 hasta " + n + ")");
        int total = procedimiento(n, 0, x, y);

        System.out.println("\nRESULTADO: Polinomio expandido (con x y y)");
        System.out.println("(x+y)^" + n + " = " + expansion(n, 0));

    }


    private int procedimiento(int n, int k, int x, int y){
        if (k > n) return 0;

        int coef = combinatoria(n, k);
        int px = potencia(x, n - k);
        int py = potencia(y, k);
        int valor = coef * px * py;

        System.out.println("\n--- Termino k=" + k + " ---");
        System.out.println("C(" + n + "," + k + ") = " + n + "! / (" + k + "! * " + (n - k) + "!)");
        System.out.println("       = " + factorialDesarrollado(n) + " / ((" + factorialDesarrollado(k)
                + ") * (" + factorialDesarrollado(n - k) + "))");
        System.out.println("       = " + factorial(n) + " / (" + factorial(k) + " * " + factorial(n - k) + ") = " + coef);
        System.out.println("Termino con variables: " + coef + " * x^" + (n - k) + " * y^" + k
                + "  =  " + termino(coef, n - k, k));
        System.out.println("Con x=" + x + ", y=" + y + ": " + coef + " * " + x + "^" + (n - k) + " * " + y + "^" + k
                + " = " + coef + " * " + px + " * " + py + " = " + valor);

        return valor + procedimiento(n, k + 1, x, y);
    }


    private String expansion(int n, int k){
        if (k > n) return "";
        String actual = termino(combinatoria(n, k), n - k, k);
        if (k == n) return actual;
        return actual + " + " + expansion(n, k + 1);
    }


    private String sustitucion(int n, int k, int x, int y){
        if (k > n) return "";
        int valor = combinatoria(n, k) * potencia(x, n - k) * potencia(y, k);
        if (k == n) return "" + valor;
        return valor + " + " + sustitucion(n, k + 1, x, y);
    }


    private String termino(int coef, int expX, int expY){
        String s = (coef == 1 ? "" : "" + coef) + variable("x", expX) + variable("y", expY);
        return s.isEmpty() ? "1" : s;
    }

    private String variable(String v, int exp){
        if (exp == 0) return "";
        if (exp == 1) return v;
        return v + "^" + exp;
    }


    private String factorialDesarrollado(int a){
        if (a <= 1) return "1";
        return a + "*" + factorialDesarrollado(a - 1);
    }


    private int combinatoria(int n, int k){
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    private int potencia(int base, int exp){
        if (exp == 0) return 1;
        return base * potencia(base, exp - 1);
    }

    private int factorial(int a){
        if (a == 0 || a == 1) return 1;
        return a * factorial(a - 1);
    }
    public static void main(String[] args) {
          new ED3S6_P2E1(5, 2, 3);
    }
    
}
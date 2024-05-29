public class Fichero {
    
    public void MetodoSimple() {
        int a = 1;
        int b = 2;
        int c = a + b;
    }

    public void BucleFor(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

    public void BucleWhile(int n) {
        int i = 0;
        while (i < n) {
            System.out.println(i);
            i++;
        }
    }

    public void BucleAnidado(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i * j);
            }
        }
    }

    public int Recursivo(int n) {
        if (n <= 1) {
            return n;
        }
        return Recursivo(n - 1) + Recursivo(n - 2);
    }

    public int MetodoComplejo(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
        return Recursivo(n);
    }
}
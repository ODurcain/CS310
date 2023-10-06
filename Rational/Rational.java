    public class Rational {
        private int numerator;
        private int denominator;
    
        public Rational(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Denominator cannot be zero.");
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }
    
        public int getNumerator() {
            return numerator;
        }
    
        public int getDenominator() {
            return denominator;
        }
    
        public void setNumerator(int n) {
            numerator = n;
        }
    
        public void setDenominator(int d) {
            if (d == 0) {
                throw new IllegalArgumentException("Denominator cannot be zero.");
            }
            denominator = d;
        }
    
        public Rational add(Rational r1) {
            int newNumerator = this.numerator * r1.denominator + r1.numerator * this.denominator;
            int newDenominator = this.denominator * r1.denominator;
            return new Rational(newNumerator, newDenominator);
        }
    
        public Rational subtract(Rational r1) {
            int newNumerator = this.numerator * r1.denominator - r1.numerator * this.denominator;
            int newDenominator = this.denominator * r1.denominator;
            return new Rational(newNumerator, newDenominator);
        }
    
        public Rational multiply(Rational r1) {
            int newNumerator = this.numerator * r1.numerator;
            int newDenominator = this.denominator * r1.denominator;
            return new Rational(newNumerator, newDenominator);
        }
    
        public Rational divide(Rational r1) {
            int newNumerator = this.numerator * r1.denominator;
            int newDenominator = this.denominator * r1.numerator;
            return new Rational(newNumerator, newDenominator);
        }
    
        public void print() {
            System.out.println(numerator + "/" + denominator);
        }
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 4);
        
        System.out.println("r1: ");
        r1.print();
        
        System.out.println("r2: ");
        r2.print();
        
        Rational sum = r1.add(r2);
        System.out.println("Sum: ");
        sum.print();
        
        Rational difference = r1.subtract(r2);
        System.out.println("Difference: ");
        difference.print();
        
        Rational product = r1.multiply(r2);
        System.out.println("Product: ");
        product.print();
        
        Rational quotient = r1.divide(r2);
        System.out.println("Quotient: ");
        quotient.print();
    }
    }
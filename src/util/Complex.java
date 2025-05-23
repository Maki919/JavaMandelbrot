package util;

public class Complex {
    private double real;
    private double imaginary;
    private int iterations;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add( Complex add ){
        return new Complex(real + add.real, imaginary + add.imaginary);
    }
    public Complex sub( Complex sub ){
        return new Complex(real - sub.real, imaginary - sub.imaginary);
    }
    public Complex mul( Complex mul ){
        return new Complex( real * mul.real - imaginary * mul.imaginary, real * mul.imaginary + imaginary * mul.real);
    }
    public double abs(){
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double getReal(){ return real; }
    public double getImaginary(){ return imaginary; }
    public void setReal(double real){ this.real = real; }
    public void setImaginary(double imaginary){ this.imaginary = imaginary; }
    public int getIterations(){ return iterations; }
    public void setIterations(int iterations){ this.iterations = iterations; }

}
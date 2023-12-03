package com.binary.binarytodecimal;

public class BinaryModel {
private int decimal;
private int binaryNumber;

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public int getBinaryNumber() {
        return binaryNumber;
    }

    public void setBinaryNumber(int binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    public BinaryModel() {

}

    public  String decimaltoBinary (){
        if (decimal == 0)
            return "0";

        StringBuilder stringBinary = new StringBuilder();

        while (decimal > 0) {
            int checkpoint = decimal % 2;
            stringBinary.append(checkpoint);
            decimal /= 2;
        }

        stringBinary = stringBinary.reverse();
        return stringBinary.toString();
    }

    public  int decim() {
        int decimalNumber = 0;
        int power = 0;
        while (binaryNumber > 0) {
         //   Mientras el número dado sea mayor que 0
            int temp = binaryNumber % 10;
          //  Guardamos el residuo del número binario en una variable temporal
            decimalNumber += temp * Math.pow(2, power);
         //   El número decimal se sumará con el residuo anterior elevado a 2 a la n
                    binaryNumber = binaryNumber / 10;
           // Dividimos para eliminar los digitos
            power++;
           // Aumentamos power para que nos vaya elevando 2 a la 1, 2 a la 2,....
        }
        return decimalNumber;
    }
}

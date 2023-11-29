package com.divisas.converterdiv;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class ConvertModel {
    private double div;

    private String key;
    private String[] keyStrings = new String[]{"MXN-USD", "USD-MXN","MXN-EUR","EUR-MXN","USD-EUR","EUR-USD"};
    private double[] currencyType = new double[]{0.058, 17.15,0.053,18.83,0.91,1.10};

    public void setKey(String key) {
        this.key = key;
    }
    public void setDiv(double div) {
        this.div = div;
    }

    public ConvertModel() {
    }

    public double convert() {
        int index=0;
        for (String key : keyStrings) {

            if (key.equals(this.key)){
                return currencyType[index]*div;
            }
            index++;
        }return 0;
    }
}
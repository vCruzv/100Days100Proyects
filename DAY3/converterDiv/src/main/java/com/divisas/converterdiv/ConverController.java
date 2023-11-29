//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.divisas.converterdiv;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConverController {
    @FXML
    private Label text;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private ChoiceBox<String> select1;
    @FXML
    private ChoiceBox<String> select2;
    private String[] options = new String[]{"MXN", "USD", "EUR"};


    public ConverController() {
    }

    public void initialize() {
        select1.getItems().addAll(options);
        select2.getItems().addAll(options);
    }
    public void onCalculate() {
        ConvertModel model = new ConvertModel();
        try{
            if(select1.getValue()==null || select2.getValue()==null) {
                select1.setStyle(select1.getValue() == null ? "-fx-border-color:#ff0000;-fx-border-width:2px;-fx-border-radius:2px; " : "-fx-background-color: #333333;");
                select2.setStyle(select2.getValue() == null ? "-fx-border-color:#ff0000;-fx-border-width:2px;-fx-border-radius:2px; " : "-fx-background-color: #333333;");
                throw new ChoiseBoxException("Selecciona una divisa en los campos");
            }else{
                clearChoiseBox();
            }
            String nothingInput = input1.getText();
            if(nothingInput.isEmpty()){
                input1.setStyle("-fx-border-color:#ff0000;-fx-border-width:2px;-fx-border-radius:2px; ");
                throw new ChoiseBoxException("Ingresa un numero valido en el campo");
            }
            clearChoiseBox();
           String key = select1.getValue() + "-" + select2.getValue();
               text.setText("");
               model.setKey(key);
               model.setDiv(Double.parseDouble(input1.getText()));
               input2.setText(Double.toString(model.convert()));

        }catch(ChoiseBoxException e){
            text.setText(e.getMessage());
        }
    }

    public void onClearFieldsClick() {
        input1.clear();
        input2.clear();
        System.out.println("Limpiando...");
    }
    public void clearChoiseBox(){
        select1.setStyle("");
        select2.setStyle("");
        input1.setStyle("");
    }

}
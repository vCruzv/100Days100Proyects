package com.binary.binarytodecimal;

import com.binary.binarytodecimal.MyException.InvalidInputException;
import com.binary.binarytodecimal.MyException.NullInputException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BinaryController {
    @FXML
    private Label text;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;

    public void onActionDtoB() {
        BinaryModel model = new BinaryModel();
        try {
            if (input1.getText().isEmpty()){
                input1.setStyle("-fx-border-color:#ff0000;-fx-border-width:2px;-fx-border-radius:2px; ");
                input2.setStyle("-fx-border-color:#ff0000;-fx-border-width:2px;-fx-border-radius:2px; " );
                throw new NullInputException("Coloca un valor en cualquiera de los campos");
            }

            String decimalInput = input1.getText();
            // Intenta convertir la entrada a un entero para validar si contiene solo números
            try {
                Integer.parseInt(decimalInput);
            } catch (NumberFormatException ex) {
                throw new InvalidInputException("Ingresa solo números en el campo de decimal");
            }

            clear();
            model.setDecimal(Integer.parseInt(decimalInput));
            input2.setText(model.decimaltoBinary());
        } catch (NullInputException | InvalidInputException e) {
            text.setText(e.getMessage());
        }
    }
    @FXML
    public void onActionBtoD(){
        BinaryModel model = new BinaryModel();
        try {
            if (input2.getText().isEmpty()){
                input1.setStyle("-fx-border-color:#ff0000;-fx-border-width:2px;-fx-border-radius:2px; ");
                input2.setStyle("-fx-border-color:#ff0000;-fx-border-width:2px;-fx-border-radius:2px; " );
                throw new NullInputException("Coloca un valor en cualquiera de los campos");
            }

            String binaryInput = input2.getText();
            // Verifica si todos los caracteres ingresados son 0 o 1
            if (!binaryInput.matches("[01]+")) {
                throw new InvalidInputException("Ingresa solo valores binarios (0s y 1s)");
            }

            clear();
            model.setBinaryNumber(Integer.parseInt(binaryInput));
            input1.setText(Integer.toString(model.decim()));
        } catch (NullInputException | InvalidInputException e){
            text.setText(e.getMessage());
        }
    }

    public void clear(){
        text.setText("");
        input1.setStyle("-fx-border-color:  #76D7C4;");
        input2.setStyle("-fx-border-color:  #76D7C4;");
    }
}
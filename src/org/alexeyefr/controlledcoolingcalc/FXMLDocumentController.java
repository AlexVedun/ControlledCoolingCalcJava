/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alexeyefr.controlledcoolingcalc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.alexeyefr.model.CCCalc;

/**
 *
 * @author Алексей
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField thicknessTextField;
    @FXML
    private TextField tempWaterTextField;
    @FXML
    private TextField tempBeginCoolingTextField;
    @FXML
    private TextField tempEndCoolingTextField;
    @FXML
    private TextField sectionCountTextField;
    @FXML
    private TextField coolingRateTextField;
    @FXML
    private TextField waterFlowUpTextField;
    @FXML
    private TextField waterFlowDownTextField;
    @FXML
    private TextField rollerSpeedTextField;
    
    private CCCalc calculator;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculator = new CCCalc();
    }    
    
    @FXML
    private void onCalculate() {
        calculator.setThickness(Double.valueOf(thicknessTextField.getText()));
        calculator.setTempWater(Double.valueOf(tempWaterTextField.getText()));
        calculator.setTempBeginCooling(Double.valueOf(tempBeginCoolingTextField.getText()));
        calculator.setTempEndCooling(Double.valueOf(tempEndCoolingTextField.getText()));
        calculator.setSectionCount(Integer.valueOf(sectionCountTextField.getText()));
        calculator.setCoolingRate(Double.valueOf(coolingRateTextField.getText()));
        calculator.Calculate();
        waterFlowDownTextField.setText(calculator.getWaterFlowDown().toString());
        waterFlowUpTextField.setText(calculator.getWaterFlowUp().toString());
        rollerSpeedTextField.setText(calculator.getRollerSpeed().toString());
    }
}

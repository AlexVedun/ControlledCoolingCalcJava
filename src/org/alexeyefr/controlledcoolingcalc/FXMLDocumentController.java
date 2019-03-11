/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alexeyefr.controlledcoolingcalc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.alexeyefr.model.CCCalc;
import org.alexeyefr.model.Model_10CrSiNiCu;
import org.alexeyefr.model.Model_K60;

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
    @FXML
    private TextField ratioTextField;
    @FXML
    private ComboBox modelComboBox;
    @FXML
    private CheckBox isRatioCheckBox;
    
    private CCCalc calculator;
    private Model_10CrSiNiCu model_10CrSiNiCu;
    private Model_K60 model_K60;
    private ObservableList<String> modelList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelList = FXCollections.observableArrayList("10ХСНД", "К60");
        model_10CrSiNiCu = null;
        model_K60 = null;
        //calculator = new Model_10CrSiNiCu();
        modelComboBox.setItems(modelList);
    }    
    
    @FXML
    private void onCalculate() {
        calculator.setThickness(Double.valueOf(thicknessTextField.getText()));
        calculator.setTempWater(Double.valueOf(tempWaterTextField.getText()));
        calculator.setTempBeginCooling(Double.valueOf(tempBeginCoolingTextField.getText()));
        calculator.setTempEndCooling(Double.valueOf(tempEndCoolingTextField.getText()));
        calculator.setSectionCount(Integer.valueOf(sectionCountTextField.getText()));
        calculator.setCoolingRate(Double.valueOf(coolingRateTextField.getText()));
        if (isRatioCheckBox.isSelected()) {
            calculator.setRatio(Double.valueOf(ratioTextField.getText()));
        }
        calculator.Calculate();
        //waterFlowDownTextField.setText(calculator.getWaterFlowDown().toString());
        //waterFlowUpTextField.setText(calculator.getWaterFlowUp().toString());
        //rollerSpeedTextField.setText(calculator.getRollerSpeed().toString());
        waterFlowDownTextField.setText(String.format("%.0f", calculator.getWaterFlowDown()));
        waterFlowUpTextField.setText(String.format("%.0f", calculator.getWaterFlowUp()));
        rollerSpeedTextField.setText(String.format("%.2f", calculator.getRollerSpeed()));
    }
    
    @FXML
    private void onSelectModel() {
        if ("10ХСНД" == modelComboBox.getValue()) {
            if (model_10CrSiNiCu == null) {
                model_10CrSiNiCu = new Model_10CrSiNiCu();
            }
            calculator = model_10CrSiNiCu;            
        }
        else if (modelComboBox.getValue() == "К60") {
            if (model_K60 == null) {
                model_K60 = new Model_K60();
            }
            calculator = model_K60;
        }
        ratioTextField.setText(calculator.getRatio().toString());
    }
    
    @FXML
    private void onRatioChecked(){
        ratioTextField.setEditable(isRatioCheckBox.isSelected());
        ratioTextField.setFocusTraversable(isRatioCheckBox.isSelected());
    }
}

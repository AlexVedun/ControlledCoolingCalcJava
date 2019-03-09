/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alexeyefr.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Алексей
 */
public class CCCalc {
    private Double tempBeginCooling;         // ТНО - температура начала охлаждения
    private Double tempEndCooling;           // ТКО - температура конца охлаждения
    private Double tempWater;           // температура воды
    private Double thickness;           // толщина листа
    private Double totalWaterFlow;         // ОРВ - общий расход воды
    private Double waterFlowUp;         // РВВ - расход воды "верх"
    private Double waterFlowDown;       // РВН - расход воды "низ"
    private Integer sectionCount;       // количество секций
    private Double coolingRate;         // интенсивность охлаждения
    private Double delta;               // разность ТНО и ТКО
    private Double rollerSpeed;         // скорость рольганга

    public CCCalc() {
        /*tempBeginCooling = new SimpleDoubleProperty();
        tempEndCooling = new SimpleDoubleProperty();
        tempWater    = new SimpleDoubleProperty();
        thickness = new SimpleDoubleProperty();
        totalWaterFlow = new SimpleDoubleProperty();
        waterFlowUp = new SimpleDoubleProperty();
        waterFlowDown = new SimpleDoubleProperty();
        sectionCount = new SimpleIntegerProperty();
        coolingRate = new SimpleDoubleProperty();
        delta = new SimpleDoubleProperty();
        rollerSpeed = new SimpleDoubleProperty();*/
    }
    
    public void Calculate() {
        delta = tempBeginCooling - tempEndCooling;
        totalWaterFlow = -9.0104 * sectionCount + 5.28597 * delta + 22.6833 * coolingRate;
        waterFlowDown = totalWaterFlow / 3.337;
        waterFlowUp = waterFlowDown * 2.337;
        rollerSpeed = 0.09968 * sectionCount + (-0.01422) * thickness + (-0.00295) * delta + 0.00038 * waterFlowUp + 3.78E-5 * waterFlowDown + 0.00593 * tempWater + 0.05506 * coolingRate;
    }

    public Double getTempBeginCooling() {
        return tempBeginCooling;
    }

    public void setTempBeginCooling(Double tempBeginCooling) {
        this.tempBeginCooling = tempBeginCooling;
    }

    public Double getTempEndCooling() {
        return tempEndCooling;
    }

    public void setTempEndCooling(Double tempEndCooling) {
        this.tempEndCooling = tempEndCooling;
    }

    public Double getTempWater() {
        return tempWater;
    }

    public void setTempWater(Double tempWater) {
        this.tempWater = tempWater;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    public Integer getSectionCount() {
        return sectionCount;
    }

    public void setSectionCount(Integer sectionCount) {
        this.sectionCount = sectionCount;
    }

    public Double getCoolingRate() {
        return coolingRate;
    }

    public void setCoolingRate(Double coolingRate) {
        this.coolingRate = coolingRate;
    }

    public Double getWaterFlowUp() {
        return waterFlowUp;
    }

    public Double getWaterFlowDown() {
        return waterFlowDown;
    }

    public Double getRollerSpeed() {
        return rollerSpeed;
    }
    
    
}

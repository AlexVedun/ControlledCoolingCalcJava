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
public abstract class CCCalc {
    protected Double tempBeginCooling;         // ТНО - температура начала охлаждения
    protected Double tempEndCooling;           // ТКО - температура конца охлаждения
    protected Double tempWater;           // температура воды
    protected Double thickness;           // толщина листа
    protected Double totalWaterFlow;         // ОРВ - общий расход воды
    protected Double waterFlowUp;         // РВВ - расход воды "верх"
    protected Double waterFlowDown;       // РВН - расход воды "низ"
    protected Integer sectionCount;       // количество секций
    protected Double coolingRate;         // интенсивность охлаждения
    protected Double delta;               // разность ТНО и ТКО
    protected Double rollerSpeed;         // скорость рольганга
    protected Double ratio;               // коэффициент соотношения

    public CCCalc() {
        
    }
    
    public abstract void Calculate();      

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

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
    
}

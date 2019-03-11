/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alexeyefr.model;

/**
 *
 * @author Alex
 */
public class Model_10CrSiNiCu extends CCCalc {

    public Model_10CrSiNiCu() {
        ratio = 2.337;
    }
    
    @Override
    public void Calculate() {
        delta = tempBeginCooling - tempEndCooling;
        //totalWaterFlow = -9.0104 * sectionCount + 5.28597 * delta + 22.6833 * coolingRate;
        totalWaterFlow = -37.392 * tempWater + 30.26 * thickness + 39.79 * sectionCount - 1.7979 * delta + 29.861 * coolingRate;
        waterFlowDown = totalWaterFlow / (ratio + 1);
        waterFlowUp = waterFlowDown * ratio;
        rollerSpeed = 0.09968 * sectionCount + (-0.01422) * thickness + (-0.00295) * delta + 0.00038 * waterFlowUp + 3.78E-5 * waterFlowDown + 0.00593 * tempWater + 0.05506 * coolingRate;
    }
    
}

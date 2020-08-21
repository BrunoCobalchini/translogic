package model.entities;

import utils.baseTest.BaseTest;

public class FrameManager extends BaseTest {

    private String frameName;

    public String getFrameName() {
        if (frameName.equals("Controle de Pré-OS e OS")) {
            frameName = "ext-gen113";
        } else if (frameName.equals("Formação Trem")) {
            frameName = "ext-gen113";
        } else if (frameName.equals("Movimentação Trem")) {
            frameName = "ext-gen113";
        } else if (frameName.equals("Paradas Trem")) {
            frameName = "ext-gen113";
        } else if (frameName.equals("Encerramento Trem")) {
            frameName = "ext-gen113";
        }
        return frameName;
    }

    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }



}

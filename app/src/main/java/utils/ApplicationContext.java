package utils;

import rego.printlib.export.regoPrinter;
import utils.preDefiniation.TransferMode;

import android.app.Application;

public class ApplicationContext extends Application {

    private regoPrinter printer;

    public regoPrinter getPrinter() {
        return printer;
    }

    public void setPrinter() {
        printer = new regoPrinter(this);
    }

    private String printerName = "RG-MTP58B";

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String name) {
        printerName = name;
    }

    private int myState = 0;

    public void setState(int state) {
        myState = state;
    }

    public int getState() {
        return myState;
    }

    private TransferMode printMode = TransferMode.TM_NONE;

    public void setPrintMode(int printMode) {
        switch (printMode) {
            case 0:
                this.printMode = TransferMode.TM_NONE;
                break;
            case 1:
                this.printMode = TransferMode.TM_DT_V1;
                break;
            default:
                this.printMode = TransferMode.TM_DT_V2;
                break;
        }
    }

    public int getPrintMode() {
        return printMode.getValue();
    }

    private boolean labelMark = true;

    public boolean getLabelMark() {
        return labelMark;
    }

    public void setLabelMark(boolean labelMark) {
        this.labelMark = labelMark;
    }

}

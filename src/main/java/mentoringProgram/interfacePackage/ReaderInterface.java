package mentoringProgram.interfacePackage;

import mentoringProgram.calculatorLogic.Formula;

public interface ReaderInterface {
    Boolean hasNext();
    Formula readNext();
    Integer selectCalculator();
}

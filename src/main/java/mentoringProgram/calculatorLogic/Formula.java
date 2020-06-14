package mentoringProgram.calculatorLogic;

public class Formula {
    Double x;
    Double y;
    Character sign;
    Double result;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Character getSign() {
        return sign;
    }

    public void setSign(Character sign) {
        this.sign = sign;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format("Formula: x=%s, y=%s, sign=%s, result=%s", x, y, sign, result);
    }
}

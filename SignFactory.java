public class SignFactory {

    public HandSign getSign(int signType) {

        if (signType == 1) {
            return new Rock();
        } else if (signType == 2) {
            return new Paper();
        } else if (signType == 3) {
            return new Paper();
        } else if (signType == 4) {
            return new Scissors();
        } else if (signType == 5) {
            return new Spock();
        } else return null;
    }
}
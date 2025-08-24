package it.unisa.country;

public class DataSet {

    private /* TODO */ minimum;
    private /* TODO */ maximum;
    private int count;

    public DataSet() {
        count = 0;
        minimum = null;
        maximum = null;
    }

    public /* TODO */ getMaximum() {
        return maximum;
    }

    public /* TODO */ getMinimum() {
        return minimum;
    }

    public void add(/* TODO */ x) {
        if (count == 0 || x.compareTo(minimum) < 0)
            minimum = x;
        if (count == 0 || x.compareTo(maximum) > 0)
            maximum = x;
        count++;
    }
}
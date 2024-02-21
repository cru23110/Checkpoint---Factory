// University/Pago.java
package University;

public class Pago {
    private int id;
    private double monto;
    private String concepto;

    public Pago(int id, double monto, String concepto) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
    }

    public int getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public String getConcepto() {
        return concepto;
    }
}


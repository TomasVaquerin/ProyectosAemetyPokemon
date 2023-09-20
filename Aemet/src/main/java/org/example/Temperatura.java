package org.example;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Temperatura {

    private String localidad;
    private String provincia;
    private double tempMax;
    private LocalDate hsTempMax;
    private double tempMin;
    private LocalDate hsTempMin;
    private double precision;

    @Override
    public String toString() {
        return "Temperatura{" +
                "localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", tempMax=" + tempMax +
                ", hsTempMax=" + hsTempMax +
                ", tempMin=" + tempMin +
                ", hsTempMin=" + hsTempMin +
                ", precision=" + precision +
                '}';
    }
}

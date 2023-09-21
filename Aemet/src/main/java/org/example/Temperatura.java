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
    private double precipitacion;

    public Temperatura(String localidad, String provincia, double tempMax, LocalDate hsTempMax, double tempMin, LocalDate hsTempMin, double precipitacion) {
        this.localidad = localidad;
        this.provincia = provincia;
        this.tempMax = tempMax;
        this.hsTempMax = hsTempMax;
        this.tempMin = tempMin;
        this.hsTempMin = hsTempMin;
        this.precipitacion = precipitacion;
    }

    @Override
    public String toString() {
        return "Temperatura{" +
                "localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", tempMax=" + tempMax +
                ", hsTempMax=" + hsTempMax +
                ", tempMin=" + tempMin +
                ", hsTempMin=" + hsTempMin +
                ", precision=" + precipitacion +
                '}';
    }
}

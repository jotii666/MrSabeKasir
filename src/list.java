/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A S U S
 */

 import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class list {
    private Date tanggal;
    private Time jam;
    private Integer nominal;
 
    public Date getTanggal() {
        return tanggal;
    }
 
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
 
    public Time getJam() {
        return jam;
    }
 
    public void setJam(Time jam) {
        this.jam = jam;
    }
 
    public Integer getNominal() {
        return nominal;
    }
 
    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }
    
}

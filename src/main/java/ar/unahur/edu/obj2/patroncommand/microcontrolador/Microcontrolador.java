package ar.unahur.edu.obj2.patroncommand.microcontrolador;

import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.excepciones.FueraDeRangoDeMemoriaException;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

public class Microcontrolador implements Programable{
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private List<Integer> memoria = Arrays.asList(new Integer[1024]);

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> o.execute(this));;
    }
    @Override
    public void incProgramCounter() {
        programCounter += 1;
    }
    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }
    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }
    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }
    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }
    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }
    @Override
    public void setAddr(Integer addr) {
        if(addr < 0 || addr > memoria.size()){
            throw new FueraDeRangoDeMemoriaException();
        }
        memoria.set(addr, acumuladorA);
    }
    @Override
    public Integer getAddr(Integer addr) {
        if(addr < 0 || addr > memoria.size()){
            throw new FueraDeRangoDeMemoriaException();
        }
        return memoria.get(addr);
    }
    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
        memoria = Arrays.asList(new Integer[1024]);
    }
}

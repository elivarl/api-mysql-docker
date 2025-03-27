package com.icodeap.apimysqldocker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public Cuenta save(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    public Cuenta findById(Long id){
        return cuentaRepository.findById(id).get();
    }

    public List<Cuenta> findAll(){
        return cuentaRepository.findAll();
    }

    public void deleteById(Long id){
        cuentaRepository.deleteById(id);
    }

    public Cuenta update(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

}

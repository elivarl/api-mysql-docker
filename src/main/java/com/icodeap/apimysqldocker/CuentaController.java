package com.icodeap.apimysqldocker;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
//http://localhost:8080/api/cuentas
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }
    //POST
    //http://localhost:8080/api/cuentas
    @PostMapping
    public Cuenta save(@RequestBody Cuenta cuenta){
        return cuentaService.save(cuenta);
    }
    //GET
    //http://localhost:8080/api/cuentas
    @GetMapping
    public List<Cuenta> findAll(){
        return cuentaService.findAll();
    }

    //GET
    //http://localhost:8080/api/cuentas/1
    @GetMapping("/{id}")
    public Cuenta findById(@PathVariable Long id){
        return cuentaService.findById(id);
    }

    //DELETE
    //http://localhost:8080/api/cuentas/4
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         cuentaService.deleteById(id);
    }

    //PUT
    //http://localhost:8080/api/cuentas

    @PutMapping
    public Cuenta update(@RequestBody Cuenta cuenta){
        Cuenta cuentaDB = cuentaService.findById(cuenta.getId());
        cuentaDB.setTitular(cuenta.getTitular());
        cuentaDB.setBalance(cuenta.getBalance());

        return cuentaService.update(cuentaDB);
    }


}

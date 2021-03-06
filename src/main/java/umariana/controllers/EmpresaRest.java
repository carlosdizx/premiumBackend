package umariana.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import umariana.models.entity.Empresa;
import umariana.models.service.api.EmpresaService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/empresas")
public class EmpresaRest
{
    @Autowired
    private EmpresaService service;

    @GetMapping("/all")
    public List<Empresa> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> findByID(@PathVariable Long id){
        final Map<String, Object>response = new HashMap<>();
        try {
            final Empresa empresa = service.findByID( id );
            if (empresa==null){
                response.put("mensaje","La empresa con el id: ".concat(id.toString()).concat(" no existe!"));
                return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
            }
            response.put("mensaje","Empresa encontrada");
            response.put("empresa", empresa);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (DataAccessException e){
            response.put("mensaje","No se ha logrado realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/all")
    public ResponseEntity<Map<String,Object>>save(@RequestBody Empresa pEmpresa){
        final Map<String, Object>response = new HashMap<>();
        if (pEmpresa == null){
            response.put("mensaje","Datos nulos o vacios");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try{
            final Empresa empresa = service.save(pEmpresa);
            if (empresa == null){
                response.put("mensaje","La empresa no se ha podido registrar, verifique los datos");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            response.put("mensaje","La empresa ha sido registrada con exito!");
            response.put("empresa",empresa);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (DataAccessException e){
            response.put("mensaje","No se ha logrado realizar la insercion en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Empresa pEmpresa, @PathVariable Long id )
    {
        final Map<String,Object> response =new HashMap<>();
        try{
            final Empresa empresa = service.findByID(id);
            if (empresa==null){
                response.put("mensaje","la empresa con el id: ".concat(id.toString()).concat(" no existe! ")
                        .concat(",no se puede editar"));
                return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
            }
            empresa.setNit(empresa.getNit() );
            empresa.setNombre(empresa.getNombre() );
            empresa.setSector( pEmpresa.getSector() );
            empresa.setTelefono( pEmpresa.getTelefono() );
            empresa.setCorreo( pEmpresa.getCorreo() );
            empresa.setCelular( pEmpresa.getCelular() );

            response.put("empresa",service.save( empresa ));
            response.put("mensaje","La empresa '"+empresa.getNombre()+"' ha sido actualizada");
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (DataAccessException e){
            response.put("mensaje","No se ha logrado realizar la actualizacion de datos de la empresa");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

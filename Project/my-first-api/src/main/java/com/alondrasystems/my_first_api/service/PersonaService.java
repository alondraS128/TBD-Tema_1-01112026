package com.alondrasystems.my_first_api.service;

import com.alondrasystems.my_first_api.entity.Persona;
import com.alondrasystems.my_first_api.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public List<Persona> listarTodas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> buscarPorId(Long id) {
        return personaRepository.findById(id);
    }

    public Persona guardar(Persona persona) {
        persona.setId(null);
        return personaRepository.save(persona);
    }

    public Optional<Persona> actualizar(Long id, Persona nuevosDatos) {
        return personaRepository.findById(id).map(persona -> {
            persona.setNombre(nuevosDatos.getNombre());
            persona.setApellidoPaterno(nuevosDatos.getApellidoPaterno());
            persona.setApellidoMaterno(nuevosDatos.getApellidoMaterno());
            persona.setDireccion(nuevosDatos.getDireccion());
            persona.setTelefono(nuevosDatos.getTelefono());
            persona.setEmail(nuevosDatos.getEmail());
            return personaRepository.save(persona);
        });
    }


    public boolean eliminar(Long id) {
        if (!personaRepository.existsById(id)) {
            return false;
        }
        personaRepository.deleteById(id);
        return true;
    }
}
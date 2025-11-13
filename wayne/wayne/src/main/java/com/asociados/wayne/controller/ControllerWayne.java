package com.asociados.wayne.controller;

import com.asociados.wayne.dtos.EmpresaDto;
import com.asociados.wayne.model.Empresa;
import com.asociados.wayne.model.Producto;
import com.asociados.wayne.model.Transaccion;
import com.asociados.wayne.model.Usuario;
import com.asociados.wayne.service.EmpresaService;
import com.asociados.wayne.service.ProductoService;
import com.asociados.wayne.service.TransaccionService;
import com.asociados.wayne.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ControllerWayne {

	private final UserServiceImpl userService;
	private final EmpresaService empresaService;
	private final ProductoService productoService;

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam("Correo") String correo, @RequestParam("Password") String password) {
		return ResponseEntity.ok(userService.authenticate(correo, password));
	}

	@PostMapping("/login/register")
	public ResponseEntity<String> register(@RequestBody Usuario usuario) {
		userService.register(usuario);
		return ResponseEntity.ok("Usuario registrado con exito");
	}

	@GetMapping("/empresas")
	public ResponseEntity<List<EmpresaDto>> listEmpresas() {
		return ResponseEntity.ok(empresaService.findAll());
	}

	@GetMapping("/empresas/{id}")
	public ResponseEntity<EmpresaDto> productosPorEmpresa(@PathVariable Integer id) {
		return ResponseEntity.ok(empresaService.findById(id));
	}

	// --- Productos ---
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> listProductos() {
		return ResponseEntity.ok(productoService.findAll());
	}

	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable Integer id) {
		return productoService.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}

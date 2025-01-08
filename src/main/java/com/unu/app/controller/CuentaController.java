package com.unu.app.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unu.app.entity.Usuario;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/Cuenta")
public class CuentaController {

	@GetMapping("/Details")
	public ModelAndView NuevoCliente(HttpSession session)throws IOException {
		ModelAndView modelAndView = new ModelAndView("/Cuenta/CuentaDetails");
		Usuario user = (Usuario) session.getAttribute("UsuarioLogin");
		
		if(user!=null){
			System.out.println("Usuario existe");
			modelAndView.addObject("Usuario",user);
			return modelAndView;
		}else {
			System.out.println("Usuario no existe");
			return new ModelAndView("redirect:/Login/IniciarSesion");
		}
		
	}
}

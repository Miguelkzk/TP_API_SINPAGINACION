package com.utn.Tp.controllers;

import com.utn.Tp.entities.Autor;
import com.utn.Tp.servicies.AutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin (origins = "*")
@RequestMapping (path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl> {
}

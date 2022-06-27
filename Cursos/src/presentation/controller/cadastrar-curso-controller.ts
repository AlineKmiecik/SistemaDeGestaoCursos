import axios, { Axios } from "axios";
import { Request, Response } from "express";

import { CursoModel } from "../../data/models/curso";
import { CadastrarCurso } from "../../domain/usecases/cadastrar-curso";

export class CadastrarController {
  
    constructor(private readonly cadastrarCurso: CadastrarCurso) {}

    async cadastrar(request: Request, response: Response) {
        //try {
        //   const curso: CursoModel = request.body;
        //    return response.status(201).
        //        json(await this.cadastrarCurso.cadastrar(curso));
        //} catch (erro: any) {
        //    return response.status(400).json({ message: erro.message });
        // }

        console.log("entrou aqui")
        const curso = request.body;

        //fetch ou axios
        axios.post("http://localhost:8090/curso/create", curso)
        .then((response) => {
            console.log(response);
        })
        .catch((error) => {  
            console.log(error);
        });

        return response.status(201).json({ message: "Produto cadastrado"});
    }

}
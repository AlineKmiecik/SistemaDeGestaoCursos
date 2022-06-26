import { Request, Response } from "../../../node_modules/express";
import { CursoModel } from "../../data/models/curso";
import { CadastrarCurso } from "../../domain/usecases/cadastrar-curso";

export class CadastrarController {
  
    constructor(private readonly cadastrarCurso: CadastrarCurso) {}

    async cadastrar(request: Request, response: Response) {
        try {
            const curso: CursoModel = request.body;
            return response.status(201).
                json(await this.cadastrarCurso.cadastrar(curso));
        } catch (erro: any) {
            return response.status(400).json({ message: erro.message });
        }
    }

}
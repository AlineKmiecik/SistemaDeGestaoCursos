import { Request, Response } from "express";
import { CursoModel } from "../../data/models/curso";
import { AlterarCurso } from "../../domain/usecases/alterar-curso";

export class AlterarController {
  
    constructor(private readonly alterarCurso: AlterarCurso) {}

    async alterar(request: Request, response: Response) {
        try {
            const curso: CursoModel = request.body;
            return response.status(201).
                json(await this.alterarCurso.alterar(curso));
        } catch (erro: any) {
            return response.status(400).json({ message: erro.message });
        }
    }
}
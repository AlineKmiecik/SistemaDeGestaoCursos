import { Request, Response } from "express";
import { CursoModel } from "../../data/models/curso";
import { RemoverCurso } from "../../domain/usecases/remover-curso";

export class RemoverController {
  
    constructor(private readonly removerCurso: RemoverCurso) {}

    async remover(request: Request, response: Response) {
        try {
            const curso: CursoModel = request.body;
            return response.status(201).
                json(await this.removerCurso.remover(curso));
        } catch (erro: any) {
            return response.status(400).json({ message: erro.message });
        }
    }
}
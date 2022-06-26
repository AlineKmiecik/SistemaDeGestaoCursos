import { Request, Response } from "express";
import { CursoModel } from "../../data/models/curso";
import { ListarCursos } from "../../domain/usecases/listar-cursos";

export class ListarController {
  
    constructor(private readonly listarCursos: ListarCursos) {}

    async listar(request: Request, response: Response) {
        try {
            const curso: CursoModel = request.body;
            return response.status(201).
                json(await this.listarCursos.listar());
        } catch (erro: any) {
            return response.status(400).json({ message: erro.message });
        }
    }

}
import { RemoverCurso } from "../../domain/usecases/remover-curso";
import { CursoModel } from "../models/curso";
import { CursoRepository } from "../../infra/repositories/curso-repository";

export class RemoverCursoService implements RemoverCurso{

    constructor(private readonly cursoRepository : CursoRepository){}

    async remover (curso: CursoModel) : Promise<CursoModel[]>{
        return this.cursoRepository.remover(curso);
        
    }
}
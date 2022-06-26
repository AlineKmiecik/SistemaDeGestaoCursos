import { AlterarCurso } from "../../domain/usecases/alterar-curso";
import { CursoModel } from "../models/curso";
import { CursoRepository } from "../../infra/repositories/curso-repository";

export class AlterarCursoService implements AlterarCurso{

    constructor(private readonly cursoRepository : CursoRepository){}

    async alterar (curso: CursoModel) : Promise<CursoModel[]>{
        return this.cursoRepository.alterar(curso);
    }

}
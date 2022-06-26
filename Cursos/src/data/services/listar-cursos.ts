import { ListarCursos } from "../../domain/usecases/listar-cursos";
import { CursoModel } from "../models/curso";
import { CursoRepository } from "../../infra/repositories/curso-repository";

export class ListarCursoService implements ListarCursos{

    constructor(private readonly cursoRepository : CursoRepository){}

    async listar () : Promise<CursoModel[]>{
        return this.cursoRepository.listar();
    }

}
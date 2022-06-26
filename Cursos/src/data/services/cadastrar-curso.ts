import { CadastrarCurso } from "../../domain/usecases/cadastrar-curso";
import { CursoModel } from "../models/curso";
import { CursoRepository } from "../../infra/repositories/curso-repository";

export class CadastrarCursoService implements CadastrarCurso{

    constructor(private readonly cursoRepository : CursoRepository){}

    async cadastrar(curso: CursoModel) : Promise<CursoModel[]>{
       return  this.cursoRepository.cadastrar(curso);
    }

}
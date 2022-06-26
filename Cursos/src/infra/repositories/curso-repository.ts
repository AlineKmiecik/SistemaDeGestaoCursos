import { AlterarCursoRepository } from "../../data/contracts/alterar-curso-repository";
import { CadastrarCursoRepository } from "../../data/contracts/cadastrar-curso-repository";
import { RemoverCursoRepository } from "../../data/contracts/remover-curso-repository";
import { ListarCursosRepository } from "../../data/contracts/listar-cursos-repository";
import { CursoModel } from "../../data/models/curso";

const cursos : CursoModel[] = [];

export class CursoRepository implements CadastrarCursoRepository, AlterarCursoRepository, RemoverCursoRepository, ListarCursosRepository{

    async cadastrar(curso: CursoModel) : Promise<CursoModel[]>{
        let validaItemLista: Boolean = false;

        cursos.forEach(function(item) {
            if (item.id == curso.id){
                validaItemLista = true;
            }
        });

        if(validaItemLista){
            throw new Error("Esse Curso já existe!");
        }else{
            cursos.push(curso);
        }
        return cursos;
    }

    async listar () : Promise<CursoModel[]>{
        return cursos;
    }

    async remover (curso: CursoModel) : Promise<CursoModel[]>{
        if (!cursos.splice(cursos.findIndex(item => item.id === curso.id),1)){
            throw new Error("Curso não encontrado!");
        }
        return cursos;
    }

    async alterar (curso: CursoModel) : Promise<CursoModel[]>{
        if ( (cursos.findIndex(item => item.id === curso.id),1) > 0 ){
            cursos[(cursos.findIndex(item => item.id === curso.id),1)] = curso;
        }else{
            throw new Error("Curso não encontrado!");
        }
        
        return cursos;
    }
    
}
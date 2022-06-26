
import { CursoRepository } from "../../infra/repositories/curso-repository";

import { CadastrarCursoService } from "../../data/services/cadastrar-curso";
import { AlterarCursoService } from "../../data/services/alterar-cursos";
import { ListarCursoService } from "../../data/services/listar-cursos";
import { RemoverCursoService } from "../../data/services/remover-cursos";

import {CadastrarController} from "../../presentation/controller/cadastrar-curso-controller";
import {AlterarController} from "../../presentation/controller/alterar-curso-controller";
import {RemoverController} from "../../presentation/controller/remover-curso-controller";
import {ListarController} from "../../presentation/controller/listar-curso-controller";

export const CadastrarCursoController = () : CadastrarController => {
    const repository = new CursoRepository();
    const service = new CadastrarCursoService(repository);
    return new CadastrarController(service);
} 

export const ListarCursoController = () : ListarController => {
    const repository = new CursoRepository();
    const service = new ListarCursoService(repository);
    return new ListarController(service);
} 

export const RemoverCursoController = () : RemoverController => {
    const repository = new CursoRepository();
    const service = new RemoverCursoService(repository);
    return new RemoverController(service);
} 

export const AlterarCursoController = () : AlterarController => {
    const repository = new CursoRepository();
    const service = new AlterarCursoService(repository);
    return new AlterarController(service);
} 
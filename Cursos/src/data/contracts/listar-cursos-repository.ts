import { CursoModel } from "../models/curso";

export interface ListarCursosRepository{
    listar:() => Promise<CursoModel[]>;
}
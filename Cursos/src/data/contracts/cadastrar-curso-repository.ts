import { CursoModel } from "../models/curso";

export interface CadastrarCursoRepository{
    cadastrar:(curso: CursoModel) => 
        Promise<CursoModel[]>;
}
import { CursoModel } from "../models/curso";

export interface AlterarCursoRepository{
    alterar:(curso: CursoModel) => Promise<CursoModel[]>;
}
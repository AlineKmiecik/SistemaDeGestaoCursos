import { CursoModel } from "../models/curso";

export interface RemoverCursoRepository{
    remover:(curso: CursoModel) => Promise<CursoModel[]>;
}
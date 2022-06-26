import { Curso } from "../entities/curso";

export interface RemoverCurso{
    remover: (curso: Curso) => Promise<Curso[]>;
}
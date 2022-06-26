import { Curso } from "../entities/curso";

export interface AlterarCurso{
    alterar: (curso: Curso) => Promise<Curso[]>;
}
import { Curso } from "../entities/curso";

export interface CadastrarCurso{
    cadastrar: (curso: Curso) => Promise<Curso[]>;
}
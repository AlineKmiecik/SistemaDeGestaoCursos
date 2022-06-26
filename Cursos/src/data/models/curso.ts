import { AlunoModel } from "./aluno";

export type CursoModel = {
    id: number;
    nome: string;
    alunos: AlunoModel[];
}
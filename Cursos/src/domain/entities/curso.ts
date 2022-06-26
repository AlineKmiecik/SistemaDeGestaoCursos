import { Aluno } from "./aluno";

export type Curso = {
    id: number;
    nome: string;
    alunos: Aluno[];
}
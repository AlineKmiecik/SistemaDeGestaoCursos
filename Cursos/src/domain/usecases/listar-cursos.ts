import { Curso } from "../entities/curso";

export interface ListarCursos{
    listar: () => Promise<Curso[]>;
}
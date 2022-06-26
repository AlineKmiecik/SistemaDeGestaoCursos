import { Request, Response, Router } from "express";
import { CadastrarCursoController, AlterarCursoController, RemoverCursoController, ListarCursoController} from "../factories/curso-controller";

const routes = Router();

routes.post("/curso/cadastrar", 
    async function(request: Request, response: Response){
        const controller = CadastrarCursoController();        
        await controller.cadastrar(request, response);
    }
);

routes.get("/curso/listar",
    async function(request: Request, response: Response){
        const controller = ListarCursoController();        
        await controller.listar(request, response);
    }
);

routes.put("/curso/alterar",
    async function(request: Request, response: Response){
        const controller = AlterarCursoController();        
        await controller.alterar(request, response);
    }
);

routes.put("/curso/remover",
    async function(request: Request, response: Response){
        const controller = RemoverCursoController();        
        await controller.remover(request, response);
    }
);

export { routes };
import { Router } from 'express'

import usuarioRouter from './usuario'
import categoriaRouter from './categoria'
import sessionRouter from './session'
import autenticacao from '../middlewares/autenticacao'
import agendamentoRouter from './agendamento'
import agenteRouter from './agente'
import vacinaRouter from './vacina'
import idosoRouter from './idoso'

const routes = Router()



routes.use("/agendamento",agendamentoRouter)
routes.use("/agente",agenteRouter)
routes.use("/vacina",vacinaRouter)
routes.use("/idoso",idosoRouter)

routes.use('/usuarios', usuarioRouter)
routes.use(autenticacao)
routes.use('/categorias',autenticacao, categoriaRouter)
routes.use('/session', sessionRouter)

export default routes

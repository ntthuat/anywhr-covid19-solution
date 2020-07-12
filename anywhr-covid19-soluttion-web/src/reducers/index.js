import {combineReducers} from 'redux'
import {connectRouter} from 'connected-react-router'

import hexagons from './hexagons'

export default history =>
  combineReducers({
    router: connectRouter(history),
    hexagons
  })

import {callAPI} from './base'

export const findAll = name => callAPI(`/hexagon`)

export const findByName = name => callAPI(`/hexagon/${name}`)

export const createHexagon = data => {
  const url = '/hexagon' + '?name=' + data.name + '&neighborName=' + data.neighborName + '&borderNo=' + data.border
  return callAPI(url, 'post')
}

export const deleteFreeHexagon = name => callAPI(`/hexagon/${name}`, 'delete')

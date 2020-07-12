import {callAPI} from './base'

export const findAll = name => callAPI(`/hexagon`)

export const findByName = name => callAPI(`/hexagon/${name}`)

export const createHexagon = data => callAPI(`/hexagon`, 'post', data)

export const deleteFreeHexagon = name => callAPI(`/hexagon/${name}`, 'delete')
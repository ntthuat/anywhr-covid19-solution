import {findAll} from 'api/hexagon'
import * as actionTypes from './actionTypes'

export const fetchHexagons = () => async dispatch => {
  try {
    const data = await findAll()

    if (!data) {
      dispatch(fetchHexagonsStatus(false))
      return
    }

    dispatch({type: actionTypes.FETCH_HEXAGONS, data})
  } catch (err) {
    dispatch(fetchHexagonsStatus(false))
  }
}

export const fetchHexagonsStatus = status => ({
  type: actionTypes.FETCH_HEXAGONS_STATUS,
  status
})
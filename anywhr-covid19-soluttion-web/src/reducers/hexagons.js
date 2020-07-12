import * as actionTypes from 'actions/actionTypes'

const initialState = {
  data: [],
  status: true
}

const hexagons = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.FETCH_HEXAGONS:
      return {
        ...state,
        data: [...action.data],
        status: true
      }

    case actionTypes.FETCH_HEXAGONS_STATUS:
      return {
        ...state,
        status: action.status
      }

    default:
      return state
  }
}

export default hexagons

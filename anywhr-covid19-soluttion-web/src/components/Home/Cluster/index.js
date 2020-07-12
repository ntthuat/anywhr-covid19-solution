import React, {Fragment} from 'react'
import {connect} from 'react-redux'
import {Hexagon} from 'react-hexgrid'

const HexagonList = ({hexagons, match}) => {
  const hexagonsList = hexagons.map(hexagon => (
    <Hexagon q={hexagon.q} r={hexagon.r}/>
  ))

  return (
    <Fragment>
      {hexagonsList}
    </Fragment>
  )
}

const mapStateToProps = state => {
  return {
    hexagons: state.hexagons
  }
}

export default connect(mapStateToProps)(HexagonList)

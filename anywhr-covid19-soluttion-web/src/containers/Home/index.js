import React, {Component} from 'react'
import Loader from 'components/UI/Loader'
import "./style.scss"
import {findAll} from 'api/hexagon'
import {HexGrid, Layout, Hexagon} from 'react-hexgrid'
import Grid from '@material-ui/core/Grid'
import Paper from '@material-ui/core/Paper'

class Home extends Component {

  state = {
    data: [],
    loaded: false
  }

  render() {
    const hexagonsList = this.state.data.map(hexagon => (
      <Hexagon q={hexagon.q} r={hexagon.r}/>
    ))
    const {t} = this.props
    if (!this.state.loaded) {
      return <Loader/>
    } else {
      return (
        <div className="row">
          <div className="col">
            <section className="module home">
              <Grid container spacing={1}>
                <Grid item xs={8}>
                  <Paper>
                    <HexGrid>
                      <Layout size={{x: 2, y: 2}} flat={true} spacing={1.1} origin={{x: 0, y: 0}}>
                        {hexagonsList}
                      </Layout>
                    </HexGrid>
                  </Paper>
                </Grid>
                <Grid item xs={4}>
                  <Paper>
                    Thuat
                  </Paper>
                </Grid>
              </Grid>

            </section>
          </div>
        </div>
      )
    }
  }

  async componentDidMount() {
    const data = await findAll()
    if (data) {
      this.setState({
        data: data,
        loaded: true
      })
    }
  }
}

export default Home

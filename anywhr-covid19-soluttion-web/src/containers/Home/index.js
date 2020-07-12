import React, {Component} from 'react'
import Loader from 'components/UI/Loader'
import {Button, Input, Icon, Divider} from "antd"
import "./style.scss"
import {findAll, createHexagon} from 'api/hexagon'
import {HexGrid, Layout, Hexagon} from 'react-hexgrid'
import Grid from '@material-ui/core/Grid'
import Paper from '@material-ui/core/Paper'
import {showError, isEmpty, showWarning, showSuccess} from 'common/Utils'

class Home extends Component {

  state = {
    data: [],
    loaded: false,
    loading: false,
    name: '',
    neighborName: '',
    border: ''
  }

  onChangeName = e => {
    this.setState({name: e.target.value})
  }

  onChangeNeighborName = e => {
    this.setState({neighborName: e.target.value})
  }

  onChangeBorder = e => {
    this.setState({border: e.target.value})
  }

  onCreateHexagon = e => {
    e.preventDefault()
    const {name, neighborName, border} = this.state
    if (isEmpty(name)) {
      return showWarning("Please input the hexagon name")
    }
    if (isEmpty(neighborName)) {
      return showWarning("Please input the neighbor name")
    }
    if (isEmpty(border)) {
      return showWarning("Please input the position border")
    }
    let data = {
      name,
      neighborName,
      border
    }
    this.setState({loading: true})
    createHexagon(data)
      .then(res => {
        this.setState({loading: false})
        showSuccess("Create new Hexagon successfully!")
        window.location.reload()
      })
      .catch(err => {
        this.setState({loading: false})
        showError(err)
        window.location.reload()
      })
  }

  render() {
    const hexagonsList = this.state.data.map(hexagon => (
      <Hexagon q={hexagon.q} r={hexagon.r}/>
    ))
    const {name, neighborName, border, loading} = this.state
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
                    <h1>Create New Hexagon</h1>
                    <form onSubmit={this.onCreateHexagon}>
                      <div className="mb-3">
                        <Input
                          className="create-input"
                          placeholder="Enter hexagon name"
                          size="large"
                          name={"name"}
                          value={name}
                          onChange={this.onChangeName}
                        />
                      </div>
                      <div className="mb-3">
                        <Input
                          className="create-input"
                          placeholder="Enter neighbor name"
                          size="large"
                          name={"neighborName"}
                          value={neighborName}
                          onChange={this.onChangeNeighborName}
                        />
                      </div>
                      <div className="mb-3">
                        <Input
                          className="create-input"
                          placeholder="Enter border position (0-5)"
                          size="large"
                          name={"border"}
                          value={border}
                          onChange={this.onChangeBorder}
                        />
                      </div>
                      <Divider/>
                      <div className="row">
                        <div className="col-12">
                          <Button
                            className="create-button"
                            htmlType={"submit"}
                            type={"primary"}
                            block
                            size={"large"}
                            loading={loading}
                          >
                            CREATE
                          </Button>
                        </div>
                      </div>
                    </form>
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

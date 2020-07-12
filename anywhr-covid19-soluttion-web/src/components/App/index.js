import React, {Component} from 'react'
import {Route, Switch, withRouter} from 'react-router-dom'
import {connect} from 'react-redux'

import Layout from 'hoc/Layout'

import Home from 'containers/Home'

import PageNotFound from 'components/PageNotFound'

import './app.scss'

class App extends Component {
  componentDidMount() {
  }

  render() {
    return (
      <Layout>
        <Switch>
          <Route exact path="/" component={Home}/>
          <Route component={PageNotFound}/>
        </Switch>
      </Layout>
    )
  }
}

const mapDispatchToProps = dispatch => {
  return {}
}

export default withRouter(connect(null, mapDispatchToProps)(App))

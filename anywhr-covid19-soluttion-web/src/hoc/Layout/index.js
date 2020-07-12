import React, {Component} from 'react'
import Navbar from './Navbar'
import {CssBaseline} from "@material-ui/core"

class Layout extends Component {
  render() {
    return (
      <>
        <CssBaseline/>
        <Navbar/>
        <main className="app container">
          {this.props.children}
        </main>
      </>
    )
  }
}

export default Layout
